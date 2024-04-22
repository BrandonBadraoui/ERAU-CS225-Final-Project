/***********************************
 * Filename: Alphabet
 * Author: Brandon Badraoui
 * Collaborators:
 * Created: 3/25/2024
 * Modified: 4/17/2024
 * Purpose: Acts as a database class for alphabet information. Also handles file I/O.
 * <p>
 * Attributes:
 * -alphabet: char[]
 * -stringAsChar: char[]
 * -stringAsNum: int[]
 * -CipherText: char[]
 * <p>
 * Methods:
 * -initArray(int): void
 * +setStringAsChar(char[]): void
 * +getStringAsChar(): char[]
 * +getStringAsNum(): int[]
 * -letterToNum(): void
 * +numToLetter(int[]): char[]
 * +runAlpha(int,String): void
 * -parseDataFromFile(String): String
 * -getInput(String): ArrayList<String>
 * +outputToFile(String,Int[]): void
 ***********************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Alphabet {
    private final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private char[] stringAsChar;
    private int[] stringAsNum;

    private void initArray(int stringAsNum) {
        this.stringAsNum = new int[stringAsNum];
    }

    public void setStringAsChar(char[] stringAsChar) {
        this.stringAsChar = stringAsChar;
    }

    public char[] getStringAsChar() {
        return stringAsChar;
    }

    public int[] getStringAsNum() {
        return stringAsNum;
    }

    private void letterToNum() {
        int x = 0;
        for (int i = 0; i < stringAsChar.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (stringAsChar[i] == alphabet[j]) {
                    stringAsNum[x] = j;
                    x++;
                }
            }
        }
    }

    public char[] numToLetter(int[] intArray) {
        char[] cipherText = new char[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            cipherText[i] = alphabet[intArray[i]];
        }
        return cipherText;
    }

    public void runAlpha(int type, String temp) {
        if (type == 2) {
            temp = parseDataFromFile("UnencryptedString.txt");
        }
//        System.out.println(temp); // Used for testing purposes to show what is being printed.
        setStringAsChar(temp.toCharArray());
        initArray(getStringAsChar().length);
        letterToNum();
    }

    public void outputToFile(String filename, char[] cipheredText) {
        try {
            File file = new File(filename);
            PrintWriter pw = new PrintWriter(file);
            pw.print("Your encrypted string is: ");
            pw.print(cipheredText);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseDataFromFile(String filename) {
        ArrayList<String> data = getInput(filename);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) != null) {
                return data.get(i).toLowerCase().replaceAll("[^a-zA-Z0-9_-]", " ");
            }
        }
        return null;
    }

    private ArrayList<String> getInput(String filename) {
        ArrayList<String> data = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine().trim();
                data.add(line);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }

        return data;
    }
}
