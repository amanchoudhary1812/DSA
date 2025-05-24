import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReformatData {
    public static String reformatDate(String date) {
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] parts = date.split(" ");
        String day = parts[0].replaceAll("\\D", "");
        if (day.length() == 1) {
            day = "0" + day;
        }
        String month = monthMap.get(parts[1]);
        String year = parts[2];

        return year + "-" + month + "-" + day;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date (e.g., 20th Oct 2052): ");
        String inputDate = scanner.nextLine();
        String reformatted = reformatDate(inputDate);
        System.out.println("Reformatted Date: " + reformatted);
        scanner.close();
    }
}
