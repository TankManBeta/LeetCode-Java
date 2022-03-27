/*
给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

输入：n = 0
输出：0

输入：n = 1
输出：0
 */
/*
思路：
（1）暴力（超时）：直接判断每个数是不是素数
（2）埃氏筛：每次标记当前素数的倍数，注意从x*x开始标记，因为那些2*x，3*x已经在之前被素数2，3标记过。复杂度O(log(log(n)))
（3）线性筛：多维护一个primes数组，对于当前的数字x，如果x是素数，就添加到primes中，然后标记对于primes中每一个素数prime，标记prime*x为合数，
直到x%prime为0，为什么在这个条件下停止标记，假设当前数字为x，能够整除的素数为primes[i]，对于下一个x*primes[i+1]，它一定会在x/primes[i]*
primes[i+1]被标记，所以我们做到了在最小质因数下标记。
 */

//public class Problem204 {
//
//    public boolean isPrime(int x) {
//         for (int i = 2; i * i <= x; ++i) {
//             if (x % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//    }
//
//    public int countPrimes(int n) {
//        int ans = 0;
//        for (int i = 2; i < n; ++i) {
//            ans += isPrime(i) ? 1 : 0;
//        }
//        return ans;
//    }
//}

// class Problem204{
//     public int countPrimes(int n) {
//         int[] isPrime = new int[n];
//         Arrays.fill(isPrime, 1);
//         int ans = 0;
//         for (int i=2; i<n; i++){
//             if (isPrime[i] == 1){
//                 ans++;
//                 if ((long)i*i<n){
//                     for (int j=i*i; j<n; j+=i){
//                         isPrime[j] = 0;
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem204{
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}