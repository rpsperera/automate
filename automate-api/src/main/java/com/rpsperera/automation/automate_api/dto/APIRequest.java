package com.rpsperera.automation.automate_api.dto;

import java.security.SecureRandom;
import java.util.Map;

public class APIRequest {

    public String url;

    public String body;

    public Map<String, String> headers;
    public Map<String, String> queryParameters;
    public Map<String, String> pathParameters;
    public String certPath;
    public String certPassword;
    public String certProtocol;
    public SecureRandom secureRandom;

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public String getCertPath() {
        return certPath;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public String getCertProtocol() {
        return certProtocol;
    }

    public SecureRandom getSecureRandom() {
        return secureRandom;
    }

    public APIRequest(Builder builder) {
        this.url = builder.url;
        this.body = builder.body;
        this.headers = builder.headers;
        this.queryParameters = builder.queryParameters;
        this.pathParameters = builder.pathParameters;
        this.certPassword = builder.certPassword;
        this.certPath = builder.certPath;
        this.certProtocol = builder.certProtocol;
        this.secureRandom = builder.secureRandom;
    }

    public static class Builder {

        private String url;
        private String body;
        private Map<String, String> headers;
        private Map<String, String> queryParameters;
        private Map<String, String> pathParameters;
        private String certPath;
        private String certPassword;
        private String certProtocol;
        private SecureRandom secureRandom;

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder setQueryParameters(Map<String, String> queryParameters) {
            this.queryParameters = queryParameters;
            return this;
        }

        public Builder setPathParameters(Map<String, String> pathParameters) {
            this.pathParameters = pathParameters;
            return this;
        }

        public Builder setCertPath(String certPath) {
            this.certPath = certPath;
            return this;
        }

        public Builder setCertPassword(String certPassword) {
            this.certPassword = certPassword;
            return this;
        }

        public Builder setCertProtocol(String certProtocol) {
            this.certProtocol = certProtocol;
            return this;
        }

        public Builder setSecureRandom(SecureRandom secureRandom) {
            this.secureRandom = secureRandom;
            return this;
        }
    }
}
