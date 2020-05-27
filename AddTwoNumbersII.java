import java.io.*;
import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbersII {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = new ListNode();
        ListNode r = result;
        int carry = 0;
        while(l1!=null || l2!=null){
            int l1Val = l1==null ? 0 : l1.val;
            int l2Val = l2==null ? 0 : l2.val;
            int add = l1Val+l2Val+carry;
            carry=0;
            if(add>9){
                carry = 1;
                add = add%10;
            }
            r.next = new ListNode(add);
            r=r.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry==1){
            r.next = new ListNode(carry);
        }
        return reverse(result.next);
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(final String[] args) {
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4, c1);
        ListNode c3 = new ListNode(2, c2);
        ListNode c4 = new ListNode(7, c3);
        ListNode d1 = new ListNode(4);
        ListNode d2 = new ListNode(6, d1);
        ListNode d3 = new ListNode(5, d2);
        // output : 7 -> 8 -> 0 -> 7
        ListNode result = addTwoNumbers(c4, d3);

        ListNode temp = result;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}
