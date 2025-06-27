public class ValidPalindrome {
    public static void main(String[] args) {
        String sentence = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(sentence));
    }
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        // Remove all non-alphanumeric characters and convert to lowercase
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Check if the cleaned string is a palindrome
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}
