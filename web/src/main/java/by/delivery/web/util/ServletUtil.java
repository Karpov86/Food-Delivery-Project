package by.delivery.web.util;

public final class ServletUtil {

    private static final String PREFIX = "/src/main/webapp/WEB-INF/jsp/";
    private static final String SUFFIX = ".jsp";

    private ServletUtil() {
    }

    public static String createViewPath(String viewName) {
        return String.format("%s%s%s", PREFIX, viewName, SUFFIX);
    }
}
