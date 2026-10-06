/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> result1= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
             return result1;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> result= new ArrayList<>();
            while(size>0) {
              TreeNode temp=queue.poll();
               result.add(temp.val);
         
             if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
           size--;
            }
               result1.add(result.get(result.size()-1));
        }
        return result1;
    }
}
