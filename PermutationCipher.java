/***********************************
 * Filename: XORCipher
 * Author: Brandon Badraoui
 * Collaborators:
 * Created: 4/11/24
 * Modified: 4/11/24
 * Purpose: will hold the math and computation for the XOR cipher
 * <p>
 * Attributes:
 * -xCipherInt: int[]
 * -xorKey: int
 * <p>
 * Methods:
 * +runCipher(int[]): int[]
 * +getXCipherInt(): int[]
 ***********************************/
public class XORCipher extends EmptyCipher {
    private int[] xCipherInt;

    @Override
    public int[] runCipher(int[] userInAsNum) {
        xCipherInt = new int[userInAsNum.length];
        for (int i = 0; i < xCipherInt.length; i++) {
            int xorKey = 14;
            xCipherInt[i] = (userInAsNum[i] ^ xorKey) % 36;
        }
        return xCipherInt;
    }

    public int[] getXCipherInt() {
        return xCipherInt;
    }
}
