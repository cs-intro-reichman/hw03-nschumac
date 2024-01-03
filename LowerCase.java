/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(lowerCase(str));
    }

    /**
     * Returns a string which is identical to the original string, except that all
     * the upper-case letters are converted to lower-case letters. Non-letter
     * characters are left as is.
     */
    public static String lowerCase(String s) {
        // return s.toLowerCase();
        String lowercase = "";

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                lowercase += (char) ((int) s.charAt(i)
                        + ((int) 'a' - (int) 'A'));
            } else {
                lowercase += s.charAt(i);
            }
        }
        return lowercase;
    }
}
