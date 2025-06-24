import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example: input for tree: 1 2 null null 5 null null 3 null null
        System.out.println("Enter tree nodes in pre-order (use 'null' for no node):");
        TreeNode root = buildTree(scanner);

        List<String> paths = binaryTreePaths(root);
        System.out.println("Binary Tree Paths:");
        for (String path : paths) {
            System.out.println(path);
        }

        scanner.close();
    }

    private static TreeNode buildTree(Scanner scanner) {
        if (!scanner.hasNext()) return null;
        String val = scanner.next();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(scanner);
        node.right = buildTree(scanner);
        return node;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private static void dfs(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, path + node.val + "->", paths);
            }
            if (node.right != null) {
                dfs(node.right, path + node.val + "->", paths);
            }
        }
    }
}  
