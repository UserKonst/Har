package harviewer.utils;

import static com.google.common.io.Files.toByteArray;
import static utils.TemplateUtils.execute;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 *
 * @author kkovbasa
 */
public class AttachHar {

    public static final String HAR_TEMPLATE = "templates/har.mustache";
    public static final String WORK_DIR = System.getProperty("user.home") + "/Work";

    private static final AtomicInteger COUNTER = new AtomicInteger();

    private AttachHar() {
        throw new UnsupportedOperationException("Illegal access to private constructor");
    }

    @Attachment(value = "{0}", type = "text/html")
    public static byte[] attachHtml(final String name, final String templateName, final Map<String, Object> args) {
        final String outName = "target" + File.separator + "attachment" + COUNTER.incrementAndGet();
        try {
            execute(templateName, outName, args);
            return toByteArray(new File(outName));
        } catch (Exception ignored) {
            return new byte[0];
        }
    }
}
