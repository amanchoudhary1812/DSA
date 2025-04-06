import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

public class ReplaceWords {

    private TrieNode root = new TrieNode();

    // Insert root word into Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Get the shortest root prefix for the word
    private String getPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null || node.isWord)
                break;
            prefix.append(c);
            node = node.children[c - 'a'];
        }
        return node.isWord ? prefix.toString() : word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary)
            insert(word);

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++)
            words[i] = getPrefix(words[i]);

        return String.join(" ", words);
    }

    // Main method for testing
    public static void main(String[] args) {
        ReplaceWords solution = new ReplaceWords();

        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        String result = solution.replaceWords(dictionary, sentence);
        System.out.println("Result: " + result);
    }
}
