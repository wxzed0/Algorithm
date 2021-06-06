package linked_list;
//删除链表中的结点  MMMM
public class P0237_DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {

        if (node == null || node.next == null)
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
