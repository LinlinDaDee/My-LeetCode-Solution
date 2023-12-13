class Solution {
    public int removeElement(int[] nums, int val) {
        // two pointers: fast - elements needed, slow - position
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}