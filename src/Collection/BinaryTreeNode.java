package Collection;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeNode {
    public static TreeNode search(TreeNode root, int key) {
        if (root == null || root.val == key)
            return root;
        if (root.val < key)
            return search(root.right, key);
        return search(root.left, key);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);

        System.out.println("Nhap gia tri: ");
        int key = scanner.nextInt();
        TreeNode result = search(root, key);
        if (result != null) {
            System.out.println("Node có giá trị " + key + " được tìm thấy trong cây nhị phân.");
        } else {
            System.out.println("Node có giá trị " + key + " không tồn tại trong cây nhị phân.");
        }
    }
}
