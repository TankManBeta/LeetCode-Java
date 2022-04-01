/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

输入：head = [1,2]
输出：[2,1]

输入：head = []
输出：[]
 */
/*
思路：头插法
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode dummy_head = new ListNode(-1);
        while(head!=null){
            ListNode temp = head.next;
            head.next = dummy_head.next;
            dummy_head.next = head;
            head = temp;
        }
        return dummy_head.next;
    }
}
