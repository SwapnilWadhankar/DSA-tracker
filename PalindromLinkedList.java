public class PalindromLinkedList {
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
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null || head.next==null){
            return true;
        }
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headNode = reverseList(slow.next);
        ListNode first = head;
        ListNode second = headNode;
        while(second != null){
            if(first.val != second.val){
                reverseList(second);
                return false;
            }else{
                first = first.next;
                second = second.next;
            }
        }
        reverseList(second);
        return true;

    }
}
