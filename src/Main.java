import java.util.Scanner;
/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
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
            System.out.println(0);
        } else {
            if (sum < 0) {
                buffer.insert(0, "-");
            }
            System.out.println(buffer);
        }
    }
}
