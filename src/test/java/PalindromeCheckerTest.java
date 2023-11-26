import org.example.PalindromeChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PalindromeCheckerTest {

    @Test
    public void testIsPalindromeWithPalindromes() {
        assertTrue(PalindromeChecker.isPalindrome("radar"));
        assertTrue(PalindromeChecker.isPalindrome("level"));
        assertTrue(PalindromeChecker.isPalindrome("Able was I ere I saw Elba"));
    }

    @Test
    public void testIsPalindromeWithNonPalindromes() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("world"));
    }

    @Test
    public void testIsPalindromeWithMixedCase() {
        assertTrue(PalindromeChecker.isPalindrome("Madam"));
        assertTrue(PalindromeChecker.isPalindrome("Racecar"));
    }

    @Test
    public void testIsPalindromeWithSpaces() {
        assertTrue(PalindromeChecker.isPalindrome("Was it a car or a cat I saw"), "The string is expected to be a palindrome");
    }

}
