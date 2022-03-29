/*
给定两个字符串 s 和 t ，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

输入：s = "egg", t = "add"
输出：true

输入：s = "foo", t = "bar"
输出：false

输入：s = "paper", t = "title"
输出：true
 */
/*
思路：两个哈希表记录映射关系，有冲突就return False
 */

import java.util.HashMap;
import java.util.Map;

public class Problem205 {
    public boolean isIsomorphic(String s, String t) {
        int a = s.length();
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i=0; i<a; i++){
            Character key1 = s.charAt(i);
            Character key2 = t.charAt(i);
            Character val1 = map1.get(key1);
            Character val2 = map2.get(key2);
            if (val1==null && val2==null){
                map1.put(key1, key2);
                map2.put(key2, key1);
            }else{
                if ((val1 != key2) || (val2 != key1)){
                    return false;
                }
            }
        }
        return true;
    }
}
