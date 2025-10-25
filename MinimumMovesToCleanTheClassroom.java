import java.util.*;

public class MinimumMovesToCleanTheClassroom {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] classroom = new String[m];
        System.out.println("Enter the classroom grid row by row:");
        for (int i = 0; i < m; i++) {
            classroom[i] = sc.nextLine();
        }

        System.out.print("Enter initial energy: ");
        int energy = sc.nextInt();

        MinimumMovesToCleanTheClassroom solution = new MinimumMovesToCleanTheClassroom();
        int minMoves = solution.minMovesToCollectLitter(classroom, energy);

        System.out.println("Minimum moves to collect all litter: " + minMoves);
    }

    public int minMovesToCollectLitter(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int totalLitter = 0;
        int startRow = -1, startCol = -1;
        List<int[]> litterPositions = new ArrayList<>();
        Map<String, Integer> distanceMap = new HashMap<>();

        // Identify positions of interest
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = classroom[i].charAt(j);
                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (cell == 'L') {
                    litterPositions.add(new int[]{i, j});
                    totalLitter++;
                }
            }
        }

        if (totalLitter == 0) return 0;

        // BFS to find distances between all litter positions
        for (int i = 0; i < litterPositions.size(); i++) {
            for (int j = i + 1; j < litterPositions.size(); j++) {
                int[] start = litterPositions.get(i);
                int[] end = litterPositions.get(j);
                int distance = bfs(classroom, start[0], start[1], end[0], end[1], energy);
                if (distance != -1) {
                    distanceMap.put(start[0] + "," + start[1] + "-" + end[0] + "," + end[1], distance);
                    distanceMap.put(end[0] + "," + end[1] + "-" + start[0] + "," + start[1], distance);
                }
            }
        }

        int allCollected = (1 << totalLitter) - 1;
        int[][] dp = new int[totalLitter + 1][1 << totalLitter];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int mask = 0; mask <= allCollected; mask++) {
            for (int i = 0; i < totalLitter; i++) {
                if ((mask & (1 << i)) == 0) continue;
                for (int j = 0; j < totalLitter; j++) {
                    if ((mask & (1 << j)) != 0) continue;
                    String key = i + "," + j;
                    int distance = distanceMap.getOrDefault(key, Integer.MAX_VALUE);
                    if (distance != Integer.MAX_VALUE) {
                        dp[j][mask | (1 << j)] = Math.min(dp[j][mask | (1 << j)], dp[i][mask] + distance);
                    }
                }
            }
        }

        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i < totalLitter; i++) {
            minMoves = Math.min(minMoves, dp[i][allCollected]);
        }

        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }

    private int bfs(String[] classroom, int startRow, int startCol, int endRow, int endCol, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        boolean[][][] visited = new boolean[m][n][energy + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, energy, 0});
        visited[startRow][startCol][energy] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], remEnergy = curr[2], dist = curr[3];

            if (row == endRow && col == endCol) return dist;

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || classroom[newRow].charAt(newCol) == 'X')
                    continue;

                int newEnergy = remEnergy - 1;
                if (newEnergy < 0) continue;
                
                if (classroom[newRow].charAt(newCol) == 'R') newEnergy = energy;

                if (!visited[newRow][newCol][newEnergy]) {
                    visited[newRow][newCol][newEnergy] = true;
                    queue.offer(new int[]{newRow, newCol, newEnergy, dist + 1});
                }
            }
        }

        return -1;
    }
}
