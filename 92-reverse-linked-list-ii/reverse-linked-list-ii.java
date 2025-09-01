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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }
        //set prev to last of reverse sublist and current to left element
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=1;i<left;i++){
            prev=prev.next;
        }
        //loop for reversal
        ListNode curr=prev.next;
        ListNode next=null;
        ListNode prevSub=null;

        for(int i=0;i<=right-left;i++){
            next=curr.next;
            curr.next=prevSub;
            prevSub=curr;
            curr=next;
        }
        prev.next.next=curr; // tail of reversed part connects to right+1 node
        prev.next=prevSub;    // prev connects to new head of reversed part
        
        return dummy.next;
    }
}