public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().deleteDuplicates(new ListNode(1, new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(3)))))));
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next !=null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
