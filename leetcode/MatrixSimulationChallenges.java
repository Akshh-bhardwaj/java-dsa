package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSimulationChallenges {

    // 59. Spiral Matrix II
    // Approach 1: Boundary simulation - O(N^2) Time | O(1) Space
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int val = 1;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse Right
            for (int j = colStart; j <= colEnd; j++) {
                matrix[rowStart][j] = val++;
            }
            rowStart++;

            // Traverse Down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = val++;
            }
            colEnd--;

            // Traverse Left
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    matrix[rowEnd][j] = val++;
                }
            }
            rowEnd--;

            // Traverse Up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = val++;
                }
            }
            colStart++;
        }
        return matrix;
    }

    // 48. Rotate Image
    // Approach 1: Transpose + Reverse - O(N^2) Time | O(1) Space
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // 289. Game of Life
    // Approach 1: O(1) state modification codes - O(M*N) Time | O(1) Space
    // 0: dead -> dead, 1: live -> live, 2: live -> dead, 3: dead -> live
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] neighbors = {0, 1, -1};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int liveNeighbors = 0;

                // Scan 8 adjacent positions
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = row + neighbors[i];
                            int c = col + neighbors[j];

                            if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                                liveNeighbors++;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2; // Marks live to dead state transition
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 3; // Marks dead to live state transition
                }
            }
        }

        // Re-read board to finalize updates
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 2) board[row][col] = 0;
                else if (board[row][col] == 3) board[row][col] = 1;
            }
        }
    }

    // 885. Spiral Matrix III
    // Approach 1: Walk steps simulation - O(Max(R, C)^2) Time | O(R*C) Space
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        result[index++] = new int[]{rStart, cStart};

        int step = 0;
        int r = rStart, c = cStart;
        // Direction vectors: East, South, West, North
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int d = 0; // Current direction index

        while (index < rows * cols) {
            // Increase step counts every East/West iteration
            if (d == 0 || d == 2) {
                step++;
            }

            for (int i = 0; i < step; i++) {
                r += dr[d];
                c += dc[d];
                // Check bounds before saving
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[index++] = new int[]{r, c};
                }
            }
            d = (d + 1) % 4; // Turn right
        }
        return result;
    }

    // 498. Diagonal Traverse
    // Approach 1: Direction vector tracking - O(M*N) Time | O(1) Space
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0];
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0;
        boolean directionUp = true;

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if (directionUp) {
                if (col == n - 1) {
                    row++; // Move down
                    directionUp = false;
                } else if (row == 0) {
                    col++; // Move right
                    directionUp = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++; // Move right
                    directionUp = true;
                } else if (col == 0) {
                    row++; // Move down
                    directionUp = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }

    // 54. Spiral Matrix
    // Approach 1: Boundary simulation - O(M*N) Time | O(1) Space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse Right
            for (int j = colStart; j <= colEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++;

            // Traverse Down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse Left
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            // Traverse Up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return result;
    }

    public static void main(String[] args) {
        MatrixSimulationChallenges suite = new MatrixSimulationChallenges();
        System.out.println("--- Matrix Simulation Challenges Tests ---");
        int[][] generated = suite.generateMatrix(3);
        System.out.println("Generated Spiral(3): " + Arrays.deepToString(generated));
        System.out.println("Spiral Order Output: " + suite.spiralOrder(generated));
    }
}
