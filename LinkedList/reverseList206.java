public class reverseList206 {
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    // iterative method
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nhead = head;
        head = head.next;
        nhead.next = null;
        ListNode tmp =null;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = nhead;
            nhead = tmp;
        }


        return nhead;
    }



    // recursive method
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next == null) {
//            return head;
//        } else {
//            ListNode tail = head;
//            head = head.next;
//            tail.next = null;
//            return subreverseList(head,tail);
//        }
//
//    }
//    public ListNode subreverseList(ListNode head, ListNode tail) {
//        if (head.next == null) {
//            head.next = tail;
//            return head;
//        } else {
//            ListNode tmp = head.next;
//            head.next = tail;
//            tail = head;
//            return subreverseList(tmp, tail);
//        }
//    }

}
