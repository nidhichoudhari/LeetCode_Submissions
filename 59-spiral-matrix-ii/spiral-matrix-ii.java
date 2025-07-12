class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int spiralLevel = 1;
        int currentValue = 1;
        int movementMode = 1;
        int finalValue = n * n;

        while (currentValue <= finalValue) {
            result[y][x] = currentValue;
            currentValue += 1;
            if (movementMode == 1) {
                if (x == n - 1 - spiralLevel) {
                    movementMode += 1;
                }
                x += 1;
            }
            else if (movementMode == 2) {
                if (y == n - 1 - spiralLevel) {
                    movementMode += 1;
                }
                y += 1;
            }
            else if (movementMode == 3) {
                if (x == 0 + spiralLevel) {
                    movementMode += 1;
                }
                x -= 1;
            }
            else if (movementMode == 4) {
                if (y == 0 + spiralLevel) {
                    spiralLevel += 1;
                    movementMode = 1;
                    x += 1;
                    continue;
                }
                y -= 1;
            }
        }
        return result;
    }
}