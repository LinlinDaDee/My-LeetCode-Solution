// 因为题目说只有小写字母，那可以采用空间换取时间的哈希策略，用一个长度为26的数组来记录magazine里字母出现的次数。
// 在本题的情况下，使用map的空间消耗要比数组大一些的，因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的！数据量大的话就能体现出来差别了。 所以数组更加简单直接有效！

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for (char letter : magazine.toCharArray()) {
            letters[letter - 'a'] += 1;
        }

        for (char letter : ransomNote.toCharArray()) {
            letters[letter - 'a'] -= 1;
        }

        for (int i : letters) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}