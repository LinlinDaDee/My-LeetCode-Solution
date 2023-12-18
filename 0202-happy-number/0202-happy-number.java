// 求和的过程中，sum会重复出现，这对解题很重要！
// 当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了
// 使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止


class Solution {
    public int getSum(int n){
        int sum = 0;
        while (n > 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {    
        Set<Integer> record = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1){
                return true;
            }
            if (record.contains(sum)){
                return false;
            } else{
                record.add(sum);
                n = sum;
            }

        }    
    }
}