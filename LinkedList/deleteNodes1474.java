public class deleteNodes1474 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; next = null;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    // much clean and less runtime space!
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode currentNode = head;
        ListNode lastMNode = head;
        while (currentNode != null) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // traverse m nodes
            while (currentNode != null && mCount != 0) {
                lastMNode = currentNode;
                currentNode = currentNode.next;
                mCount--;
            }
            // traverse n nodes
            while (currentNode != null && nCount != 0) {
                currentNode = currentNode.next;
                nCount--;
            }
            // delete n nodes
            lastMNode.next = currentNode;
        }
        return head;
    }


    public ListNode deleteNodes2(ListNode head, int m, int n) {
        ListNode curr = head;

        while (curr != null) {
            for (int i = 1; i < m ;i++) {
                if (curr != null)
                    curr = curr.next;
                else
                    return head;
            }
            curr = deleteN(curr, n);
        }



        return head;
    }

    ListNode deleteN(ListNode curr, int n) {
        if (curr == null)
            return null;
        ListNode del = curr;
        while (del !=null) {
            del = del.next;
            if (--n <0)
                break;
        }
        curr.next = del;
        return del;
    }
}
