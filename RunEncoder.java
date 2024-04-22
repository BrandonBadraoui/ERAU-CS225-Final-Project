/***********************************
 * Filename: RunEncoder
 * Author: Brandon Badraoui
 * Collaborators:
 * Created: 3/25/2024
 * Modified: 4/14/24
 * Purpose: Facilitates the running of the encoder program. Acts as an application class
 * <p>
 * Attributes:
 * -uiCheck: String
 * -userInput: String
 * -selectedCipher: int
 * -typeImport: int
 * <p>
 * Methods:
 * +main(String[] args): void
 * -runType1(int): void
 * -runType2(int): void
 * -typeStringCheck(): void
 * -typeString(): void
 * -getCipherUserInput(String): int
 * -getTypeImport(String): int
 * +getUserInput(): String
 * +setTypeImport(int): void
 ***********************************/

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RunEncoder {
    private String uiCheck = "N";
    private String userInput = "";
    private int selectedCipher;
    private int typeImport;

    public static void main(String[] args) {
        int runAgain = 0;
        RunEncoder run = new RunEncoder();
        do {

            run.selectedCipher = run.getCipherUserInput("\nHello, welcome to the Badraoui Encryption Software!\nWhat Cipher would you like to select?\n1.Caesar Cipher (Weak)\n2.XOR Cipher (Moderate)\n3.Hill Cipher (Strong)");
            run.setTypeImport(run.getTypeImport("\nWould you like to type a string or import a file?\n1.Type a string\n2.Import a file"));
            if (run.typeImport == 1) {
                run.runType1(run.selectedCipher);
            } else if (run.typeImport == 2) {
                run.runType2(run.selectedCipher);
            }
            runAgain = run.checkRunAgain("Would you like to encrypt again? (Type either 1 or 2)\n1.No\n2.Yes");
        }
        while (runAgain == 2);
    }

    private void runType1(int selectedCipher) {
        Path path = Paths.get("EncryptedString.txt");
        Alphabet al = new Alphabet();
        CaesarCipher cc = new CaesarCipher();
        XORCipher xc = new XORCipher();
        HillCipher hc = new HillCipher();
        do {
            typeString();
            typeStringCheck();
        } while (uiCheck.equals("N"));
        if (selectedCipher == 1) {
            al.runAlpha(typeImport, getUserInput());
            cc.runCipher(al.getStringAsNum());
            char[] CipheredText = al.numToLetter(cc.getCcCipherInt());
            System.out.print("Encrypted String (Caesar): ");
            System.out.println(CipheredText);
            al.outputToFile("EncryptedString.txt", CipheredText);
        }
        if (selectedCipher == 2) {
            al.runAlpha(typeImport, getUserInput());
            xc.runCipher(al.getStringAsNum());
            char[] CipheredText = al.numToLetter(xc.getXCipherInt());
            System.out.print("Encrypted String (XOR): ");
            System.out.println(CipheredText);
            al.outputToFile("EncryptedString.txt", CipheredText);

        }
        if (selectedCipher == 3) {
            al.runAlpha(typeImport, getUserInput());
            hc.runCipher(al.getStringAsNum());
            char[] CipheredText = al.numToLetter(hc.getHCipher());
            System.out.print("Encrypted String (Hill): ");
            System.out.println(CipheredText);
            al.outputToFile("EncryptedString.txt", CipheredText);
        }
        System.out.println("Your file is located at: " + path.toAbsolutePath() + "\n");
    }

    private void runType2(int selectedCipher) {
        Path path = Paths.get("EncryptedString.txt");
        Alphabet al = new Alphabet();
        CaesarCipher cc = new CaesarCipher();
        XORCipher xc = new XORCipher();
        HillCipher hc = new HillCipher();
        if (selectedCipher == 1) {
            al.runAlpha(typeImport, "");
            cc.runCipher(al.getStringAsNum());
            char[] CipheredText = al.numToLetter(cc.getCcCipherInt());
            System.out.print("Encrypted String (Caesar): ");
            System.out.println(CipheredText);
            al.outputToFile("EncryptedString.txt", CipheredText);
        }
        if (selectedCipher == 2) {
            al.runAlpha(typeImport, "");
            xc.runCipher(al.getStringAsNum());
            char[] CipheredText = al.numToLetter(xc.getXCipherInt());
            System.out.print("Encrypted String (XOR): ");
            System.out.println(CipheredText);
            al.outputToFile("EncryptedString.txt", CipheredText);

        }
        if (selectedCipher == 3) {
            al.runAlpha(typeImport, "");
            hc.runCipher(al.getStringAsNum());
            char[] CipheredText = al.numToLetter(hc.getHCipher());
            System.out.print("Encrypted String (Hill): ");
            System.out.println(CipheredText);
            al.outputToFile("EncryptedString.txt", CipheredText);
        }
        System.out.println("Your file is located at: " + path.toAbsolutePath() + "\n");
    }

    private int checkRunAgain(String prompt) {
        int runAgain = -1;
        try {
            System.out.println(prompt);
            Scanner sc = new Scanner(System.in);
            runAgain = sc.nextInt();
            if (runAgain > 2 || runAgain <= 0) {
                prompt = "Would you like to encrypt again? (Type either 1 or 2)\n1.No\n2.Yes";
                runAgain = -1;
            }
        } catch (Exception e) {
            prompt = "Incorrect input, please try again.\nWould you like to encrypt again? (Type either 1 or 2) \n1.No \n2.Yes";
        }
        return runAgain;
    }

    private void typeStringCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is this what you typed? " + "(" + userInput + ")" + "\nIf yes, type Y. If no, type N");
        uiCheck = sc.nextLine().toUpperCase();
    }

    private void typeString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type your string. (Please keep in mind, all symbols will be removed)");
        userInput = sc.nextLine().toLowerCase().replaceAll("[^a-zA-Z0-9_-]", " ");
    }

    private int getCipherUserInput(String prompt) {
        int ciphSelect = -1;
        while (ciphSelect < 0) {
            try {
                System.out.println(prompt);
                Scanner sc = new Scanner(System.in);
                ciphSelect = sc.nextInt();
                if (ciphSelect > 3 || ciphSelect <= 0) {
                    prompt = "Incorrect input, please try again. \nWhat Cipher would you like to select?\n1.Caesar Cipher (Weak)\n2.XOR Cipher (Moderate)\n3.Hill Cipher (Strong)";
                    ciphSelect = -1;
                }
            } catch (Exception e) {
                prompt = "Incorrect input, please try again. \nWhat Cipher would you like to select?\n1.Caesar Cipher (Weak)\n2.XOR Cipher (Moderate)\n3.Hill Cipher (Strong)";
            }
        }
        return ciphSelect;
    }

    private int getTypeImport(String prompt) {
        int typeSelect = -1;
        while (typeSelect < 0) {
            try {
                System.out.println(prompt);
                Scanner sc = new Scanner(System.in);
                typeSelect = sc.nextInt();
                if (typeSelect > 2 || typeSelect <= 0) {
                    prompt = "Incorrect input, please try again.\nWould you like to type a string or import a file?\n1.Type a string\n2.Import a file";
                    typeSelect = -1;
                }
            } catch (Exception e) {
                prompt = "Incorrect input, please try again.\nWould you like to type a string or import a file?\n1.Type a string\n2.Import a file";
            }
        }
        return typeSelect;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setTypeImport(int typeImport) {
        this.typeImport = typeImport;
    }
}
