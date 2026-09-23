/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp1=head;
        HashMap<Node,Node> hmap= new HashMap<>();
        while(temp1!=null){
            Node newNode= new Node(temp1.val);
            hmap.put(temp1,newNode);
            temp1=temp1.next;
        }
        Node temp=head;
        Node dummy=new Node(-1);
        Node current=dummy;
        while(temp!=null){
          Node newNode= hmap.get(temp);
          newNode.next=hmap.get(temp.next);
          newNode.random=hmap.get(temp.random);
          current.next=newNode;    
           temp=temp.next;
           current=current.next;
        }
        return dummy.next;
    }
}
