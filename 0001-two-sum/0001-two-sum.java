class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // key 为元素的值, value 为元素的下标
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历当前元素，并在map中寻找是否有匹配的key
        for (int i = 0; i < nums.length; i++){
            int pair = target - nums[i];
            if (map.containsKey(pair)){
                result[0] = map.get(pair);
                result[1] = i;
                break;
            } else {
            // 如果没找到匹配对，就把访问过的元素和下标加入到map中
                map.put(nums[i], i);
            }
        }
        return result;
    }
}