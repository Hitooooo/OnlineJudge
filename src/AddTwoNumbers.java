/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * @author HitoM
 * @date 2019/3/5 20:46
 */
public class AddTwoNumbers {

    public static ListNode solution(ListNode l1, ListNode l2) {
        // 进位
        int carry = 0;
        // 保存计算结果的List开始结点
        ListNode node = new ListNode(0);
        // 指向当前需要保存数据的结点
        ListNode curr = node;

        while (l1 != null || l2 != null || carry != 0) {
            int val = 0;
            if (l1 != null) {
                val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val = val + l2.val;
                l2 = l2.next;
            }
            if (carry != 0) {
                val += carry;
            }
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return node.next;
    }
}
