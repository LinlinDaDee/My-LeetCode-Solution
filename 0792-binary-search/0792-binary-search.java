class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        if (target < nums[left] || target >  nums[right]){
            return -1;
        }

        // [left, right]
        while (left <= right){
            // Prevent int overflow
            int mid = left + ((right - left) >> 1); 
            
            if (target == nums[mid]){
                return mid;
            }
            else if (target > nums[mid]){
                left = mid + 1;
            }
            else if (target < nums[mid]){
                right = mid - 1;
            }
        }
        return -1;
    }
}