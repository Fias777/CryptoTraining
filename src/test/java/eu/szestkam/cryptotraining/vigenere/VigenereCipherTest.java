package eu.szestkam.cryptotraining.vigenere;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VigenereCipherTest {

    private static final String SAMPLE_PHRASE = "sample";
    private VigenereCipher cipherNoArg;
    private VigenereCipher cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new VigenereCipher();
        cipherPhrase = new VigenereCipher(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfVigenereExist() {
        VigenereCipher cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        VigenereCipher cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncrypWhenNoTextThenEmptyString() {
        VigenereCipher cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncrypWhenTextThenSameLenghtOfString() {
        VigenereCipher cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertEquals("kkhfi", new VigenereCipher("abcdw").encode());
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("kkhFI", new VigenereCipher("abcDW").encode());
    }

    @Test
    void otherSymbolEncodeTest() {
        assertEquals("73127&(*&*(*", new VigenereCipher("73127&(*&*(*").encode());
    }

    @Test
    void lowerLetterDecodeTest() {
        assertEquals("abcdw", new VigenereCipher("kkhfi").decode());
    }

    @Test
    void mixedLetterDecodeTest() {
        assertEquals("abcDW", new VigenereCipher("kkhFI").decode());
    }

    @Test
    void otherSymbolDecodeTest() {
        assertEquals("73127&(*&*(*", new VigenereCipher("73127&(*&*(*").encode());
    }

}