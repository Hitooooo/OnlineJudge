import java.util.Scanner;

/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(AddTwoNumbers.solution(l1, l2)
        );
    }
}
