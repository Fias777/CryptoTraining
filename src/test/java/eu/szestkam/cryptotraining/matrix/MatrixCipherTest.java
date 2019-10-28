package eu.szestkam.cryptotraining.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCipherTest {

    private static final String SAMPLE_PHRASE = "sample";
    private MatrixCipher cipherNoArg;
    private MatrixCipher cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new MatrixCipher();
        cipherPhrase = new MatrixCipher(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    void testIfCesarExist() {
        MatrixCipher cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    void testPassStringToConstructor() {
        MatrixCipher cipher = cipherPhrase;
        assertNotNull(cipher);
    }

    @Test
    void testEncryptWhenNoText() {
        MatrixCipher cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    void testEncryptWhenTextTheSameLengthOfString() {
        MatrixCipher cipher = cipherPhrase;
        String encoded = cipher.encode();
        int size = (int)Math.ceil(Math.sqrt(cipher.encode().length()));

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }


    @Test
    void lowerLetterEncodeTest() {
        assertEquals("arcdfe", new MatrixCipher("acfrde").encode());
    }

    @Test
    void mixedLetterEncodeTest() {
        assertEquals("AyStalttungmrryoyuycrikDh",
                new MatrixCipher("AlgorytmyiStrukturyDanych").encode());
    }


    @Test
    void lowerLetterDecodeTest() {
        assertEquals("abcdw",
                new MatrixCipher("ad bw c").encode());
    }

    @Test
    void mixedLetterDecodeTest() {
        assertEquals("AlgorytmyiStrukturyDanych",
                new MatrixCipher("AyStalttungmrryoyuycrikDh").encode());
    }
}