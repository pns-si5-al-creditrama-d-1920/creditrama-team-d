package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.nio.charset.Charset;

import static feign.Util.ISO_8859_1;
import static feign.Util.checkNotNull;

public class BasicAuthRequestInterceptor implements RequestInterceptor {
    public static String token = null;
    private final String headerValue;

    /**
     * Creates an interceptor that authenticates all requests with the specified username and password
     * encoded using ISO-8859-1.
     *
     * @param username the username to use for authentication
     * @param password the password to use for authentication
     */
    public BasicAuthRequestInterceptor(String username, String password) {
        this(username, password, ISO_8859_1);
    }

    /**
     * Creates an interceptor that authenticates all requests with the specified username and password
     * encoded using the specified charset.
     *
     * @param username the username to use for authentication
     * @param password the password to use for authentication
     * @param charset  the charset to use when encoding the credentials
     */
    public BasicAuthRequestInterceptor(String username, String password, Charset charset) {
        checkNotNull(username, "username");
        checkNotNull(password, "password");
        this.headerValue = "Basic " + base64Encode((username + ":" + password).getBytes(charset));
    }

    /*
     * This uses a Sun internal method; if we ever encounter a case where this method is not
     * available, the appropriate response would be to pull the necessary portions of Guava's
     * BaseEncoding class into Util.
     */
    private static String base64Encode(byte[] bytes) {
        return Base64.encode(bytes);
    }

    @Override
    public void apply(RequestTemplate template) {
        if (token == null) {
            template.header("Authorization", headerValue);
        } else {
            template.header("Authorization", "Bearer " + token);
        }
    }
}