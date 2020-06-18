import java.io.*;
import java.util.*;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return count;
    }
    
    boolean dfs(TreeNode root){
        if(root.left==null && root.right==null){
            count++;
            return true;
        }
        boolean ans = true;
        if(root.left!=null){
            ans = dfs(root.left)&&ans&&root.left.val==root.val;
        }
        if(root.right!=null){
            ans = dfs(root.right)&&ans&&root.right.val==root.val;
        }
        if(!ans){
            return false;
        }
        count++;
        return true;
    }

    public static void main(final String[] args) {
        // A Uni-value subtree means all nodes of the subtree have the same value.

        /*
                    5
                1       5
              5   5       5
        */
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1, t1, t2);
        TreeNode t5 = new TreeNode(5, null, t3);
        TreeNode root = new TreeNode(5, t4, t5);
        // output : 4
        System.out.println(widthOfBinaryTree(root4));
    }
}