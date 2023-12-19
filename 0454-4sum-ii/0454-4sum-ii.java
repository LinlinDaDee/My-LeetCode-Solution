// 首先定义 一个 map，key放 i 和 j 两数之和 (前两个数组相加)，value 放两数之和出现的次数。
// 再遍历后两个数组，找到如果 0-(k+l) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
// 最后返回统计值 count 就可以了
// O(n^2)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历 nums1 和 nums2 数组，统计两个数组元素之和，和出现的次数，放到map中
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                // getOrDefault(Object key, V defaultValue):  get the value mapped with specified key. If no value is mapped with the provided key then the default value is returned.
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int count = 0;
        // 再遍历 nums3 和 nums4 数组，找到如果 0-(k+l) 在map中出现过的话，就把map中key对应的value也就是出现次数统计出来
        for (int k : nums3) {
            for (int l : nums4) {
                count += map.getOrDefault((0-(k + l)), 0);
            }
        }

        return count;       

    }
}