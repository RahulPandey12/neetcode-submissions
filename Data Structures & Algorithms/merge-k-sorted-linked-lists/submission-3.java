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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
    return null;
}
       int interval=1;
        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i=i+interval*2){
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval=interval*2;
        }
       return lists[0];
    }
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                current.next=temp1;
                temp1=temp1.next;
            }
            else{
                 current.next=temp2;
                temp2=temp2.next;
            }
            current = current.next;
        }
        if(temp1!=null){
            current.next=temp1;
        }
        if(temp2!=null){
            current.next=temp2;
        
        }
        return dummy.next;
    }
}
