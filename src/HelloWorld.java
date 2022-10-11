import java.util.regex.Pattern;

public class HelloWorld {
    public static void main(String[] args) {
        String pattern = "^[1-9]*$"; // 숫자만 등장하는지
        String str = " 432";

        boolean result = Pattern.matches(pattern, str);
        System.out.println(result); // true
    }
}
