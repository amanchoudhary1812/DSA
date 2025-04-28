import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int last = stack.pop();
                    int secondLast = stack.peek();
                    int sum = last + secondLast;
                    stack.push(last);
                    stack.push(sum);
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for (int score : stack) {
            total += score;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter operations separated by space:");
        String input = scanner.nextLine();
        String[] ops = input.split(" ");
        int result = calPoints(ops);
        System.out.println("Total points: " + result);
    }
}
