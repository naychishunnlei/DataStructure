package solutions.code5_Postfix;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_661090 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        Stack<Double> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(rpn);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        return stack.pop(); // The result of the RPN expression
    }

    public static void main(String[] args) {
        String rpn = "3 4 + 2 * 7 /"; // Example RPN expression
        double result = computeRPN(rpn);
        System.out.println("Result: " + result); // Expected output: 2.0
    }
}
