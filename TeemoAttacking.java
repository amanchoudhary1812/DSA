public class TeemoAttacking {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        int totalDuration = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalDuration += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return totalDuration + duration;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] timeSeries = {1, 4};
        int duration = 2;

        // Function Call
        int totalPoisonedDuration = findPoisonedDuration(timeSeries, duration);

        // Output
        System.out.println("Total Poisoned Duration: " + totalPoisonedDuration);
    }
}
