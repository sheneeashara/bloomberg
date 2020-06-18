import java.io.*;
import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        
        ListNode a=head, b=head;
        while(b!=null && b.next!=null){
            a=a.next;
            b=b.next.next;
        }
        
        ListNode prev=null, curr=a, temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        ListNode x=head, y=prev;
        while(y.next!=null){
            temp=x.next;
            x.next=y;
            x=temp;
            
            temp=y.next;
            y.next=x;
            y=temp;
        }
    }

    public static void main(final String[] args) {
        // Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        //reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        // input : 1 -> 2 -> 3 -> 4
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(3, c1);
        ListNode c3 = new ListNode(2, c2);
        ListNode c4 = new ListNode(1, c2);
        reorderList(c4);
        // output : 1 -> 4 -> 2 -> 3
        ListNode temp1 = c4;
        printList(temp1);

        // input : 1 -> 2 -> 3 -> 4 -> 5
        ListNode d1 = new ListNode(5);
        ListNode d2 = new ListNode(4, d1);
        ListNode d3 = new ListNode(3, d2);
        ListNode d4 = new ListNode(2, d3);
        ListNode d5 = new ListNode(1, d4);
        reorderList(d5);
        // output : 1 -> 5 -> 2 -> 4 -> 3
        ListNode temp2 = c4;
        printList(temp2);
    }

    public void printList(ListNode temp){
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}