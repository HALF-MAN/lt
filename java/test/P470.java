package test;

public class P470 {
    /**
     *  5 , 5    2
     *  5 , 6    2
     *  5 , 7    2
     *  4 , 6    2
     *  4 , 7    2
     *  3 , 7    2
     *  12 / 49
     */
    static class Solution extends SolBase {
        public int rand10() {
            int num = rand7();
            while (num == 7) {
                num = rand7();
            }
            int five = num % 2;
            num = rand7();
            while(num >= 6) {
                num = rand7();
            }
            return num + five * 5;
        }
    }

    static class SolBase {
        public int rand7(){
            return -1;
        }
    }
}
