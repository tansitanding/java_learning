package datastruct.zuo.book.charpter01_StackAndQueue;

import java.util.Stack;

public class class05_SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        int cur;
        //将stack元素全部移到help中，顶小底大
        while (!stack.isEmpty()) {
            cur = stack.pop();
            //如果help栈顶小于当前元素，就加到stack中
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        //help中元素塞回来
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
