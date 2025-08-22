import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap based on node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Insert the head of each list into the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy head to simplify result list construction
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Extract the smallest node from heap and add next node from that list
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }


}
