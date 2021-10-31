package datastruct.zuo.book.charpter01_StackAndQueue;


import java.util.Stack;

/*
*   题目：仅用递归函数和栈操作逆序一个栈
*   不可以使用其他数据结构
*   */
public class class03_MyStack02 {
    //递归方法1：获取并移除栈底元素
    public static int  getAndRemoveLastElement(Stack<Integer> stack){
        //第一部分：结束递归的条件
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }
        //第二部分：正常流程：取出栈顶--》递归--》放回栈顶
        int last = getAndRemoveLastElement(stack);
        stack.push(res);
        return last;
    }

    //递归方法2：逆序栈
    public static  void reverseStack(Stack<Integer> stack){
        //第一部分：终结条件
        if(stack.isEmpty()){
            return;
        }
        //第二部分：正常流程：获取栈底值--逆序--放到栈顶
        int cur =getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(cur);
    }

}
