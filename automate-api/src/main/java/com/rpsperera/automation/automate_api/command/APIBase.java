package com.rpsperera.automation.automate_api.command;

import com.rpsperera.automation.automate_api.util.SSLContextUtils;
import com.rpsperera.automation.automate_api.util.TrustManagerHolder;
import com.rpsperera.automation.automate_api.util.TrustUtils;
import com.rpsperera.automation.automate_common.command_base.CommandBase;
import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Mapper;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class APIBase<T> extends CommandBase<T> {

    protected APIBase() {

    }

    protected String url;
    protected String body;
    protected Map<String, String> headers;
    protected Map<String, String> queryParameters;
    protected Map<String, String> pathParameters;
    protected HttpRequest.Builder request = HttpRequest.newBuilder();
    protected URIBuilder uriBuilder;
    protected HttpClient.Builder client = HttpClient.newBuilder();

    protected T setUrl(String url) {
        this.url = url;
        return (T) this;
    }

    protected T setHeader(Map<String, String> headers) {
        this.headers = headers;
        return (T) this;
    }

    protected T setQueryParams(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
        return (T) this;
    }

    protected T setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
        return (T) this;
    }

    protected T setBody(Map<String, Object> data) throws Exception {
        this.body = Mapper.getInstance().getObjectMapper().writeValueAsString(data);
        return (T) this;
    }

    protected T setBody(String body) {
        this.body = body;
        return (T) this;
    }

    protected void reset() {
        this.client = HttpClient.newBuilder();
        this.request = HttpRequest.newBuilder();
    }

    protected ResponseDTO send(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = this.client.build().send(request, HttpResponse.BodyHandlers.ofString());
        return converToResponseDTO(response);
    }

    protected ResponseDTO converToResponseDTO(HttpResponse<?> httpResponse) {
        return new ResponseDTO(httpResponse.body(), httpResponse.statusCode(), httpResponse.headers().toString());
    }

    protected boolean isSecure(String url) throws URISyntaxException, AutomateException {
        if (Objects.nonNull(url)) {
            return new URIBuilder(this.url).getScheme().equalsIgnoreCase("https");
        } else {
            throw new AutomateException("URL cannot be empty");
        }
    }

    protected void setSSLContext(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws UnrecoverableKeyException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        this.client.sslContext(SSLContextUtils.getSSLContext("SSL", TrustUtils.getKeyManagers(identityMaterialPath, identityProtocol, identityMaterialPassword), TrustManagerHolder.getInstance().getTrustManagers(), secureRandom));
    }

    protected void setSSLContextForSelfSignedCerts(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws UnrecoverableKeyException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        this.client.sslContext(SSLContextUtils.getSSLContextForSelfSignedCerts("SSL", TrustUtils.getKeyManagers(identityMaterialPath, identityProtocol, identityMaterialPassword), secureRandom));
    }

    protected void init() throws URISyntaxException, AutomateException {

        if (Objects.nonNull(this.url)) {
            //put the path parameters
            Optional.ofNullable(this.pathParameters).ifPresent(pathParams -> pathParams.forEach((k, v) -> this.url = this.url.replace("{" + k + "}", v)));
            //add the url to the builder
            this.uriBuilder = new URIBuilder(this.url);
            // set the headers
            Optional.ofNullable(this.headers).ifPresent(headers -> headers.forEach((k, v) -> this.request.header(k, v)));
            //set the query parameters
            Optional.ofNullable(this.queryParameters).ifPresent(queryParameters -> queryParameters.forEach((k, v) -> this.uriBuilder.addParameter(k, v)));
            //set the request
            this.request.uri(this.uriBuilder.build());
            //build the client
            this.client.build();
        } else {
            ExceptionUtils.generateAndThrowGenericException("URL cannot be empty");
        }
    }

}
