package linked_list;
//翻转链表
public class P0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

/**
 *  public ListNode reverseList(ListNode head) {
 *
 *         // 递归终止条件
 *         if(head == null|| head.next == null)
 *             return head;
 *
 *         ListNode rhead = reverseList(head.next);
 *
 *         // head->next此刻指向head后面的链表的尾节点
 *         // head->next->next = head把head节点放在了尾部
 *         head.next.next = head;
 *         head.next = null;
 *
 *         return rhead;
 *     }
 */