package eu.szestkam.cryptotraining.cesar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CezarCipherTest {

    public static final String SAMPLE_PHRASE = "sample";
    private CezarCipher cipherNoArg;
    private CezarCipher cipherPhrase;

    @BeforeEach
    void setUp(){
        cipherNoArg = new CezarCipher();
        cipherPhrase = new CezarCipher(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    public void testIfCesarExist(){
        CezarCipher cipher = cipherNoArg;
        assertNotNull (cipher);
    }

    @DisplayName("Correct cipher instance with phrase")
    @Test
    public void testPassStringToConstructor(){
        CezarCipher cipher = cipherPhrase;
        assertNotNull (cipher);
    }

    @DisplayName("Correct encrypt with no text")
    @Test
    public void testEncryptWhenNoTextThenEmptyString(){
        CezarCipher cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("",encoded);
    }

    @Test
    public void testEncryptWhenTextThenSameLenghtString() {
        CezarCipher cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }
    @Test
    public void testSimpleDeEncodeLowerCase(){
        CezarCipher cipher = new CezarCipher("abc");
        String code = "def";
        String encoded = cipher.encode();

        assertEquals(code, encoded);

        cipher = cipher = new CezarCipher("xyz");
        code = "abc";
        encoded = cipher.encode();
        assertEquals(code, encoded);

    }
    @Test
    public void testSimpleDeEncodeMixedCase(){
        CezarCipher cipher = new CezarCipher("abC");
        String code = "deF";
        String encoded = cipher.encode();

        assertEquals(code, encoded);

        cipher = new CezarCipher("XYz");
        code = "ABc";
        encoded = cipher.encode();
        assertEquals(code, encoded);
    }

    @Test
    public void testSimpleEncodeMixedCase(){
        CezarCipher cipher = new CezarCipher("deF");
        String code = "abC";
        String encodedE = cipher.encodeE();

        assertEquals(code, encodedE);

        cipher = new CezarCipher("ABc");
        code = "XYz";
        encodedE = cipher.encodeE();
        assertEquals(code, encodedE);

    }
}