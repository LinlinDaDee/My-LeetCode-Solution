// O(n^2)
// 循环不变量原则: 每一圈边的处理规则要统一
// 这里用左闭右开区间[),即每条边不处理最后一个点,留给下一条边遍历用
// 圈数就是中间点到边界的距离, n是边长，除2之后就是圈数, 即n/2

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startx = 0, starty = 0;   // 定义每循环一个圈的起始位置
        int loop = n / 2;   // 有几圈循环,但是如果n为奇数3，那么loop = 1(只是循环一圈)，矩阵中间的值需要单独处理
        int count = 1;      // 用来给矩阵每一个空格赋值
        int offset = 1;     // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int i,j;

        while (loop-- > 0){
            // 下面开始的四个for就是模拟转了一圈
            // 模拟填充上行从左到右(左闭右开)
            for (j = starty; j < n - offset; j++){
                result[startx][j] = count++;
            }
            // 模拟填充右列从上到下(左闭右开)
            for (i = startx; i < n - offset; i++){
                result[i][j] = count++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (; j > starty; j--){
                result[i][j] = count++;
            }
            // 模拟填充左列从下到上(左闭右开)
            for (; i > startx; i--){
                result[i][j] = count++;
            }

             // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startx++;
            starty++;
            // offset 控制每一圈里每一条边遍历的长度
            offset += 1;
        }


        // 处理n为奇数的情况       
        if (n % 2 == 1) {  
            int mid = n / 2;    //  矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)     
            result[mid][mid] = count;
        }
        return result;      
    }
}