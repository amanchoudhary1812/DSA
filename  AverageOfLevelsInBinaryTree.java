import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int val) {
//         this.val = val;
//     }
// }

public class AverageOfLevelsInBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            double averageLevel = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                averageLevel += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            averageLevel = averageLevel / levelSize;
            result.add(averageLevel);
        }

        return result;
    }

    // public static void main(String[] args) {

    //     TreeNode root = new TreeNode(3);
    //     root.left = new TreeNode(9);
    //     root.right = new TreeNode(20);
    //     root.right.left = new TreeNode(15);
    //     root.right.right = new TreeNode(7);

    //     System.out.println(averageOfLevels(root));
    // }
}