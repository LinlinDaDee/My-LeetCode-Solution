// 双指针,一个从头开始,一个从尾开始, 都向中间走, 交换两个指针的值

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}        
    