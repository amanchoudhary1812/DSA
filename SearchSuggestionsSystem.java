import java.util.*;

public class SearchSuggestionsSystem {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0, right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }
            List<String> suggestions = new ArrayList<>();
            for (int j = left; j <= right && j < left + 3; j++) {
                suggestions.add(products[j]);
            }
            result.add(suggestions);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of products:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        String[] products = new String[n];
        System.out.println("Enter product names:");
        for (int i = 0; i < n; i++) {
            products[i] = sc.nextLine();
        }
        System.out.println("Enter search word:");
        String searchWord = sc.nextLine();
        
        List<List<String>> suggestions = suggestedProducts(products, searchWord);
        System.out.println("Search suggestions:");
        for (List<String> list : suggestions) {
            System.out.println(list);
        }
        sc.close();
    }
}
