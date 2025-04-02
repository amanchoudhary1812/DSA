import java.util.*;

public class DuplicateFileInSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFilePaths = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];
                int openBracket = file.indexOf('(');
                int closeBracket = file.indexOf(')');
                String fileName = file.substring(0, openBracket);
                String content = file.substring(openBracket + 1, closeBracket);
                String fullPath = directory + "/" + fileName;

                contentToFilePaths.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
            }
        }

        List<List<String>> duplicates = new ArrayList<>();
        for (List<String> filePaths : contentToFilePaths.values()) {
            if (filePaths.size() > 1) {
                duplicates.add(filePaths);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of directory entries:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] paths = new String[n];
        System.out.println("Enter directory entries:");
        for (int i = 0; i < n; i++) {
            paths[i] = scanner.nextLine();
        }
        scanner.close();

        List<List<String>> result = findDuplicate(paths);
        System.out.println("Duplicate files:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
