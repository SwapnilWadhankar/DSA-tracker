public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.insert(1);
        list1.insert(4);
        list1.insert(7);
        list2.insert(2);
        list2.insert(3);
        list2.insert(6);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next= list1;
                list1=list1.next;
            }else{
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }
        if(list1!=null){
            current.next=list1;
        }else{
            current.next=list2;
        }
        return dummy.next;
    }
}
