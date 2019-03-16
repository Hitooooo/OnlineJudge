import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author HitoM
 * @date 2019/3/16 21:13
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
