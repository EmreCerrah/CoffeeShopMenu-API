package tr.com.api_coffee_shop.util;

import org.springframework.beans.factory.annotation.Value;

public class PathConstant {
    @Value("${coffee.app.frontend}")
    public static String CORS_URL;
    public static final String CORS_HEADERS = "*";
    public static final String BASE_ENDPOINT_PROD = "/api/v1";

}
