package test;

import java.util.ArrayList;
import java.util.List;

public class P93 {
    static class Solution {
        public static void main(String[] args) {
            String s = "0000";
            Solution solution = new Solution();
            List<String> stringList = solution.restoreIpAddresses(s);
            System.out.println(s.substring(1, s.length()));
        }

        static final int SEG_COUNT = 4;
        List<String> result = new ArrayList<>();
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 0);
            return result;
        }

        public void dfs(String s, int start, int seqNum) {
            // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
            if (seqNum == 4) {
                if (start == s.length()) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < SEG_COUNT; i++) {
                        sb.append(segments[i]);
                        if (i != SEG_COUNT - 1) {
                            sb.append(".");
                        }
                    }
                    result.add(sb.toString());
                }
                return;
            }
            // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
            if (start == s.length()) {
                return;
            }
            // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
            if (s.charAt(start) == '0') {
                segments[seqNum] = 0;
                dfs(s, start + 1, seqNum + 1);
            }
            // 一般情况，枚举每一种可能性并递归
            int addr = 0;
            for (int i = start; i < s.length(); ++i) {
                addr = addr * 10 + (s.charAt(i) - '0');
                if (addr > 0 && addr <= 0xFF) {
                    segments[seqNum] = addr;
                    dfs(s, i + 1, seqNum + 1);
                } else {
                    break;
                }
            }
        }
    }
}
