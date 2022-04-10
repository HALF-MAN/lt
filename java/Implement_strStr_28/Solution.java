package Implement_strStr_28;

class Solution {
    public static int strStr(String haystack, String needle) {
        int i=0, n = haystack.length(), m = needle.length();

        if(m == 0)
            return 0 ;

        if(n < m)
            return -1 ;

        while(i < n)
        {
            if(i+m-1 < n && haystack.charAt(i)== needle.charAt(0) && haystack.charAt(i+m-1) == needle.charAt(m-1))  // V. IMP Condition for Optimisation Purpose
            {
                int j = 0,flag=0,temp=0 ;

                while(i < n && j < m && haystack.charAt(i) == needle.charAt(j))
                {
                    if(flag == 0 && j != 0 && haystack.charAt(i) == needle.charAt(0)) {
                        flag = 1;
                        temp = i ;
                    }
                    i++ ;
                    j++ ;
                }
                if(j == m)
                    return i-j ;
                else if(temp != 0)
                    i  = temp ;
            } else {
                i++;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int str = strStr(haystack, needle);
        System.out.println(1);
    }
}