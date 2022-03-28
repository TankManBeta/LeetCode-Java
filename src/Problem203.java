/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]

输入：head = [], val = 1
输出：[]

输入：head = [7,7,7,7], val = 7
输出：[]
 */
/*
思路：建一个虚拟头节点，然后每次遍历下一个，如果下一个的val==val，就将当前指针的下一个指向下一个的下一个；否则当前指针指向下一个
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;
        ListNode temp = dummy_head;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return dummy_head.next;
    }
}
