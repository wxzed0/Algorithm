package linked_list;
//两两交换；链表中的结点
public class P0024_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        return dummyHead.next;
    }

}

/**
 *  public ListNode removeNthFromEnd(ListNode head, int n) {
 *
 *         ListNode dummyHead = new ListNode(0);
 *         dummyHead.next = head;
 *
 *         ListNode p = dummyHead;
 *         ListNode q = dummyHead;
 *         for (int i = 0; i < n + 1; i++) {
 *             assert q != null;
 *             q = q.next;
 *         }
 *
 *         while (q != null) {
 *             p = p.next;
 *             q = q.next;
 *         }
 *
 *         p.next = p.next.next;
 *
 *         return dummyHead.next;
 *     }
 */