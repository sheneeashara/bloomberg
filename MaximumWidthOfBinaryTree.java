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

class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root,0,0));
        int currDepth=0, left=0, ans=0;
        while(!queue.isEmpty()){
            Node a = queue.poll();
            if(a.node!=null){
                queue.add(new Node(a.node.left, a.depth+1, a.pos*2));
                queue.add(new Node(a.node.right, a.depth+1, a.pos*2+1));
                if(currDepth!=a.depth){
                    currDepth=a.depth;
                    left=a.pos;
                }
                ans=Math.max(ans, a.pos-left+1);
            }
        }
        return ans;
    }

    public static void main(final String[] args) {
        // here we do need to consider the null in between if there is a node with value present at that level

        /*
                    1
                3       2
              5   3       9
        */
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(9);
        TreeNode t5 = new TreeNode(3, t1, t2);
        TreeNode t6 = new TreeNode(2, null, t3);
        TreeNode root1 = new TreeNode(1, t5, t6);
        // output : 4
        // Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
        System.out.println(widthOfBinaryTree(root1));

        /*
                    1
                3       2
              5   
        */
        TreeNode s1 = new TreeNode(5);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3, s1, null);
        TreeNode root2 = new TreeNode(1, s3, s2);
        // output : 2
        // Explanation: The maximum width existing in the second level with the length 2 (3,2).
        System.out.println(widthOfBinaryTree(root2));

        /*
                    1
                3       2
              5           9
            6               7
        */
        TreeNode x1 = new TreeNode(6);
        TreeNode x2 = new TreeNode(7);
        TreeNode x3 = new TreeNode(5, x1, null);
        TreeNode x4 = new TreeNode(9, null, x2);
        TreeNode x5 = new TreeNode(3, x3, null);
        TreeNode x6 = new TreeNode(2, null, x4);
        TreeNode root3 = new TreeNode(1, x5, x6);
        // output : 8
        // Explanation: The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
        System.out.println(widthOfBinaryTree(root3));
    }
}

class Node{
    TreeNode node;
    int depth, pos;
    Node(TreeNode n, int d, int p){
        node = n;
        depth = d;
        pos = p;
    }
}