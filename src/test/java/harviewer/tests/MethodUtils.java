package harviewer.tests;

import java.lang.reflect.Method;
import da.newpm.annotations.CaptureTraffic;

/**
 *
 * @author kkovbasa
 */
public class MethodUtils {

    public static CaptureTraffic getRecordTrafficAnnotation(Method m) {
        return m.getAnnotation(CaptureTraffic.class);
    }

    public static boolean isAnnotated(Method method, Class annotation) {
        return method.getAnnotation(annotation) != null;
    }

}
