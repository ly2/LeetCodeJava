public class mergeTwoLists21 {

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


      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode newl = null;
            if (l1.val <= l2.val) {
                newl = l1;
                l1 = l1.next;
            } else {
                newl = l2;
                l2 = l2.next;
            }
          ListNode merged = newl;


            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    merged.next = l2;
                    break;
                }
                if (l2 == null) {
                    merged.next = l1;
                    break;
                }

                if (l1.val <= l2.val) {
                    merged.next = l1;
                    merged = merged.next;
                    l1 = l1.next;
                } else {
                    merged.next = l2;
                    merged = merged.next;
                    l2 = l2.next;
                }

            }

            return newl;

      }

}
