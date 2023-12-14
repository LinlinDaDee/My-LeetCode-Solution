// O(n)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // A subarray is a contiguous non-empty sequence of elements within an array.
        // sliding window (two pointers)
        // 这道题之所以可以使用滑动窗口，很重要的一个原因是，在移动终止位置的时候，初始位置是不可逆的，初始位置只可能往后移动，而不用每次都从第零个元素开始
        // 所有双指针法，都是充分利用题目的一个隐藏的特征，来对暴力算法的一种简化

        int left = 0;                    // start of the sliding window 
        int sum = 0;                     // sum of the sliding window
        int subLength = 0;               // length of sliding window
        int result = Integer.MAX_VALUE;  // the maximum positive integer value that can be represented in 32 bits (i.e., 2147483647 )

        // 循环每个右边界
        for (int right = 0; right < nums.length; right++){
            sum += nums[right];
            // 只要子数组的和大于target，就缩小左边界
            while (sum >= target){
                subLength = right - left + 1;
                result = Math.min(result, subLength);
                sum -= nums[left++];   // sum = sum -nums[left]; left = left + 1
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}