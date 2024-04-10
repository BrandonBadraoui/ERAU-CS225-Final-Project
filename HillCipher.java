/***********************************
 * Filename: HillCipher
 * Author: Brandon Badraoui
 * Collaborators:
 * Created: 3/25/24
 * Modified: 3/29/24
 * Purpose: will hold the math and computation for the Hill cipher
 *
 *
 * Attributes:
 *
 *
 * Methods:
 ***********************************/
public class HillCipher extends EmptyCipher {
        int[][] keyMatrix = {{2, 14}, {3, 4}};
        private int[] hCipher;

        @Override
        public int[] runCipher(int[] userInAsNum) {
            hCipher = new int[userInAsNum.length]; // This needs to be a 2d array (2 Columns by infinite length)
            int halfLength = (int) (Math.floor(userInAsNum.length / 2) + 1);
            int[][] messageVector = new int[halfLength][2]; // set this = to hCipher
            int[][] cipherMatrix = new int[halfLength][2];

            for (int j = 0; j < halfLength; j++) {
                for (int i = 0; i < halfLength; i++) {
                    messageVector[i][0] = userInAsNum[j++];
                    if (userInAsNum.length == halfLength * 2) {
                        messageVector[i][1] = userInAsNum[j++];
                    }
                }
            }
            encrypt(cipherMatrix, keyMatrix, messageVector);

            for (int j = 0; j < halfLength; j++) {
                for (int i = 0; i < halfLength; i++) {
                    hCipher[j++] = cipherMatrix[i][0];
                    if (userInAsNum.length == halfLength * 2) {
                        hCipher[j++] = cipherMatrix[i][1];
                    }
                }
            }

            return hCipher;
        }

        private void encrypt(int cipherMatrix[][], int keyMatrix[][], int messageVector[][]) {
            int x, i, j;
            for (i = 0; i < 2; i++) {
                for (j = 0; j < cipherMatrix[i].length; j++) {
                    cipherMatrix[i][j] = 0;
                    for (x = 0; x < 2; x++) {
                        cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
                    }
                    cipherMatrix[i][j] = cipherMatrix[i][j] % 37;
                    //System.out.println(cipherMatrix[i][j]);
                }
            }
        }

        public int[] gethCipher() {
            return hCipher;
        }
    }
