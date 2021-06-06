package linked_list;
//删除排序链表中的重复元素
public class P0083_RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}

/**
 *  public ListNode deleteDuplicates(ListNode head) {
 *         if(head == null || head.next == null){
 *             return head;
 *         }
 *         head.next = deleteDuplicates(head.next);
 *         if(head.val == head.next.val) head = head.next;
 *         return head;
 *     }
 */