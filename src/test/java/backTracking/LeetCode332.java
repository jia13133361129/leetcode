package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode332 {

    @Test
    public void main() {

    }

    List<String> res;
    List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        // 对tickets 进行字典序排序
        // 排序的是第2个值（终点值），因为往path里面加的是终点值
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        int len = tickets.size();
        boolean[] flag = new boolean[len];
        path.add("JFK");
        backTracking(tickets,flag,0,len);
        return res;
    }

    // 返回值为boolean,目的是为了提前返回
    public boolean backTracking(List<List<String>> tickets, boolean[] flag, int count,int len){
        if (count == len){
            res = new ArrayList<>(path);
            return true;
        }
        String tail = path.get(path.size() - 1);
        for (int i = 0; i < tickets.size(); i++) {
            if (!flag[i] && tail.equals(tickets.get(i).get(0))){
                flag[i] = true;
                path.add(tickets.get(i).get(1));
                if (backTracking(tickets,flag,count+1,len)){  // 注意：count+1不能改成count++
                    return true;
                }
                path.remove(path.size()-1);
                flag[i] = false;
            }
        }
        return false;
    }

}
