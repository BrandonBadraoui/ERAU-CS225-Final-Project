/***********************************
 * Filename: CaesarCipher
 * Author: Brandon Badraoui
 * Collaborators:
 * Created: 3/25/2024
 * Modified: 4/5/2024
 * Purpose: This is the computation for the caesar cipher.
 *
 *
 * Attributes:
 * -ccCipherInt: int[]
 *
 *
 * Methods:
 * +runCipher(int[],int): int[]
 * +getCcCipherInt(): int[]
 ***********************************/
public class CaesarCipher extends EmptyCipher {
    private int[] ccCipherInt;
    @Override
    public int[] runCipher(int[] userInAsNum) {
        ccCipherInt = new int[userInAsNum.length];
        for (int i = 0; i < userInAsNum.length; i++) {
            ccCipherInt[i] = (userInAsNum[i] + 3) % 37;
        }
        return ccCipherInt;
    }

    public int[] getCcCipherInt() {return ccCipherInt;}
}