package linked_list;
//删除链表的倒数第N个结点  MMM
public class P0019_RemoveNthNodeFromEndOfList {
//虚拟头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next)
            length++;

        int k = length - n;
        assert k >= 0;
        ListNode cur = dummyHead;
        for (int i = 0; i < k; i++)
            cur = cur.next;

        cur.next = cur.next.next;

        return dummyHead.next;
    }
}

/**
 *
 * public ListNode removeNthFromEnd(ListNode head, int n) {
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
 *
 */

/**
 * //一次遍历的方法，但使用了一个额外的map空间来存储遍历的各个节点及其位置。
 * // 空间上可以进一步优化，也就是不使用额外的map。而是使用两个节点，
 * // 一个是first一个是second。先让first走n步，然后再让first和second同时往前走，
 * // 当first走到头时，second即是倒数第n+1个节点了。
 * class Solution3 {
 *     public ListNode removeNthFromEnd(ListNode head, int n) {
 *         ListNode temp = head;
 *         Map<Integer,ListNode> m = new HashMap<Integer,ListNode>();
 *         int index=1;
 *         while(temp!=null){
 *             m.put(index++,temp);
 *             temp = temp.next;
 *         }
 *         int size = m.size();
 *         if(size == 1)
 *             return null;
 *         if(n == 1){
 *             m.get(size-1).next = null;
 *         }else if(n == size){
 *             head = head.next;
 *         }else{
 *             m.get(size-n).next = m.get(size-n+2);
 *         }
 *         return head;
 *     }
 * }
 */
