package harviewer.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface CaptureTraffic {

    String whiteList() default "";
    
    String requestMethod() default "";

    int responseCode() default 0;

    String resposneMessage() default "";

}
