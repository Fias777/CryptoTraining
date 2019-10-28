package eu.szestkam.cryptotraining.AtBash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtBashCiperTest {

    private static final String SAMPLE_PHRASE = "sample";
    private AtBashCiper cipherNoArg;
    private AtBashCiper cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new AtBashCiper();
        cipherPhrase = new AtBashCiper(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfAtBashExist() {
        AtBashCiper cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        AtBashCiper cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncryptWhenNoTextThenEmptyString() {
        AtBashCiper cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncryptWhenTextThenSameLengthOfString() {
        AtBashCiper cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertEquals("zyxv", new AtBashCiper("abcd").encode());
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("KpGt", new AtBashCiper("PkTg").encode());
    }

    @Test
    void digitsEncodeTest() {
        assertEquals("9876", new AtBashCiper("0123").encode());
        assertEquals("0123", new AtBashCiper("9876").encode());
    }

    @Test
    void otherSymbolEncodeTest() {
        assertEquals("56v^D:<u&*", new AtBashCiper("43d^V:<f&*").encode());
    }

    @Test
    void lowerLetterDecodeTest() {
        assertEquals("abcd", new AtBashCiper("zyxv").encode());
    }

    @Test
    void mixedLetterDecodeTest() {
        assertEquals("CxIn", new AtBashCiper("XcRm").encode());
    }
}