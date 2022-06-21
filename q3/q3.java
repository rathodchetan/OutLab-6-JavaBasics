
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class q3 {

    static public boolean func1(String str) {
        int i;
        boolean valid = true;
        if (str.length() <= 5) {
            for (i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i))) {
                    valid = false;
                    break;
                }
            }
        } else
            valid = false;
        return valid;
    }

    static public boolean func2(String str) {
        boolean val_a = true;
        boolean val_b = true;
        boolean val_c = false;
        if (str.charAt(str.length() - 1) == 'c')
            val_c = true;
        else
            return false;
        if (str.charAt(str.length() - 2) == 'b') {
            for (int i = str.length() - 3; i >= 0; i--) {
                if (val_b && str.charAt(i) == 'b') {
                    continue;
                } else if (val_a && str.charAt(i) == 'a') {
                    val_b = false;
                    continue;
                } else {
                    return false;
                }

            }
            return true;
        } else
            return false;
    }

    public static boolean func3(String s) {
        int k = s.length();
        if (k % 2 == 1 || k == 0) {
            return false;
        }
        int i = 0;
        int j = k - 1;
        while (i < j) {
            if (s.charAt(i) != 'a' || s.charAt(j) != 'b') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static ArrayList<String> func4(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        ArrayList<String> list = new ArrayList<>();
        // Matching the compiled pattern in the String
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}