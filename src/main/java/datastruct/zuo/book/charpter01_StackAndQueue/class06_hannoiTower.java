package datastruct.zuo.book.charpter01_StackAndQueue;

import java.util.Stack;

public class class06_hannoiTower {
    public int hanoiProblem(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        //比对小压大原则，需要peek，每个stack有个稳定不动的底
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        //初始化L栈，塞入数据
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {
            //不停尝试，穷举法，每一次循环至少有一步成功
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
        }
        return step;
    }

    /**
     * 试图移动元素
     *
     * @param record    上一次动作
     * @param preNoAct  相逆动作
     * @param nowAction 试图执行动作
     * @param fStack    源栈
     * @param tStack    目标栈
     * @param from      输出：起源
     * @param to        输出：目标
     * @return
     */
    public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAction,
                                     Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        //小压大+不相逆原则满足
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move" + tStack.peek() + "from" + from + "to" + to);
            record[0] = nowAction;
            return 1;
        }
        return 0;
    }
}

enum Action {
    No,
    LToM,
    MToL,
    MToR,
    RToM
}
