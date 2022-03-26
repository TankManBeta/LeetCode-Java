/*
给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

输入：left = 5, right = 7
输出：4

输入：left = 0, right = 0
输出：0

输入：left = 1, right = 2147483647
输出：0
 */
/*
思路：实际上就是找公共前缀，后面补0
（1）位移操作，将两个数字不断向后移，直到相等
（2）n&(n-1)消去n最右边的1，此时非公共前缀部分的1被消去
 */
public class Problem201 {
    public int rangeBitwiseAnd(int left, int right) {
        // int shift = 0;
        // while(left<right){
        //     left >>= 1;
        //     right >>= 1;
        //     shift++;
        // }
        // return left << shift;

        while (left < right) {
            right &= right - 1;
        }
        return right;
    }
}