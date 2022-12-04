package test;

import java.util.ArrayList;
import java.util.List;

public class P54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println();
    }

    static class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int i = 0;
            int n = matrix.length - 1;
            int j  = 0;
            int m = matrix[0].length - 1;
            while(i<=n && j<=m) {
                //向右遍历
                for (int t = j; t <= m && i<=n; t++) {
                    list.add(matrix[i][t]);
                }
                i++;
                //向下遍历
                for(int t = i; t <=n && j<=m; t++) {
                    list.add(matrix[t][m]);
                }
                m--;
                //向左遍历
                for (int t = m; t >= j && i <= n; t--) {
                    list.add(matrix[n][t]);
                }
                n--;
                //向上遍历
                for (int t = n; t >= i && j <=m; t--) {
                    list.add(matrix[t][j]);
                }
                j++;
            }
            return list;
        }
    }
}
