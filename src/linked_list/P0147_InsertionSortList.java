package linked_list;
//对链表进行插入排序
public class P0147_InsertionSortList {
    //想要排序块，就要尽可能少的做比较
//需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
//需要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
//每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
//如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while(head != null && head.next != null) {
            if(head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}

/**
 * //建立dummy节点的原因是： 快速排序可能会插入头部，用dummy会让插入头部和其他位置操作一致
 * //        需要维护一个至今位置有序的节点。叫做lastOrdered，因为需要把当前元素cur插到前面有序链表中，要将最后一个元素与cur后面的元素建立连接。后面遍历也比较方便。
 * //        用以一个前驱节点pre来找到需要插入的位置，找到第一个满足 pre.next >= cur.val 的前驱节点。 将cur插入其后面。
 * //        最后 cur 更新为 lastOrdered后面的元素， 即下一个需要进行插入排序的链表元素。
 * public ListNode insertionSortList(ListNode head) {
 *         if (head == null || head.next == null) {
 *             return head;
 *         }
 *         ListNode dummy = new ListNode(-1);
 *         dummy.next = head;
 *         ListNode lastOrdered = head;
 *         ListNode cur = head.next;
 *         while (cur != null) {
 *             if (cur.val >= lastOrdered.val) {
 *                 lastOrdered = cur;
 *             } else {
 *                 ListNode pre = dummy;
 *                 while (pre.next.val < cur.val) {
 *                     pre = pre.next;
 *                 }
 *                 lastOrdered.next = cur.next;
 *                 cur.next = pre.next;
 *                 pre.next = cur;
 *             }
 *             cur = lastOrdered.next;
 *         }
 *         return dummy.next;
 */