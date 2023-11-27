package com.rpsperera.automation.automate_common.dto;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseDTO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseDTO.class);

    private Object data = "";
    private Integer statusCode = 200;
    private String status = "Success";
    private Map<String, List<String>> headers = new HashMap<>();


    public ResponseDTO() {
    }

    public ResponseDTO(Object data, Integer statusCode, String status) {
        this.data = data;
        this.statusCode = statusCode;
        this.status = status;
    }

    public ResponseDTO(Object data, Integer statusCode, String status, Map<String, List<String>> headers) {
        this.data = data;
        this.statusCode = statusCode;
        this.status = status;
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "data=" + data +
                ", statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", headers=" + headers +
                '}';
    }

    public Object getData() {
        return data;
    }

    public JsonPath getDataAsJsonPath() {
        return JsonPath.from(String.valueOf(this.data));
    }

    public XmlPath getDataAsXmlPath() {
        return XmlPath.from(String.valueOf(this.data));
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }
}
