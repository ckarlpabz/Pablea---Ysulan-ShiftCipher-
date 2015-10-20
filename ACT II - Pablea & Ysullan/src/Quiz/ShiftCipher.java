/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

/**
 *
 * @author Carl Angelo Pablea & Randy Ysulan
 */
public class ShiftCipher {

    /**
     * Original PLAIN text
     */
    private String origString;
    /**
     * Encrypted String
     */
    private String cipherString;
    /**
     * Decrypted String
     */
    private String decipheredString;
    /**
     * Shift key number
     */
    private int shift;

    private String getAlphabet() {
        return "abcdefghijklmnopqrstuvwxyz";
    }

    public ShiftCipher(String plain, int shifter) {
        this.origString = plain;
        this.shift = shifter;
    }

    /**
     * This returns the letter at the shifted location
     *
     * @param int
     * @param String
     * @return int
     */
    private char shiftLetter(char origLetter, String type) {
        String alphabet = this.getAlphabet();
        int letterPosition = alphabet.indexOf(origLetter);
        char shiftedLetter;
        int shiftedPosition = 0;
        switch (type) {
            case "encrypt":
                shiftedPosition = (letterPosition + this.shift) % 26;
                break;
            case "decrypt":
                shiftedPosition = (letterPosition - this.shift) % 26;
                if (shiftedPosition < 0) {
                    shiftedPosition += 26;
                }
                break;
        }
        shiftedLetter = alphabet.charAt(shiftedPosition);
        return shiftedLetter;
    }

    /**
     * This method encrypts a string
     *
     * @param String
     * @param int
     * @return String
     */
    public void cipher() {
        this.origString = this.origString.toLowerCase();
        this.cipherString = "";
        char shiftedLetter;
        for (char letter : this.origString.toCharArray()) {
            shiftedLetter = this.shiftLetter(letter, "encrypt");
            this.cipherString += shiftedLetter;
        }
    }

    public String getCiphered() {
        return this.cipherString;
    }

    /**
     * This method decrypts an encrypted string
     *
     * @param String
     * @param int
     * @return String
     */
    public void decipher() {
        this.cipherString = this.cipherString.toLowerCase();
        this.decipheredString = "";
        char shiftedLetter;
        for (char letter : this.cipherString.toCharArray()) {
            shiftedLetter = this.shiftLetter(letter, "decrypt");
            this.decipheredString += shiftedLetter;
        }
    }

    public String getDeciphered() {
        return this.decipheredString;
    }
}
