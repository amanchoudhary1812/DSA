import java.util.*;

public class PushDominoes {

    public static String pushDominoes(String dominoes) {

        char[] arr = ("L" + dominoes + "R").toCharArray();

        int n = arr.length;
        int i = 0;

        StringBuilder ans = new StringBuilder();

        for (int j = 1; j < n; j++) {

            if (arr[j] == '.') {
                continue;
            }

            int middle = j - i - 1;

            // Ignore first virtual 'L'
            if (i > 0) {
                ans.append(arr[i]);
            }

            // Same force direction
            if (arr[i] == arr[j]) {

                for (int k = 0; k < middle; k++) {
                    ans.append(arr[i]);
                }

            }
            // L ... R
            else if (arr[i] == 'L' && arr[j] == 'R') {

                for (int k = 0; k < middle; k++) {
                    ans.append('.');
                }

            }
            // R ... L
            else {

                for (int k = 0; k < middle / 2; k++) {
                    ans.append('R');
                }

                if (middle % 2 == 1) {
                    ans.append('.');
                }

                for (int k = 0; k < middle / 2; k++) {
                    ans.append('L');
                }
            }

            i = j;
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input domino string
        String dominoes = sc.nextLine();

        // Print result
        System.out.println(pushDominoes(dominoes));

        sc.close();
    }
}