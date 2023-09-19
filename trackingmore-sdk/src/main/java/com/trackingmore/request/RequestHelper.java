package com.trackingmore.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackingmore.TrackingMore;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;
import com.trackingmore.utils.JsonUtils;
import com.trackingmore.utils.StrUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class RequestHelper {

    private String apiBaseUrl = "api.trackingmore.com";

    private String apiVersion = "v4";

    private Integer apiPort = 443;

    private String url;

    private Map<String, String> headers;

    protected ObjectMapper objectMapper;

    public RequestHelper(){
        this.objectMapper = new ObjectMapper();
    }

    private void setRequestUrl(String path) {
        String port = apiPort == 443 ? "https" : "http";
        this.url = port + "://" + apiBaseUrl + "/" + apiVersion + path;
    }

    private void setRequestHeader(String apiKey) {
        this.headers = new HashMap<>();
        this.headers.put("Content-Type", "application/json");
        this.headers.put("Accept", "application/json");
        this.headers.put("Tracking-Api-Key", apiKey);
    }

    public <T> String sendApiRequest(String path, String method, T queryParam, T requestData) throws IOException{

        setRequestUrl(path);

        setRequestHeader(TrackingMore.apiKey);

        HttpURLConnection connection = null;
        try {

            if (queryParam!=null){
                url += "?" + JsonUtils.convertToQueryString(queryParam);
            }

            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod(method);

            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            if (requestData != null) {
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                String requestBody = objectMapper.writeValueAsString(requestData);
                os.write(requestBody.getBytes(StandardCharsets.UTF_8));
                os.flush();
                os.close();
            }

            int responseCode = connection.getResponseCode();
            String responseBody = "";
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                responseBody = response.toString();
            }else {

                BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String errorLine;
                StringBuilder errorResponse = new StringBuilder();

                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine);
                }

                errorReader.close();

                responseBody = errorResponse.toString();
            }

            return responseBody;
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
