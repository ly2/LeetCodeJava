public class deleteNode237 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public void  deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // What a fucking idiot I am
    public void deleteNode2(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }


}
