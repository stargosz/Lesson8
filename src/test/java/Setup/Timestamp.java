package Setup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {
    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
