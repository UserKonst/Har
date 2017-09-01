package harviewer.proxy;

import harviewer.annotations.CaptureTraffic;

public class AnnotationUtils {

    public static boolean isContainsFilters(CaptureTraffic annotation) {
        return !annotation.requestMethod().isEmpty()
                || annotation.responseCode() != 0
                || !annotation.resposneMessage().isEmpty();
    }

}
