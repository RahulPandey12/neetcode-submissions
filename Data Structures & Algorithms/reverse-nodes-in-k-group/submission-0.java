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
  public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
         int count=0;
      while(temp!=null){
        temp=temp.next;
        count++;
      }
      int noOfTimes=count/k;
      int left=1;
      while(noOfTimes>0){
       head= reverseBetween(head, left,left+k-1);
        left=left+k;
        noOfTimes--;
      }
      return head;  
    }
     public ListNode reverseBetween(ListNode head, int left, int right) {
       int noOfIteration=right-left+1;
       ListNode temp=head;
       ListNode beforeReversal=null;
        ListNode firstReversedNode = null;
         while(temp!=null && left>1){
            beforeReversal=temp;
            temp=temp.next;
             left--;
       }
       firstReversedNode=temp;
       System.out.println(firstReversedNode.val);
       ListNode prev=null;
        ListNode current=temp;
		while(current!=null && noOfIteration>0) {
			ListNode nextNode=current.next;
			current.next=prev;
			prev=current;
			current=nextNode;
            noOfIteration--;
		}
          firstReversedNode.next=current;
        if(beforeReversal == null) {
            return prev;
        }
    beforeReversal.next=prev;
    return head;  
      
    }
}
