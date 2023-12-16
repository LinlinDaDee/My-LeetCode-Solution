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
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp; 
        }
        return pre;
    }
}

// // 递归 
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         return reverse(null, head);
//     }

//     private ListNode reverse(ListNode prev, ListNode cur) {
//         if (cur == null) {
//             return prev;
//         }
//         ListNode temp = null;
//         temp = cur.next;// 先保存下一个节点
//         cur.next = prev;// 反转
//         // 更新prev、cur位置
//         // prev = cur;
//         // cur = temp;
//         return reverse(cur, temp);
//     }
// }