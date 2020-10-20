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
    ListNode node = new ListNode();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            val += next;
            next = val / 10;
            addNode(new ListNode(val % 10));
        }
        if(next != 0){
            addNode(new ListNode(next));
        }
        return node.next;
    }

    public void addNode(ListNode n) {
        ListNode tmp = this.node;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = n;
    }
}