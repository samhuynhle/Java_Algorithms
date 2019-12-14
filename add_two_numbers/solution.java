
/*
Definition for singly-linked list.

function ListNode(val) {
this.val = val;
this.next = null;
}

This function will take two linked lists that represent numbers in reverse order.
847 will be 7 -> 4 -> 8. The function will return a linked list that adds the values
of both input linked list.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // we need a dummy node so we can keep track of the head
        ListNode current = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null) { // our loop condition is while either of the linked list is valid
            int sum = carry + ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0); // this is where we get the value for the sum
            carry = sum / 10; // if there's a carry it will return 1
            current.next = new ListNode(sum % 10); // we add to our list
            current = current.next; // we move our current marker

            // we only move the markers in the linked list if there are valid values
            l1 = ((l1 != null) ? l1.next : l1);
            l2 = ((l2 != null) ? l2.next : l2);
        }
        if(carry > 0) { // if there was a left over carry, then add it to our list
            current.next = new ListNode(carry);
        }
        return dummyHead.next; // we return the new linked list
    }
}