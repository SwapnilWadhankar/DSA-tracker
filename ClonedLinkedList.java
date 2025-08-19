public class ClonedLinkedList {
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copy of
        // nodes in between
        insertCopyInBetween(head);
        // Step 2: Connect random
        // pointers of copied nodes
        connectRandomPointers(head);
        // Step 3: Retrieve the deep
        // copy of the linked list
        return getDeepCopyList(head);
    }
    public void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextElement = temp.next;
            // Create a new node with the same data
            Node copy = new Node(temp.val);

            // Point the copy's next to
            // the original node's next
            copy.next = nextElement;

            // Point the original
            // node's next to the copy
            temp.next = copy;

            // Move to the next original node
            temp = nextElement;
        }
    }

    // Function to connect random
// pointers of the copied nodes
    public static void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            // Access the copied node
            Node copyNode = temp.next;

            // If the original node
            // has a random pointer
            if (temp.random != null) {
                // Point the copied node's random to the
                // corresponding copied random node
                copyNode.random = temp.random.next;
            } else {
                // Set the copied node's random to
                // null if the original random is null
                copyNode.random = null;
            }

            // Move to the next original node
            temp = temp.next.next;
        }
    }

    // Function to retrieve the
// deep copy of the linked list
    public static Node getDeepCopyList(Node head) {
        Node temp = head;
        // Create a dummy node
        Node dummyNode = new Node(-1);
        // Initialize a result pointer
        Node res = dummyNode;

        while (temp != null) {
            // Creating a new List by
            // pointing to copied nodes
            res.next = temp.next;
            res = res.next;

            // Disconnect and revert back to the
            // initial state of the original linked list
            temp.next = temp.next.next;
            temp = temp.next;
        }

        // Return the deep copy of the
        // list starting from the dummy node
        return dummyNode.next;
    }

}
