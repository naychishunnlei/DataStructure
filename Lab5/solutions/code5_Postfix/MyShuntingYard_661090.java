package solutions.code5_Postfix;

import java.util.StringTokenizer;

public class MyShuntingYard_661090 {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static String infixToPostfix(String infixString) {
        MyQueueL_661090<String> queue = new MyQueueL_661090<>();
        MyStackL_661090 stack = new MyStackL_661090();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN_661090.isNumeric(t))
                queue.enqueue(t);
            else if(t.equals("(")) {
                stack.push(t);
            }
            else if(t.equals(")")) {
                while(!stack.peek().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                stack.pop();
            } else {
                if(!stack.isEmpty()) {
                    while(!stack.isEmpty() && order(stack.peek()) >= order(t)) {
                        queue.enqueue(stack.pop());
                    }
                }
                stack.push(t);
            }
            //System.out.println("current q = " + queue.dumpToString());
        }    
        while(!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        resultPostfixString = queue.dumpToString();
        return resultPostfixString;
    }
}