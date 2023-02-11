package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: jia
 * Time: 2023/2/9  16:14
 * Description:
 * Version:
 */
public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        int ans = 0;
        // 依次弹出queue1，把元素复制到queue2中，取最后一个元素
        while (!queue1.isEmpty()){
            if (queue1.size() == 1){
                ans = queue1.poll();
            }else {
                queue2.offer(queue1.poll());
            }
        }
        // queue2 复制回去queue1
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return ans;
    }

    public int top() {
        int ans = 0;
        // 依次弹出queue1，把元素复制到queue2中，取最后一个元素
        while (!queue1.isEmpty()){
            if (queue1.size() == 1){
                ans = queue1.poll();
            }
            queue2.offer(queue1.poll());
        }
        // queue2 复制回去queue1
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return ans;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
