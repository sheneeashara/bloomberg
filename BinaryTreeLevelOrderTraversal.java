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

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // here the idea is to use bfs approach as we are going level by level

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
          // start the current level
          levels.add(new ArrayList<Integer>());

          // number of elements in the current level
          int level_length = queue.size();
          for(int i = 0; i < level_length; ++i) {
            TreeNode node = queue.remove();

            // add for the current level
            levels.get(level).add(node.val);

            // add child nodes of the current level in the queue for the next level
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
          }
          // go to next level
          level++;
        }
        return levels;
    }

    public static void main(final String[] args) {
        // here the time complexity would be O(n) as each node is processsed exactly once
        // the space complexity would be O(n) which is used to keep the output structure which will have maximum n nodes values
    	TreeNode t1 = new TreeNode(15, null, null);
    	TreeNode t2 = new TreeNode(7, null, null);
    	TreeNode t3 = new TreeNode(9, null, null);
    	TreeNode t4 = new TreeNode(20, t1, t2);
    	TreeNode root = new TreeNode(3, t3, t4);

        /*	
        	Output:
            [[3], [9, 20], [15, 7]]
        */
        List<List<Integer>> result = levelOrder(root);
        for(List<Integer> l : result){
            for(int i=0; i<l.size(); i++){
                System.output.print(l.get(i) + ", ");
            }
            System.output.println();
        }
    }
}
