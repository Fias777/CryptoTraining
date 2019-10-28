package eu.szestkam.cryptotraining.vigenere;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VigenereCipher {

    private String key = "passwordtoencode";
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private String data;

    public VigenereCipher(String data) {
        this.data = data;
    }

    public VigenereCipher() {
        this.data = "";
    }

    String encode() {
        StringBuilder build = new StringBuilder();
        int index;
        boolean isLowerCase;
        char _char;
        for (int i = 0; i < data.length(); i++) {
            _char = data.charAt(i);
            if (ALPHABET.contains(String.valueOf(_char).toLowerCase())) {
                isLowerCase = Character.isLowerCase(_char);
                index = (ALPHABET.indexOf(String.valueOf(_char).toLowerCase())
                        + ALPHABET.indexOf(key.charAt(i % key.length()))) % 26;
                if (isLowerCase) {
                    build.append(ALPHABET.charAt(index));
                } else {
                    build.append(ALPHABET.toUpperCase().charAt(index));
                }
            } else {
                build.append(_char);
            }
        }
        return build.toString();
    }

    String decode() {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (ALPHABET.contains(String.valueOf(c).toLowerCase())) {
                boolean lowerCase = Character.isLowerCase(c);
                int index = (ALPHABET.indexOf(String.valueOf(c).toLowerCase())
                        + 26 - ALPHABET.indexOf(key.charAt(i % key.length()))) % 26;
                build.append(lowerCase ? ALPHABET.charAt(index) : ALPHABET.toUpperCase().charAt(index));
            } else {
                build.append(c);
            }
        }
        return build.toString();
    }
}