package eu.szestkam.cryptotraining.matrix;

public class MatrixCipher {

        private String data;

        public MatrixCipher() {
            data = "";
        }

        public MatrixCipher(String messege) {
            this.data = messege;
        }

        String encode() {
            int size = (int)Math.ceil(Math.sqrt(data.length()));
            if (size < 2) return data;
            StringBuilder sb = new StringBuilder(data);
            while (sb.length() != size * size) {
                sb.append(" ");
            }
            char[] chars = new char[sb.length()];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    char ch = sb.toString().charAt(i + size * j);
                    chars[i * size + j] = ch;
                }
            }
            return String.valueOf(chars).replace(" ", "");
        }
    }

