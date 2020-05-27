import java.io.*;
import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode s = new ListNode();
        if(l1==null && l2==null){
            return s.next;
        }
        ListNode r = s;
        while(l1!=null || l2!=null){
            if(l1==null){
                // append l2
                int sum = carry+l2.val;
                carry=0;
                if(sum>9){
                    carry=1;
                    sum=sum%10;
                }
                r.next = new ListNode(sum);
                l2=l2.next;
                r=r.next;
            } else if(l2==null){
                // append l1
                int sum = carry+l1.val;
                carry=0;
                if(sum>9){
                    carry=1;
                    sum=sum%10;
                }
                r.next = new ListNode(sum);
                l1=l1.next;
                r=r.next;
            } else {
                // add and append val
                int sum = carry+l1.val+l2.val;
                carry=0;
                if(sum>9){
                    carry=1;
                    sum=sum%10;
                }
                r.next = new ListNode(sum);
                l1=l1.next;
                l2=l2.next;
                r=r.next;
            }
        }
        if(carry==1){
            r.next= new ListNode(carry);
        }
        return s.next;
    }

    public static void main(final String... args) {
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4, c1);
        ListNode c3 = new ListNode(2, c2);
        ListNode d1 = new ListNode(4);
        ListNode d2 = new ListNode(6, d1);
        ListNode d3 = new ListNode(5, d2);
        // output : 7 -> 0 -> 8
        ListNode result = addTwoNumbers(c3, d3);

        ListNode temp = result;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}