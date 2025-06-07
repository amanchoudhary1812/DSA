import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    // Helper function to build a binary tree from a level-order input array
    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // Main method to test the function
    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();

        // Example 1: Symmetric tree
        Integer[] input1 = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root1 = buildTree(input1);
        System.out.println("Is tree symmetric? " + solution.isSymmetric(root1)); // true

        // Example 2: Non-symmetric tree
        Integer[] input2 = {1, 2, 2, null, 3, null, 3};
        TreeNode root2 = buildTree(input2);
        System.out.println("Is tree symmetric? " + solution.isSymmetric(root2)); // false
    }
}
