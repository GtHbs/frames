package mybatis.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭类
 *
 * @author 李昭
 */
public class ResourceClose {

    public static void close(Closeable... resource) {
        for (Closeable closeable : resource) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
