/**
 * Calculate a+b and output the sum in standard format -- that is,
 * the digits must be separated into groups of three by
 * commas (unless there are less than four digits).
 *
 * @author HitoM
 * @date 2019/3/5 20:55
 */
public class AAddBFormat {
    public static String solution(int num1, int num2) {
        int sum = num1 + num2;

        int abSum = Math.abs(sum);
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        while (abSum != 0) {
            int left = abSum % 10;
            abSum /= 10;
            count++;
            buffer.insert(0, left);
            if (count % 3 == 0) {
                buffer.insert(0, ",");
            }
        }
        if (count % 3 == 0) {
            buffer.replace(0, 1, "");
        }
        if (count == 0) {
            return Integer.toString(0);
        } else {
            if (sum < 0) {
                buffer.insert(0, "-");
            }
            return buffer.toString();
        }
    }
}
