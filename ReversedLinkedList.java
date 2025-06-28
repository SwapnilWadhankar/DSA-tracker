public class ReversedLinkedList {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current!=null){
            ListNode nextNode = current.next;
            current.next  = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
