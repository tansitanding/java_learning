package datastruct.zuo.book.charpter01_StackAndQueue;

/*
* 题目：一个getMin功能的栈
* 实现栈的基本功能，实现返回栈中最小元素的功能
* */

import java.util.Stack;

public class class01_MyStack01{
    private Stack<Integer> mainStack;//数据栈
    private Stack<Integer> minStack;//保存对应位置的最小值

    public class01_MyStack01() {
        this.mainStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int num){
        mainStack.push(num);//数据栈入栈
        //比较该数据与当前栈中最小值的关系
        int minVal = num;
        if(!minStack.isEmpty()){
            minVal =Math.min(num,minStack.peek());
        }
        minStack.push(minVal);
    }

    public int pop(){
        if(mainStack.isEmpty()){
            throw new  RuntimeException("your stack is empty");
        }
        int res = mainStack.pop();
        minStack.pop();
        return res;
    }

    public int getMin(){
        if(minStack.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return minStack.peek();
    }

}
