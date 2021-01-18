public class ByteDance1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode flipk (ListNode head) {

        int i = 1;
        int count = 0;
        ListNode curr = head;
        ListNode head2 = head;
        ListNode tmp;

        while (curr != null) {
            if (i+1 == 3) {
                tmp = curr.next;
                curr.next = tmp.next;
                tmp.next = head2;
                head2 = tmp;
                i = 0;
                count++;
            }
            i++;
            curr = curr.next;

        }

        curr = head;
        for (int c = 0; c < count; c++ ) {
            curr = curr.next;
            tmp = curr.next;
            curr.next = head2;
            head2 = head2.next;
            curr.next.next = tmp;
            curr = tmp;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 18; i++) {
            ListNode tmp = new ListNode(i);
            cur.next = tmp;
            cur = tmp;
        }


        ListNode ans = flipk(head);
//        ListNode ans = head;
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
