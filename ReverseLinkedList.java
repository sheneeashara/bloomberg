import java.io.*;
import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { this.val = val; }
}

public class ReverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(final String... args) {
        ListNode c1 = new ListNode(5);
        c1.next = null
        ListNode c2 = new ListNode(4);
        c2.next = c1;
        ListNode c3 = new ListNode(3);
        c3.next = c2
        ListNode c4 = new ListNode(2);
        c4.next = c3
        ListNode c5 = new ListNode(1);
        c5.next = c4;
        // output : 5 -> 4 -> 3 -> 2 -> 1
        ListNode result = addTwoNumbers(c5);

        ListNode temp = result;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}