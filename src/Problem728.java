/*
自除数 是指可以被它包含的每一位数整除的数。
例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
自除数 不允许包含 0 。
给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。

输入：left = 1, right = 22
输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

输入：left = 47, right = 85
输出：[48,55,66,77]
 */
/*
思路：直接暴力判断每一个数是否是自除数即可
 */
import java.util.ArrayList;
import java.util.List;

public class Problem728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=left; i<=right; i++){
            if (isDivisible(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isDivisible(int num){
        int temp = num;
        while(temp != 0){
            int r = temp % 10;
            temp /= 10;
            if ((r==0)||(num%r!=0)){
                return false;
            }
        }
        return true;
    }
}
