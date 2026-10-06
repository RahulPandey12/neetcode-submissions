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

public class Codec {
    // Encodes a tree to a single string.
    int idx=0;
    public String serialize(TreeNode root) {
        return preorderDfs(root,"");
    }
    public String preorderDfs(TreeNode root,String result){
     if(root==null){
      result = result + "#,";
       return result;
}
       result=result+String.valueOf(root.val);
       result=result+",";
       result=preorderDfs(root.left,result);
       result=preorderDfs(root.right,result);
       return result;


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         idx=0;
        String str[]=data.split(",");
        TreeNode root= deserializeHelper(str);
        return root;
    }
    public TreeNode deserializeHelper(String[] str){
         
       String rootVal=str[idx];
       idx++;
       if(rootVal.equals("#")){
           return null;
       }
       TreeNode root= new TreeNode(Integer.parseInt(rootVal));
       root.left=deserializeHelper(str);
       root.right=deserializeHelper(str);
       return root;
    }
}

