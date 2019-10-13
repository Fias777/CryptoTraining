package eu.szestkam.cryptotraining.rot_13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13Test {

    private static final String SAMPLE_PHRASE = "sample";
    private Rot13 cipher13NoArg;
    private Rot13 cipher13Phrase;

    @BeforeEach
    void setUp() {
        cipher13NoArg = new Rot13();
        cipher13Phrase = new Rot13(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher13 instance with no args")
    @Test
    public void testIfCesarExist() {
        Rot13 cipher13 = cipher13NoArg;
        assertNotNull(cipher13);
    }

    @DisplayName("Correct cipher13 instance with phrase")
    @Test
    public void testPassStringToConstructor() {
        Rot13 cipher13 = cipher13Phrase;
        assertNotNull(cipher13);
    }

    @DisplayName("Correct cipher13 empty string")
    @Test
    public void testEncrypWhenNoTextThenEmptyString() {
        Rot13 cipher13 = cipher13NoArg;
        String encoded13 = cipher13.encode13();

        assertNotNull(encoded13);
        assertEquals("", encoded13);
    }

    @DisplayName("Correct cipher13 the same lenght of string")
    @Test
    public void testEncrypWhenTextThenSameLenghtOfString() {
        Rot13 cipher13 = cipher13Phrase;
        String encoded13 = cipher13.encode13();

        assertNotNull(encoded13);
        assertEquals(SAMPLE_PHRASE.length(), encoded13.length());
    }

    @DisplayName("Correct cipher13 lower case")
    @Test
    public void testSimpleEncodeLowerCase() {
        Rot13 cipher13 = new Rot13("abc");
        String code13 = "nop";
        String encoded13 = cipher13.encode13();
        assertEquals(code13, encoded13);

        cipher13 = new Rot13("xyz");
        code13 = "klm";
        encoded13 = cipher13.encode13();
        assertEquals(code13, encoded13);
    }

    @DisplayName("Correct cipher13 encode mixed case")
    @Test
    public void testSimpleEncodeMixedCase() {
        Rot13 cipher13 = new Rot13("abC");
        String code13 = "noP";
        String encoded13 = cipher13.encode13();
        assertEquals(code13, encoded13);

        cipher13 = new Rot13("XYz");
        code13 = "KLm";
        encoded13 = cipher13.encode13();
        assertEquals(code13, encoded13);
    }

    @DisplayName("Correct cipher13 return empty string")
    @Test
    public void testDecrypWhenNoTextThenEmptyString() {
        Rot13 cipher13 = cipher13NoArg;
        String decoded13 = cipher13.decrypt13();

        assertNotNull(decoded13);
        assertEquals("", decoded13);
    }

    @DisplayName("Correct cipher13 decode mixed case")
    @Test
    public void testSimpleDecodeMixedCase() {
        Rot13 cipher13 = new Rot13("noP");
        String code13 = "abC";
        String encoded13 = cipher13.decrypt13();
        assertEquals(code13, encoded13);

        cipher13 = new Rot13("KLm");
        code13 = "XYz";
        encoded13 = cipher13.decrypt13();
        assertEquals(code13, encoded13);
    }
}