import java.util.*;

public class MinimizeTotalPrice {
    private List<Integer>[] graph;
    private int[] price;
    private int[] freq;
    private int n;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.n = n;
        this.price = price;
        this.freq = new int[n];
        this.graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // Count frequency for each node
        for (int[] trip : trips) {
            dfsCount(trip[0], -1, trip[1]);
        }

        int[] res = dfsDP(0, -1);
        return Math.min(res[0], res[1]);
    }

    // Count frequency of nodes in trip path
    private boolean dfsCount(int u, int parent, int target) {
        if (u == target) {
            freq[u]++;
            return true;
        }
        for (int v : graph[u]) {
            if (v == parent) continue;
            if (dfsCount(v, u, target)) {
                freq[u]++;
                return true;
            }
        }
        return false;
    }

    // DP: [0] = not halved, [1] = halved
    private int[] dfsDP(int u, int parent) 
    {
        int notHalved = freq[u] * price[u];
        int halved = freq[u] * (price[u] / 2);

        for (int v : graph[u]) {
            if (v == parent) continue;
            int[] child = dfsDP(v, u);
            notHalved += Math.min(child[0], child[1]); // child can be halved or not
            halved += child[0]; // if u halved, child must not be halved
        }
        return new int[]{notHalved, halved};
    }

    public static void main(String[] args) {
        MinimizeTotalPrice solver = new MinimizeTotalPrice();

        // Example Input
        int n = 4;
        int[][] edges = {{0,1},{1,2},{1,3}};
        int[] price = {2,2,10,6};
        int[][] trips = {{0,3},{2,1},{2,3}};

        int result = solver.minimumTotalPrice(n, edges, price, trips);

        System.out.println("Minimum Total Price of Trips = " + result);
    }
}
