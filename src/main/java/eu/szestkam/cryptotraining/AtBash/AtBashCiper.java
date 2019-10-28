package eu.szestkam.cryptotraining.AtBash;

public class AtBashCiper {

    private String data = "";
    private String digits = "0123456789";
    private String letter = "abcdefghijklmnopqrstuwvxyz";

    public AtBashCiper(String message) {
        this.data = message;
    }

    public AtBashCiper() {
    }

    String encode() {
        StringBuilder sb = new StringBuilder();
        for (char ch : data.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = 25 - letter.indexOf(String.valueOf(ch).toLowerCase());
                if (Character.isLowerCase(ch)) {
                    sb.append(letter.charAt(index));
                } else {
                    sb.append(letter.toUpperCase().charAt(index));
                }
            } else if (Character.isDigit(ch)) {
                sb.append(digits.charAt(9 - digits.indexOf(ch)));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
