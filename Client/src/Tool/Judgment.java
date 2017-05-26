package Tool;

import java.util.regex.Pattern;

/**
 * Created by yunhan on 2017/4/28.
 */
public class Judgment {
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
