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

// 操作的指针一定要指向需要反转的两个节点的前一个节点(eg,要反转头两个节点要操作的指针一定是dummy_head)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode firstNode;
        ListNode secondNode;
        ListNode temp;

        // 必须要先判断pre.next然后再判断pre.next.next, 因为如果不存在pre.next的话pre.next.next就会出现空指针异常
        while (pre.next != null && pre.next.next != null) {
            firstNode = pre.next;
            secondNode = pre.next.next;
            pre.next = secondNode;
            temp = secondNode.next;
            secondNode.next = firstNode;
            firstNode.next = temp;
            pre = pre.next.next;
        }
        return dummyHead.next;
    }
}