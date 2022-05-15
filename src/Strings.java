import java.util.Scanner;

public class Strings {

    public static String encode(String message, int threshold) {
        String encoded = "";
        for (int i = 0; i < message.length(); i++) {
            int ascii = message.charAt(i) + threshold;
            if (ascii == 96) {
                ascii = 122;
            }
            if (ascii <= 122) {
                encoded += (char) ascii;
            } else {
                encoded += (char) (96 + (ascii % 122));
            }
        }

        return encoded;
    }

    public static String decode(String message, int threshold) {
        return encode(message, -(threshold));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Encoding Message");
        System.out.println("Enter Your Message ");
        String message = scanner.nextLine();
        String encodedMessage = encode(message, 2);

        System.out.println("Encoded Message : " + encodedMessage);
        System.out.println("Decoded Message: " + decode(encodedMessage, 2));

    }
}
