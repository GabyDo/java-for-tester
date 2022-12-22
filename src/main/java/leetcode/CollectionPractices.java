package support;

import java.util.Stack;

public class CollectionPractices {

    public static void main(String args[]) {

        Stack<String> animals= new Stack<>();
        // Add elements to Stack
        animals.push("Dog");
        animals.push("Horse");
        animals.push("Cat");


        System.out.println("Stack: " + animals);
        String s = "()[]{}";
        Boolean t = isValid(s);



    }
    //https://www.geeksforgeeks.org/priority-queue-class-in-java/

    //region Stack: Last In First Out: push(), pop(), https://cafedev.vn/tu-hoc-java-class-stack-trong-java/
//https://leetcode.com/explore/learn/card/queue-stack/


    //20. Valid Parentheses: https://leetcode.com/problems/valid-parentheses/description/
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }



    //endregion Stack

    //region Queue: https://leetcode.com/tag/queue/


    //endregion Queue

   // https://leetcode.com/tag/heap-priority-queue/discuss?currentPage=1&orderBy=hot&query=



}
