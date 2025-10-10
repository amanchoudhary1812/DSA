import java.util.*;

public class MaximumStrongPairXOR {

    // ----- Trie Node -----
    static class TrieNode {
        TrieNode[] next = new TrieNode[2];
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
    }

    private static TrieNode root = new TrieNode();
    private static final int MAX_BIT = 30; // Assuming numbers fit in 32-bit int

    // ----- Insert a number into trie -----
    private static void insert(int x) {
        TrieNode node = root;
        node.mn = Math.min(node.mn, x);
        node.mx = Math.max(node.mx, x);
        for (int b = MAX_BIT; b >= 0; b--) {
            int bit = (x >> b) & 1;
            if (node.next[bit] == null) node.next[bit] = new TrieNode();
            node = node.next[bit];
            node.mn = Math.min(node.mn, x);
            node.mx = Math.max(node.mx, x);
        }
    }

    // ----- Query best XOR for a number -----
    private static int query(int x) {
        TrieNode node = root;
        int ans = 0;
        for (int b = MAX_BIT; b >= 0; b--) {
            int bit = (x >> b) & 1;
            int toggled = bit ^ 1;

            // Try opposite bit first for maximum XOR
            if (node.next[toggled] != null) {
                int mnChild = node.next[toggled].mn;
                int mxChild = node.next[toggled].mx;
                if (mxChild > x && mnChild <= 2 * x) {
                    ans |= (1 << b);
                    node = node.next[toggled];
                    continue;
                }
            }

            if (node.next[bit] != null) {
                node = node.next[bit];
            } else {
                break;
            }
        }
        return ans;
    }

    // ----- Main function to find Maximum Strong Pair XOR -----
    public static int maximumStrongPairXor(int[] nums) {
        for (int x : nums) insert(x);
        int res = 0;
        for (int x : nums) res = Math.max(res, query(x));
        return res;
    }

    // ----- Main Method (with input) -----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maximumStrongPairXor(nums);
        
        System.out.println("Maximum Strong Pair XOR: " + result);
        sc.close();
    }
}
