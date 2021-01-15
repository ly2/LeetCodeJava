

public class getIntersectionNode160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null? headB:a.next;
            b = b == null? headA:b.next;
        }


        return a;
    }
}
