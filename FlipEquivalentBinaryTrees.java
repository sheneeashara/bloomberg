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
 
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==root2){
            return true;
        }
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        return (flipEquiv(root1.left, root2.left)&&flipEquiv(root1.right, root2.right)) || 
                    (flipEquiv(root1.left, root2.right)&&flipEquiv(root1.right, root2.left));
    }

    public static void main(final String[] args) {

        //Explanation: We flipped at nodes with values 1, 3, and 5.
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5, t1, t2);
        TreeNode t6 = new TreeNode(2, t3, t5);
        TreeNode t7 = new TreeNode(3, t4, null);
        TreeNode root1 = new TreeNode(1, t6, t7);

        TreeNode s1 = new TreeNode(7);
        TreeNode s2 = new TreeNode(8);
        TreeNode s3 = new TreeNode(4);
        TreeNode s4 = new TreeNode(6);
        TreeNode s5 = new TreeNode(5, s2, s1);
        TreeNode s6 = new TreeNode(2, s3, s5);
        TreeNode s7 = new TreeNode(3, null, s4);
        TreeNode root2 = new TreeNode(1, s7, s6);

        // output: true
        System.out.println(flipEquiv(root1, root2));
    }
}