package utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class FileSystemUtil {
    public static boolean deleteLocalFile(String path) {
        Configuration configuration = new Configuration();
        boolean flag=false;
        try {
            LocalFileSystem localFileSystem = FileSystem.getLocal(configuration);
            if (localFileSystem.exists(new Path(path))) {
                localFileSystem.delete(new Path(path));
                flag=true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
