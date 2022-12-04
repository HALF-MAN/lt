package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56 {
    static class Solution {
        public static void main(String[] args) {
            int[][] intervals = new int[][]{{2,6}, {1,3},{8,10},{15,18}};
            Solution solution = new Solution();
            solution.merge(intervals);;
            System.out.println();
        }
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> list = new ArrayList<>();
           for (int i = 0; i < intervals.length; i++) {
               int l = intervals[i][0], r = intervals[i][1];
                if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                    list.add(new int[]{l,r});
                } else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], r);
                }
           }
           return list.toArray(new int[list.size()][]);
        }
    }

}
