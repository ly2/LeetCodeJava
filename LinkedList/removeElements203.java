public class removeElements203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode cur = head, prev = null;


        while (cur != null) {

            if (cur.val == val) {
                if (prev != null)
                    prev.next = cur.next;
                else
                {
                    head = cur.next;
                }

            } else {
                prev = cur;
            }
            cur = cur.next;

        }

        return head;
    }


    // use the System.gc to collect the garbage memory thus the runtime memory will decrease
    public ListNode removeElements2(ListNode head, int val) {
        ListNode root = new ListNode(0, head);
        rmvVal(root, val);
        System.gc();
        return root.next;
    }

    private void rmvVal(ListNode curr, int val) {
        if (curr.next == null)
            return;

        if (curr.next.val == val) {
            curr.next = curr.next.next;
            rmvVal(curr, val);
        } else {
            rmvVal(curr.next, val);
        }

    }




    // find the head firstly(cause the head may have the same value as the target value)
    // general operation for following nodes
    // 0 ms	39.7 MB
    public ListNode removeElements3(ListNode head, int val) {
        if (head==null) return head;
        while (head != null && head.val==val) head= head.next;
        ListNode current= head;
        ListNode prev=null;
        while (current != null){
            if (current.val==val){
                prev.next= current.next;
                current=current.next;
            }
            else{
                prev= current;
                current=current.next;
            }
        }
        return head;
    }
}
