package File;

import java.io.File;
import java.io.FileFilter;

public class util implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java");
    }
}
