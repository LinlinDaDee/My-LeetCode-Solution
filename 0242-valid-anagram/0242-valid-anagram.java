class Solution {
    public boolean isAnagram(String s, String t) {
        // 数据少直接用array
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++){
            // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            hash[s.charAt(i)  - 'a']++;
        }

        for (int i = 0; i < t.length(); i++){
            hash[t.charAt(i) - 'a']--;
        }

        // hash 数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符
        for (int count : hash){
            if (count != 0){
                return false;
            }
        }
        return true;
    }
}