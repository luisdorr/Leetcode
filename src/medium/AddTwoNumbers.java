//Link: https://leetcode.com/problems/add-two-numbers/
package medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int rest){
        ListNode output = new ListNode(0);

        int sum = l1.val + l2.val + rest;
        rest = sum / 10;
        output.val = sum % 10;

        if(l1.next!=null && l2.next!=null){
            output.next = addTwoNumbers(l1.next, l2.next, rest);
        }else if(l1.next != null){
            output.next = addTwoNumbers(l1.next, new ListNode(0), rest);
        }else if(l2.next != null){
            output.next = addTwoNumbers(new ListNode(0), l2.next, rest);
        }else{
            if(rest != 0)
                output.next = addTwoNumbers(new ListNode(0), new ListNode(0), rest);
        }

        return output;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
