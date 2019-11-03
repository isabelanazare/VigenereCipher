package main;
import java.util.Scanner;

public class Main {
    /*
     Generates a new key, repeating the key until it has the same length as the plain text/cipher text.
     INPUT: COMPUTATION, DOGS
     OUTPUT: DOGSDOGSDOG
    */

    private static String generateKey(String text, String key)
    {
        int x = text.length();
        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == text.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }
    /*
    Returns encrypted text.
    Iterates through the plain text and for each letter, the position index of the letter from the alphabet is added to the position of the letter in the key
    and the sum is divided by %27.
    The identified letters are concatenated and returned as a String
    INPUT:
    PLAINTEXT: computation
    KEY: cipher
    OUTPUT:
    FXBXZKDBYWS
    */
    private static String getEncryptedText(String alphabet, String plainText, String key){
        String message="";
        for (int i = 0; i < plainText.length(); i++) {
            int encryptionNumber = (alphabet.indexOf(plainText.charAt(i)) + alphabet.indexOf(key.charAt(i)))%27;
            message = message.concat(String.valueOf(alphabet.charAt(encryptionNumber)));
        }
        return message;
    }
    /*
    Returns decrypted text.
    Iterates through the cipher text and for each letter, from the position index of the letter from the alphabet, the position of the letter in the key is subtracted,
    then 27 is added (necessary for negative numbers) and then the result is divided by %27
    The identified letters are concatenated and returned as a String
    INPUT:
    CIPHERTEXT: FXBXZKDBYWS
    KEY: cipher
    OUTPUT:
    computation
    */
    private static String getPlainText(String alphabet, String cipherText, String key){
        String message="";
        for (int i = 0; i < cipherText.length(); i++) {
            int encryptionNumber = (alphabet.indexOf(cipherText.charAt(i)) - alphabet.indexOf(key.charAt(i))+27)%27;
            message = message.concat(String.valueOf(alphabet.charAt(encryptionNumber)));
        }
        return message;
    }
    
    public static void main(String[] args) {

        String alphabet = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Welcome!\r\nEnter a number for the operation you wish to perform using the Belaso-Vegenere Cipher:\r\n1.Encrypt text\r\n2.Decrypt text\r\n3.Exit\r\nOption=");
        Scanner myInput = new Scanner( System.in );
        String command = myInput.nextLine();
        if (command.equals("1")) {
            System.out.println("Enter key:\r\nKey=");
            String keyWord = myInput.nextLine().toUpperCase();
            System.out.println(keyWord);
            System.out.println("Enter plainText:\r\nplain text=");
            String plainText = myInput.nextLine().toUpperCase();

            String[] plainTextList = plainText.split(" ");
            String key = keyWord;
            if(plainText.length()>= keyWord.length()) {
                key = generateKey(plainText, keyWord);
            }
            String finalMessage = "";

            for (String s : plainTextList) {
                finalMessage = finalMessage.concat(getEncryptedText(alphabet, s, key));
                finalMessage = finalMessage.concat(" ");
            }
            System.out.println("Encrypted text:");
            System.out.println(finalMessage);
        } else if (command.equals("2")) {
            System.out.println("Enter key:\r\nKey=");
            String keyWord = myInput.nextLine().toUpperCase();
            System.out.println(keyWord);
            System.out.println("Enter ciphertext:\r\nciphertext=");
            String ciphertext = myInput.nextLine().toUpperCase();
            System.out.println(ciphertext);
            String[] cipherTextList = ciphertext.split(" ");
            String key = keyWord;
            if(ciphertext.length()>= keyWord.length()) {
                key = generateKey(ciphertext, keyWord);
            }
            String plainMessage = "";

            for (String s : cipherTextList) {
                plainMessage = plainMessage.concat(getPlainText(alphabet, s, key));
                plainMessage = plainMessage.concat(" ");
            }
            System.out.println("Decrypted text:");
            System.out.println(plainMessage);
        }
        else {
            System.out.println("Invalid input");
        }

        label:
        while(!command.equals("3")) {
            System.out.println("Welcome!\r\nChoose option:\r\n1.Encrypt text\r\n2.Decrypt text\r\n3.Exit");
            command = myInput.nextLine();
            switch (command) {
                case "1": {
                    System.out.println("Enter key:\r\nKey=");
                    String keyWord = myInput.nextLine().toUpperCase();
                    System.out.println(keyWord);
                    System.out.println("Enter plainText:\r\nplain text=");
                    String plainText = myInput.nextLine().toUpperCase();

                    String[] plainTextList = plainText.split(" ");
                    String key = keyWord;
                    if (plainText.length() >= keyWord.length()) {
                        key = generateKey(plainText, keyWord);
                    }

                    String finalMessage = "";

                    for (String s : plainTextList) {
                        finalMessage = finalMessage.concat(getEncryptedText(alphabet, s, key));
                        finalMessage = finalMessage.concat(" ");
                    }
                    System.out.println("Encrypted text:");
                    System.out.println(finalMessage);
                    break;
                }
                case "2": {
                    System.out.println("Enter key:\r\nKey=");
                    String keyWord = myInput.nextLine().toUpperCase();
                    System.out.println(keyWord);
                    System.out.println("Enter ciphertext:\r\nciphertext=");
                    String ciphertext = myInput.nextLine().toUpperCase();
                    System.out.println(ciphertext);
                    String[] cipherTextList = ciphertext.split(" ");
                    String key = keyWord;
                    if (ciphertext.length() >= keyWord.length()) {
                        key = generateKey(ciphertext, keyWord);
                    }

                    String plainMessage = "";

                    for (String s : cipherTextList) {
                        plainMessage = plainMessage.concat(getPlainText(alphabet, s, key));
                        plainMessage = plainMessage.concat(" ");
                    }
                    System.out.println("Decrypted text:");
                    System.out.println(plainMessage);
                    break;
                }
                case "3":
                    break label;
                default:
                    System.out.println("Invalid input");
                    break;
            }

   }

    }
}
