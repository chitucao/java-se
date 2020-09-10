package cn.chitucao.leetcode.level1simple;

import java.util.Stack;

public class Q20有效的括号 {

    public static void main(String[] args) {
        String str = "{[{}]}{}";
        System.out.println(isValidA(str));
    }

    public static boolean isValidA(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
                //empty用于判断：右边 > 左边
            } else if (c != stack.pop() || stack.empty()) {
                return false;
            }
        }
        //判断左边 > 右边，全部pop后还剩余
        return stack.isEmpty();
    }

    public static boolean isValidB(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }


                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
