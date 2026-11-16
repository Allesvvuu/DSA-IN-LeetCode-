import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove the matching adjacent character
            } else {
                stack.push(ch); // Keep the character
            }
        }

        // Build the final string from the remaining stack elements
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Reverse because popping from a stack outputs in LIFO order
        return result.reverse().toString();
    }
}
