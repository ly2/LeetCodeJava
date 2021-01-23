public class hasCycle141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; next = null;}
    }


    // much clean!
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==  fast) return true;
        }
        return false;
    }



    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (true) {
            slow = slow.next;
            if (fast != null && fast.next !=null)
                fast = fast.next.next;
            else
                fast = null;
            if (slow == fast)
                break;
        }
        return slow != null;
    }
}
