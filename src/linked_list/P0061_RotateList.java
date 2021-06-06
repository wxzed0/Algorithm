package linked_list;
//旋转链表
public class P0061_RotateList {

    //其实本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode cursor=head;
        ListNode tail=null;//尾指针
        int length=1;
        while(cursor.next!=null)//循环 得到总长度
        {
            cursor=cursor.next;
            length++;
        }
        int loop=length-(k%length);//得到循环的次数
        tail=cursor;//指向尾结点
        cursor.next=head;//改成循环链表
        cursor=head;//指向头结点
        for(int i=0;i<loop;i++){//开始循环
            cursor=cursor.next;
            tail=tail.next;
        }
        tail.next=null;//改成单链表
        return cursor;//返回当前头
    }

}

/**
 * public ListNode rotateRight(ListNode head, int k) {
 *         if (head == null || head.next == null || k == 0) return head;
 *
 *         int count = 1; // 用来统计链表总结点数
 *         ListNode tmp = head;
 *         while (tmp.next != null) {
 *             count++;
 *             tmp = tmp.next;
 *         }
 *         k %= count;
 *         // 当k为0时，不需要旋转，
 *         if (k == 0) return head;
 *
 *         // 不满足上述条件，必将进行旋转，所以先将首尾相连
 *         tmp.next = head;
 *         // 现在只需要找到倒数第k+1个节点
 *         for (int i = 0; i < count - k; i++) {
 *             tmp = tmp.next;
 *         }
 *         ListNode newHead = tmp.next;
 *         tmp.next = null;
 *         return newHead;
 *     }
 */