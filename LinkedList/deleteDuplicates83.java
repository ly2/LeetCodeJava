public class deleteDuplicates83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head, ite = head;
        boolean dup = false;
        while (ite != null) {
            if (ite.val != curr.val) {
                curr.next = ite;
                curr = ite;
            }
            ite = ite.next;
        }
        curr.next = null;


        return head;
    }



    // use a slow node and fast node, good method!
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 0 - 1 - 2 - 3 - 3 - null
        //     s
        //.         2 - 3 - 3 - null
        //          f
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
            } else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return head;
    }
}
