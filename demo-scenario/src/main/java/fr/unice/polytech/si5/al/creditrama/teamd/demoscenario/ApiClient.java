package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiClient {
    protected ObjectMapper objectMapper;
    private String basePath = "http://localhost:8080";
    private Map<String, RequestInterceptor> apiAuthorizations;
    private Feign.Builder feignBuilder;

    public ApiClient() {
        objectMapper = createObjectMapper();
        apiAuthorizations = new LinkedHashMap<>();
        feignBuilder = Feign.builder()
                .client(new ApacheHttpClient())
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .logger(new Slf4jLogger()).logLevel(Logger.Level.BASIC);
    }

    public ApiClient(String[] authNames) {
        this();
        for (String authName : authNames) {
            throw new RuntimeException("auth name \"" + authName + "\" not found in available auth names");
        }
    }

    /**
     * Basic constructor for single auth name
     *
     * @param authName
     */
    public ApiClient(String authName) {
        this(new String[]{authName});
    }

    public String getBasePath() {
        return basePath;
    }

    public ApiClient setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    public Map<String, RequestInterceptor> getApiAuthorizations() {
        return apiAuthorizations;
    }

    public void setApiAuthorizations(Map<String, RequestInterceptor> apiAuthorizations) {
        this.apiAuthorizations = apiAuthorizations;
    }

    public Feign.Builder getFeignBuilder() {
        return feignBuilder;
    }

    public ApiClient setFeignBuilder(Feign.Builder feignBuilder) {
        this.feignBuilder = feignBuilder;
        return this;
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new RFC3339DateFormat());
        return objectMapper;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Creates a feign client for given API interface.
     * <p>
     * Usage:
     * ApiClient apiClient = new ApiClient();
     * apiClient.setBasePath("http://localhost:8080");
     * XYZApi api = apiClient.buildClient(XYZApi.class);
     * XYZResponse response = api.someMethod(...);
     *
     * @param <T>         Type
     * @param clientClass Client class
     * @return The Client
     */
    public <T extends Api> T buildClient(Class<T> clientClass) {
        return feignBuilder.target(clientClass, basePath);
    }

    /**
     * Creates a feign client for given API interface.
     * <p>
     * Usage:
     * ApiClient apiClient = new ApiClient();
     * apiClient.setBasePath("http://localhost:8080");
     * XYZApi api = apiClient.buildClient(XYZApi.class);
     * XYZResponse response = api.someMethod(...);
     *
     * @param <T>         Type
     * @param clientClass Client class
     * @return The Client
     */
    public <T extends Api> T buildClient(Class<T> clientClass, Logger.Level level) {
        feignBuilder.logLevel(level);
        return feignBuilder.target(clientClass, basePath);
    }

    /**
     * Select the Accept header's value from the given accepts array:
     * if JSON exists in the given array, use it;
     * otherwise use all of them (joining into a string)
     *
     * @param accepts The accepts array to select from
     * @return The Accept header to use. If the given array is empty,
     * null will be returned (not to set the Accept header explicitly).
     */
    public String selectHeaderAccept(String[] accepts) {
        if (accepts.length == 0) return null;
        if (StringUtil.containsIgnoreCase(accepts, "application/json")) return "application/json";
        return StringUtil.join(accepts, ",");
    }

    /**
     * Select the Content-Type header's value from the given array:
     * if JSON exists in the given array, use it;
     * otherwise use the first one of the array.
     *
     * @param contentTypes The Content-Type array to select from
     * @return The Content-Type header to use. If the given array is empty,
     * JSON will be used.
     */
    public String selectHeaderContentType(String[] contentTypes) {
        if (contentTypes.length == 0) return "application/json";
        if (StringUtil.containsIgnoreCase(contentTypes, "application/json")) return "application/json";
        return contentTypes[0];
    }

    public interface Api {
    }


}
