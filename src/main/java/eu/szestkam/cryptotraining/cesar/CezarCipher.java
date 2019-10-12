package eu.szestkam.cryptotraining.cesar;

public class CezarCipher {

    private final String ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String phrase;

    CezarCipher(String text) {
        this.phrase = text;

    }

    CezarCipher() {
        phrase = "";

    }

    public String encode() {
        String code = "";

        char[] letters = phrase.toCharArray();
        for (char letter : letters) {
            boolean isLower = Character.isLowerCase(letter);
            Character _char = Character.toUpperCase(letter);
            int val = ALFABET.indexOf(_char);
            int newVal = (val + 3) % 26;
            String newLetter = String.valueOf(ALFABET.charAt(newVal));
            code += (isLower) ? newLetter.toLowerCase() : newLetter.toUpperCase();
        }

        return code;
    }
    public String encodeE() {
        String code = "";

        char[] letters = phrase.toCharArray();
        for (char letter : letters) {
            boolean isLower = Character.isLowerCase(letter);
            Character _char = Character.toUpperCase(letter);
            int val = ALFABET.indexOf(_char);
            int newVal = (val + 23) % 26;
            String newLetter = String.valueOf(ALFABET.charAt(newVal));
            code += (isLower) ? newLetter.toLowerCase() : newLetter.toUpperCase();
        }

        return code;
    }
}
