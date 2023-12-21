//题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转

class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        // 注意不是 i++ 了, 而是每隔 2k 就跳一次
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;

            // 判断尾数够不够k个来取决end指针的位置
            // end = (ch.length - 1) -> 剩余字符少于 k 个，则将剩余字符全部反转
            // end = (start + k - 1) -> 此时剩余长度一定大于k, 则反转前 k 个字符
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){                
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }
}