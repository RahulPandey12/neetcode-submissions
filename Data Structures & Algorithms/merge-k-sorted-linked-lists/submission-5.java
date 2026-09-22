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
      return mergeKListsHelper(lists,0,lists.length-1);
    }
    public ListNode mergeKListsHelper(ListNode[] lists,int start, int end){
        if(start==end){
            return lists[start];
        }
        if(start+1==end){
            return mergeTwoLists(lists[start],lists[end]);
        }
        int mid=start+(end-start)/2;
        ListNode left=mergeKListsHelper(lists,start,mid);
        ListNode right=mergeKListsHelper(lists, mid + 1, end);
        return mergeTwoLists(left,right);
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
