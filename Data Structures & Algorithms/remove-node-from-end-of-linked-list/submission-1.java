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
    public ListNode removeNthFromEnd(ListNode head, int n) {
ListNode temp=head;
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }
        int posFromBegining=count-n+1;
      head =  deleteAtPosition(head,posFromBegining);
       return head;

    }
    private ListNode deleteAtPosition(ListNode head,int pos) {
		ListNode prev = null;
		ListNode current = head;
		if (pos < 1) {
			return head;
		}
		if (head == null) {
			return head;
		}
		if (pos == 1) {
			head = head.next;
			return head;
		}
		while (pos > 1 && current != null) {
			prev = current;
			current = current.next;
			pos--;
		}
		if (pos > 1) {
			return head;
		}
		prev.next = current.next;
        return head;
	}
    
}
