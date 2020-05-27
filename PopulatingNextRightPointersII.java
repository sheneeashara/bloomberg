import java.io.*;
import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersII {
    
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node n = queue.poll();
                if(i<size-1){
                    n.next=queue.peek();
                }
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
        }
        return root;
    }

    public static void main(final String[] args) {
    	Node l1 = new Node(4, null, null, null);
    	Node r1 = new Node(5, null, null, null);
    	Node r2 = new Node(7, null, null, null);
    	Node l2 = new Node(2, l1, r1, null);
    	Node r3 = new Node(3, null, r2, null);
    	Node root = new Node(1, l2, r3, null);

        /*	
        	Output:
        	Node l1 = new Node(4, null, null, r1);
    		Node r1 = new Node(5, null, null, r2);
    		Node r2 = new Node(7, null, null, null);
    		Node l2 = new Node(2, l1, r1, r3);
    		Node r3 = new Node(3, null, r2, null);
    		Node root = new Node(1, l2, r3, null);
        */
        Node result = connect(root);
    }
}
