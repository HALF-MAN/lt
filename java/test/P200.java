package test;

public class P200 {

    static class Solution {
        public static void main(String[] args) {
            char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
            Solution solution = new Solution();
            int numIslands = solution.numIslands(grid);
            System.out.println();
        }
        public int numIslands(char[][] grid) {
            int result = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0;  i < m; i++) {
                for (int j = 0 ; j < n; j++) {
                    if (grid[i][j] != '0') {
                        visit(i, j, m, n, grid);
                        result++;
                    }
                }
            }
            return result;
        }

        private void visit(int i, int j, int m, int n, char[][] grid) {
            grid[i][j] = '0';
            //向左遍历
            if (j > 0 && grid[i][j - 1] != '0') {
                visit(i, j - 1, m, n, grid);
            }
            //向右遍历
            if (j + 1 < n && grid[i][j + 1] != '0') {
                visit(i, j + 1, m, n, grid);
            }
            //向上遍历
            if (i > 0 && grid[i-1][j] != '0') {
                visit(i - 1, j, m, n, grid);
            }
            //向下遍历
            if (i + 1 < m && grid[i + 1][j] != '0') {
                visit(i + 1, j, m, n, grid);
            }
        }

    }
}
