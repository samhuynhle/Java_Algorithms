
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = carry + ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0);
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = ((l1 != null) ? l1.next : l1);
            l2 = ((l2 != null) ? l2.next : l2);
        }
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}