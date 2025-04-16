import java.util.*;

public class FrogJump {
    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> stoneJumps = new HashMap<>();
        for (int stone : stones) {
            stoneJumps.put(stone, new HashSet<>());
        }
        stoneJumps.get(0).add(0);

        for (int stone : stones) {
            for (int jump : stoneJumps.get(stone)) {
                for (int step = jump - 1; step <= jump + 1; step++) {
                    if (step > 0 && stoneJumps.containsKey(stone + step)) {
                        stoneJumps.get(stone + step).add(step);
                    }
                }
            }
        }

        return !stoneJumps.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stones: ");
        int n = sc.nextInt();
        int[] stones = new int[n];

        System.out.println("Enter stone positions: ");
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        boolean result = canCross(stones);
        System.out.println("Can the frog cross? " + result);
    }
}
