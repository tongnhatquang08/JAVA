package Collection;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {
    // Thêm một node vào sau một node đã cho
    public static void insertAfter(ListNode prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Node trước đó không tồn tại.");
            return;
        }

        ListNode newNode = new ListNode(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Xóa node ở giữa danh sách liên kết
    public static void deleteNode(ListNode middleNode) {
        if (middleNode == null || middleNode.next == null) {
            System.out.println("Không thể xóa node.");
            return;
        }

        ListNode nextNode = middleNode.next;
        middleNode.val = nextNode.val;
        middleNode.next = nextNode.next;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Danh sách liên kết ban đầu:");
        printList(head);
        // Thêm một node vào sau node 3: 1 -> 2 -> 3 -> 6 -> 4 -> 5
        insertAfter(head.next.next, 6);
        System.out.println("Danh sách liên kết sau khi thêm node 6 vào sau node 3:");
        printList(head);
        // Xóa node ở giữa: 1 -> 2 -> 3 -> 4 -> 5
        deleteNode(head.next.next);
        System.out.println("Danh sách liên kết sau khi xóa node 3:");
        printList(head);
    }
}

