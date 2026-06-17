/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode th = head;
        while (head.next != null) {
            int temp = head.val;
            head.val = head.next.val;
            head.next.val = temp;
            if (head.next.next != null) {
                head = head.next.next;
            }
            else break;
        }
        return th;
    }
}