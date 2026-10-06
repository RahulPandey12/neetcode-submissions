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
  int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=buildTreeHelper(preorder,inorder,0,preorder.length-1);
        return root;
    }
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,int start, int end){
        if(start>end){
            return null;
         }
        int rootVal=preorder[idx];
         idx++;
         int i=start;
         while(i<=end){
           if(rootVal==inorder[i]) {
              break;
            }
            i++;
         }
          
            TreeNode root= new TreeNode(rootVal);
            root.left=buildTreeHelper(preorder,inorder,start,i-1);
            root.right=buildTreeHelper(preorder,inorder,i+1,end);
            return root;
        
   }
}
