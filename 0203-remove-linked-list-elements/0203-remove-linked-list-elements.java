// O(n)
// Java当中的数据类型只有两种，基本类型、引用类型。除了八种基本类型（int、double、float、char等），剩下的全都是引用类型。而Java的引用实际上是对“指针”的一个封装。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     // 节点的构造函数(无参)
 *     ListNode() {}   
 *      // 节点的构造函数(有一个参数)                        
 *     ListNode(int val) { this.val = val; }    
 *     // 节点的构造函数(有两个参数)
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
        return head;
    }
    // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
    ListNode dummy = new ListNode(-1, head);
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null) {
        if (cur.val == val) {
            pre.next = cur.next;
        } else {
            pre = cur;
        }
        cur = cur.next;
    }
    return dummy.next;
}
}