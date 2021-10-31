package datastruct.zuo.book.charpter01_StackAndQueue;

import java.util.Stack;

public class class02_twoStackQueue {
    /*
    * 题目：两个栈组成的队列
    * */

        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

    public class02_twoStackQueue() {
        this.popStack = new Stack<Integer>();
        this.pushStack = new Stack<Integer>();
    }

    public void add(int num){
        pushStack.push(num);
    }

    public int poll(){
        //step1：判断意外情况，队列为空==入栈为空+出栈为空
        if(pushStack.isEmpty()&&popStack.isEmpty()){
            throw new RuntimeException("your queue is empty");
        }
        //step2:当出栈为空时，更新内部结构，将入栈内容全部移入出栈
        //注意：该操作只在出栈为空时，否则打乱顺序
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        //step3:移除元素
        return popStack.pop();
    }

    public int peek(){
        //step1：判断意外情况，队列为空==入栈为空+出栈为空
        if(pushStack.isEmpty()&&popStack.isEmpty()){
            throw new RuntimeException("your queue is empty");
        }
        //step2:当出栈为空时，更新内部结构，将入栈内容全部移入出栈
        //注意：该操作只在出栈为空时，否则打乱顺序
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        //step3:取出元素
        return popStack.peek();
    }

}
