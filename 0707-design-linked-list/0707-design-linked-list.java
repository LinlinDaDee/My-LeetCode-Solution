// singly linked list
// Assume all nodes in the linked list are 0-indexed (假设链表中的所有节点下标从 0 开始)
// 要时刻注意current node的位置

// define the structure of ListNode
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;

    // Initializes the MyLinkedList object
    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }
    
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    // 先连接(new node -> 下一项), 再连接(前驱 -> new node)
    // index为0，那么新插入的节点为链表的新头节点
    // index = size，则说明是新插入的节点为链表的尾结点
    public void addAtIndex(int index, int val) {
        // If index is greater than the length, the node will not be inserted => return null
        if (index < 0 || index > size){
            return;
        }

        // 找到要插入节点的前驱
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        // 插入节点
        size++;
        ListNode newNode = new ListNode(val);        
        newNode.next = pre.next;
        pre.next = newNode;      
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        // 找到要delete节点的前驱
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */