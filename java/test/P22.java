package test;

import java.util.ArrayList;
import java.util.List;

public class P22 {
    class Solution {
        List<String> res  = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            backtrack(new StringBuffer(), n, 0, 0);
            return res;
        }

        private void backtrack(StringBuffer sb, int n, int left, int right) {
            if (left == n && right == n) {
                res.add(sb.toString());
                return;
            }
            if (left > n || right > n) {
                return;
            }

            if (left < n) {
                sb.append("(");
                backtrack(sb, n, left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < left) {
                sb.append(")");
                backtrack(sb, n, left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
