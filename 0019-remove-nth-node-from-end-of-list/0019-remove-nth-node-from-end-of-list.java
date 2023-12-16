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


 // 双指针fast和slow, 让fast先走n步, 然后再让slow和fast一起向后走, 直到fast走到最后一个元素
 // slow(操作指针)的位置就是待删除元素的前一个位置

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // 让快慢指针相差 n 个结点(the gap between first and second is n nodes apart)
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        // 再让 slow 和 fast 一起向后走, 直到 fast 走到最后一个元素
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // 此时 slow 的位置就是待删除元素的前一个位置, fast 的位置在最后一个元素
        slow.next = slow.next.next;
        return dummy.next;
    }
}