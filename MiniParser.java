import java.util.*;

class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer.
    public boolean isInteger() {
        return value != null;
    }

    // @return the single integer that this NestedInteger holds.
    public Integer getInteger() {
        return value;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
        this.list = null;
    }

    // Adds a nested integer to this list.
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(ni);
    }

    // @return the nested list.
    public List<NestedInteger> getList() {
        if (list == null) 
        {
            return new ArrayList<>();
        }
        return list;
    }

    @Override
    public String toString() {
        if (isInteger()) 
        {
            return value.toString();
        } else 
        {
            return list.toString();
        }
    }
}

class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;
        int num = 0;
        boolean negative = false;
        boolean hasNum = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                NestedInteger ni = new NestedInteger();
                if (current != null) {
                    current.add(ni);
                }
                stack.push(ni);
                current = ni;
            } else if (c == ']') 
            {
                if (hasNum) {
                    int value = negative ? -num : num;
                    current.add(new NestedInteger(value));
                    hasNum = false;
                    num = 0;
                    negative = false;
                }
                stack.pop();
                if (!stack.isEmpty()) {
                    current = stack.peek();
                }
            } else if (c == ',') {
                if (hasNum) {
                    int value = negative ? -num : num;
                    current.add(new NestedInteger(value));
                    hasNum = false;
                    num = 0;
                    negative = false;
                }
            } else if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                hasNum = true;
                num = num * 10 + (c - '0');
            }
        }

        return current;
    }
}

public class MiniParser {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nested integer string: ");
        String input = sc.nextLine();

        Solution sol = new Solution();
        
        NestedInteger result = sol.deserialize(input);

        System.out.println("Parsed structure: " + result);
    }
}
