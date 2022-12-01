import java.util.LinkedList;
import java.util.Queue;

/**
 * User: jia
 * Time: 2022/4/18  10:49
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
       if (queue1.isEmpty()){
           queue1.add(x);
           while (!queue2.isEmpty()){
               Integer e = queue2.poll();
               queue1.add(e);
           }
       }
       else {
           queue2.add(x);
           while (!queue1.isEmpty()){
               Integer e = queue1.poll();
               queue2.add(e);
           }
       }
    }

    public int pop() {
        if (!queue1.isEmpty())
            return queue1.poll();
        else
            return queue2.poll();
    }

    public int top() {
        if (!queue1.isEmpty())
            return queue1.peek();
        else
            return queue2.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
