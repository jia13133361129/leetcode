package weeklyCompetition;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最流行的视频创作者
 * Version:
 */
public class Ques2456 {
    @Test
    public void test(){

    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans = new ArrayList<>();
        // key：创作者，value：对应的view总和
        Map<String,Long> sum = new HashMap<>();
        // 流行度最高的创作者的数量
        Long maxSum = 0L;
        // key：创作者，value：最大的view
        Map<String,Integer> creatorMaxViews = new HashMap<>();
        // // key：创作者，value：最大view对应的id
        Map<String,String> creatorsMaxId = new HashMap<>();

        for (int i = 0; i < creators.length; i++) {
            // 赋值sum 和 maxSum
            sum.put(creators[i],sum.getOrDefault(creators[i], 0L) + views[i]);
            if (sum.get(creators[i]) > maxSum){
                maxSum = sum.get(creators[i]);
            }
            // 赋值creatorMaxViews 和 creatorsMaxId
            if (creatorMaxViews.containsKey(creators[i])){
                if (creatorMaxViews.get(creators[i]) < views[i]){
                    creatorMaxViews.put(creators[i],views[i]);
                    creatorsMaxId.put(creators[i],ids[i]);
                }else if (creatorMaxViews.get(creators[i]) == views[i]){
                    String s = creatorsMaxId.get(creators[i]);
                    if (s.compareTo(ids[i]) > 0){
                        creatorsMaxId.put(creators[i],ids[i]);
                    }
                }
            }else {
                creatorMaxViews.put(creators[i],views[i]);
                creatorsMaxId.put(creators[i],ids[i]);
            }

        }


        for (String key : sum.keySet()) {
            if (sum.get(key).equals(maxSum)){
                List<String> list = new ArrayList<>();
                list.add(key);
                list.add(creatorsMaxId.get(key));
                ans.add(list);
            }
        }
        return ans;
    }

}
