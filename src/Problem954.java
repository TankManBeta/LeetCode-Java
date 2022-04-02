import java.util.*;

/*
给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 *
arr[2 * i]” 时，返回 true；否则，返回 false。

输入：arr = [3,1,3,6]
输出：false

输入：arr = [2,1,2,6]
输出：false

输入：arr = [4,-2,2,-4]
输出：true
解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 */
/*
思路：统计各个数字的数量，然后按绝对值从小到大排，然后判断cnt[x]和cnt[2x]的数量，2x的数量够x的两倍就将2x的数量减去x的数量，否
则return false
 */
public class Problem954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> val = new ArrayList<Integer>(cnt.keySet());
        val.sort((a, b) -> Math.abs(a) - Math.abs(b));
        for (int x : val) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}
