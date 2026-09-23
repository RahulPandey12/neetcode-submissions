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
    public ListNode reorderList(ListNode head) {

        ListNode middle = findMiddle(head);

        ListNode reverse = reverseList(middle.next);

        middle.next = null;

        ListNode temp = head;
        ListNode temp1 = reverse;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(temp != null && temp1 != null) {

            ListNode next1 = temp.next;
            ListNode next2 = temp1.next;

            current.next = temp;
            current = current.next;

            current.next = temp1;
            current = current.next;

            temp = next1;
            temp1 = next2;
        }

        // Remaining nodes from first half
        if(temp != null) {
            current.next = temp;
        }

        return dummy.next;
    }


    public ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {

            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}