package dat3.experiments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSanitizerTest {

    @Test
    void simpleSanitize() {
    }

    void simpleSanitizeTest() {
        String result = SimpleSanitizer.simpleSanitize("Hello <b>World</b>");
        assertEquals("Hello World",result);

        String result2 = SimpleSanitizer.simpleSanitize("Hello <p>World<p>");
        assertEquals("Hello <p>World<p>",result2);
    }
}