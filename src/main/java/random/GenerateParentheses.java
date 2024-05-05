package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", 0, 0, result);
        return result;
    }

    private void generateParenthesis(int n, String current, int open, int closed, List<String> result) {

        if (current.length() == 2*n) {
            int count = 0;

            for (char c: current.toCharArray()) {
                if (c == '(') count++;
                if (c == ')') count--;
            }

            if (count == 0) result.add(current);
            return;
        }

        if (open < n) {
            String openString = current + "(";
            generateParenthesis(n, openString, open + 1, closed, result);
        }

        if (closed < n && closed < open) {
            String closedString = current + ")";
            generateParenthesis(n, closedString, open, closed+1, result);
        }
    }
}
