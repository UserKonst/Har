package harviewer.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Optional;

/**
 *
 * @author kkovbasa
 */
public class HARUtils {

    public static boolean saveHar(final String path, final String har) {
        boolean isSaved;

        Optional.ofNullable(new File(path).getParent())
                .map(File::new)
                .filter(dir -> !dir.exists())
                .ifPresent(File::mkdirs);

        try (final FileWriter writer = new FileWriter(path)) {
            writer.write("onInputData(" + har + ")");
            isSaved = true;
        } catch (Exception ex) {
            isSaved = false;
        }

        return isSaved;
    }
}
