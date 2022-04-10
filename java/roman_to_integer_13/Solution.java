package roman_to_integer_13;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
class Solution {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'I' && i + 1 < chars.length && ((chars[i+1] == 'V') || chars[i+1] == 'X')) {
                result = result + map.get(chars[i+1]) - map.get(chars[i]);
                i++;
            } else if (chars[i] == 'X' && i + 1 < chars.length && ((chars[i+1] == 'L') || chars[i+1] == 'C')) {
                result = result + map.get(chars[i+1]) - map.get(chars[i]);
                i++;
            } else if (chars[i] == 'C' && i + 1 < chars.length && ((chars[i+1] == 'D') || chars[i+1] == 'M')) {
                result = result + map.get(chars[i+1]) - map.get(chars[i]);
                i++;
            } else {
                result = result + map.get(chars[i]);
            }
            i++;
        }
        return result;
    }
    public static int romanToIntV2(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int result = map.get(chars[chars.length-1]);
        int last = result;
        for (int i = chars.length - 2 ; i >= 0; i--) {
            int n = map.get(chars[i]);
            if (n < last) {
                result = result - n;
            } else {
                result = result + n;
            }
            last = n;
        }
        return result;
    }
    public static void main(String[] args) {
        int s = romanToInt("MCMXCIV");
        System.out.println();
    }
}