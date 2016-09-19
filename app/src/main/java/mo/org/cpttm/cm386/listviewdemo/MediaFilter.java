package mo.org.cpttm.cm386.listviewdemo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by cm386-08-2016-c on 10/9/2016.
 */
public class MediaFilter implements FilenameFilter{
    @Override
    public boolean accept(File file, String filename) {
        if (filename.endsWith(".mp3") || filename.endsWith(".mp4")){
            return true;
        }
        return false;
    }
}
