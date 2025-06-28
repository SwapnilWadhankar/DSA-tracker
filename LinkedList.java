public class LinkedList {
    private ListNode head;

    // Insert at end
    public void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Insert at beginning
    public void insertAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Delete a node with a given value
    public void delete(int val) {
        if (head == null) return;

        if (head.val == val) {
            head = head.next;
            return;
        }

        ListNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // Search for a value
    public boolean search(int val) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) return true;
            curr = curr.next;
        }
        return false;
    }

    // Display the list
    public void printList() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
