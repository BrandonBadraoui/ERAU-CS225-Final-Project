/***********************************
 * Filename: HillCipher
 * Author: Brandon Badraoui
 * Collaborators:
 * Created: 3/25/24
 * Modified: 4/14/24
 * Purpose: will hold the math and computation for the Hill cipher
 * <p>
 * Attributes:
 * -keyMatrix: int[][]
 * -hCipher: int[]
 * <p>
 * Methods:
 * +runCipher(int[]): int[]
 * -encrypt: void
 * +getHCipher: int[]
 ***********************************/
public class HillCipher extends EmptyCipher {
    private final int[][] keyMatrix = {{2, 7}, {5, 22}};
    private int[] hCipher;

    @Override
    public int[] runCipher(int[] userInAsNum) {
        hCipher = new int[userInAsNum.length];
        int halfLength = userInAsNum.length / 2 + 1;
        int[][] messageVector = new int[2][halfLength];
        int[][] cipherMatrix = new int[2][halfLength];

        int index = 0;
        for (int j = 0; j < halfLength; j++) {
            for (int i = 0; i < 2; i++) {
                if (index < userInAsNum.length) {
                    messageVector[i][j] = userInAsNum[index];
                    index++;
                }

            }
        }
        //System.out.println(Arrays.deepToString(messageVector));
        encrypt(cipherMatrix, keyMatrix, messageVector, halfLength);
        //System.out.println(Arrays.deepToString(cipherMatrix));
        int index2 = 0;
        for (int j = 0; j < halfLength; j++) {
            for (int i = 0; i < 2; i++) {
                if (index2 < hCipher.length) {
                    hCipher[index2] = cipherMatrix[i][j];
                    index2++;
                }
            }
        }
        //System.out.println((Arrays.toString(hCipher)));
        return hCipher;
    }

    private void encrypt(int[][] cipherMatrix, int[][] keyMatrix, int[][] messageVector, int halfLength) {
        int x, i, j;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < halfLength; j++) {
                cipherMatrix[i][j] = 0;
                for (x = 0; x < 2; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 36;
            }
        }
    }

    public int[] getHCipher() {
        return hCipher;
    }
}
