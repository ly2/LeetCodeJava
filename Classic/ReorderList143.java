
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        You may not modify the values in the list's nodes, only nodes itself may be changed.
*/


import java.util.Stack;

public class ReorderList143 {



     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {
            if (head== null  || head.next == null || head.next.next == null) {
                return;
            }
            int len = 2;
            ListNode tail = head.next;
            Stack<ListNode> stack = new Stack<>();
            stack.push(head.next);
            while (tail.next != null) {
                tail = tail.next;
                len++;
                stack.push(tail);
            }
            int index = len/2;
            for (int i = 0; i < index;i++) {
                ListNode tmp = stack.pop();
                if (i != index-1) {
                    tmp.next = head.next;
                    head.next = tmp;
                    head = head.next.next;
                } else {
                    if (tmp.equals(head.next)) {
                        head.next = tmp;
                        tmp.next = null;
                    } else {
                        tmp.next = head.next;
                        head.next = tmp;
                        head.next.next.next = null;
                    }
                }
            }

        }



//        public void reorderList(ListNode head) {
//            if (head == null) return;
//            ListNode middleNode = findMiddle(head);
//            ListNode head1 = head;
//            ListNode head2 = middleNode.next;
//            middleNode.next = null;
//            head2 = reverse(head2);
//            ListNode nodePtr1 = head1;
//            ListNode nodePtr2 = head2;
//
//            while(nodePtr1 != null && nodePtr2 != null) {
//                ListNode temp1 = nodePtr1.next;
//                nodePtr1.next = nodePtr2;
//                ListNode temp2 = nodePtr2.next;
//                nodePtr2.next = temp1;
//                nodePtr1 = nodePtr1.next.next;
//                nodePtr2 = temp2;
//            }
//
//        }
//
//        private ListNode reverse(ListNode head) {
//
//            ListNode previous = null;
//            ListNode current = head;
//            ListNode forward;
//
//            while (current != null) {
//                forward = current.next;
//                current.next = previous;
//                previous = current;
//                current = forward;
//            }
//            return previous;
//        }
//
//        private ListNode findMiddle(ListNode head) {
//            ListNode slow = head;
//            ListNode fast = head;
//            while(fast !=null && fast.next!= null) {
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//            return slow;
//        }
    }
}
