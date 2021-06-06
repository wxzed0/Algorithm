package linked_list;
//排序链表
public class P0148_SortList {

    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }

}
/**
 * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
 *
 * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
 * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
 * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
 * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
 * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
 * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
 * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
 *
 * 主要考察3个知识点，
 * 知识点1：归并排序的整体思想
 * 知识点2：找到一个链表的中间节点的方法
 * 知识点3：合并两个已排好序的链表为一个新的有序链表
 */


/**
 * public ListNode sortList(ListNode head) {
 *         return mergeSort(head);
 *     }
 *
 *     // 归并排序
 *     private ListNode mergeSort(ListNode head){
 *         // 如果没有结点/只有一个结点，无需排序，直接返回
 *         if (head==null||head.next==null) return head;
 *         // 快慢指针找出中位点
 *         ListNode slowp=head,fastp=head.next.next,l,r;
 *         while (fastp!=null&&fastp.next!=null){
 *             slowp=slowp.next;
 *             fastp=fastp.next.next;
 *         }
 *         // 对右半部分进行归并排序
 *         r=mergeSort(slowp.next);
 *         // 链表判断结束的标志：末尾节点.next==null
 *         slowp.next=null;
 *         // 对左半部分进行归并排序
 *         l=mergeSort(head);
 *         return mergeList(l,r);
 *     }
 *     // 合并链表
 *     private ListNode mergeList(ListNode l,ListNode r){
 *         // 临时头节点
 *         ListNode tmpHead=new ListNode(-1);
 *         ListNode p=tmpHead;
 *         while (l!=null&&r!=null){
 *             if (l.val<r.val){
 *                 p.next=l;
 *                 l=l.next;
 *             }else {
 *                 p.next=r;
 *                 r=r.next;
 *             }
 *             p=p.next;
 *         }
 *         p.next=l==null?r:l;
 *         return tmpHead.next;
 *     }
 */


/**
 * //快排版本。头条面试被问到了（貌似提问频率还挺高的），加了很多注释，分享给大家（交换结点版本，非伪排序只交换数值）
 * class Solution3{
 *     public ListNode sortList(ListNode head) {
 *         if(head==null||head.next==null) return head;
 *         // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
 *         ListNode newHead=new ListNode(-1);
 *         newHead.next=head;
 *         return quickSort(newHead,null);
 *     }
 *     // 带头结点的链表快速排序
 *     private ListNode quickSort(ListNode head,ListNode end){
 *         if (head==end||head.next==end||head.next.next==end) return head;
 *         // 将小于划分点的值存储在临时链表中
 *         ListNode tmpHead=new ListNode(-1);
 *         // partition为划分点，p为链表指针，tp为临时链表指针
 *         ListNode partition=head.next,p=partition,tp=tmpHead;
 *         // 将小于划分点的结点放到临时链表中
 *         while (p.next!=end){
 *             if (p.next.val<partition.val){
 *                 tp.next=p.next;
 *                 tp=tp.next;
 *                 p.next=p.next.next;
 *             }else {
 *                 p=p.next;
 *             }
 *         }
 *         // 合并临时链表和原链表，将原链表接到临时链表后面即可
 *         tp.next=head.next;
 *         // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
 *         head.next=tmpHead.next;
 *         quickSort(head,partition);
 *         quickSort(partition,end);
 *         // 题目要求不带头节点，返回结果时去除
 *         return head.next;
 *     }
 * }
 */