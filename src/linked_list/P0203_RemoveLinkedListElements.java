package linked_list;
//移除链表元素
public class P0203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else
                cur = cur.next;
        }

        return dummyHead.next;
    }

}

/**
 * public ListNode removeElements(ListNode head, int val) {
 *
 *         if(head == null)
 *             return head;
 *
 *         ListNode node = removeElements(head.next, val);
 *         head.next = node;
 *         return head.val == val ? node : head;
 *     }
 */