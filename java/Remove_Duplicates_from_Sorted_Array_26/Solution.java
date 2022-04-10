package Remove_Duplicates_from_Sorted_Array_26;

/**
 * [0,0,1,1,1,2,2,3,3,4]
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int kIndex = 0;
        int currentVal = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (currentVal != nums[i]) {
               kIndex++;
               nums[kIndex] = nums[i];
               currentVal = nums[i];
            }
        }
        return kIndex + 1;
    }

    public static void main(String[] args) {

    }
}
