package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 除法求值
 * 用到了图
 * Version:
 */
public class LeetCode399 {
    @Test
    public void test(){

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<Double> valuesList = new ArrayList<>();
        for (double value : values) {
            valuesList.add(value);
        }
        int size = equations.size();
        for(int i=0;i<size;i++){
            List<String> equation = equations.get(i);
            if(!equation.get(0).equals(equation.get(1))){
                List<String> temp = new ArrayList<>();
                temp.add(equation.get(1));
                temp.add(equation.get(0));
                equations.add(temp);
                valuesList.add(1/values[i]);
            }
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = calc(equations,valuesList,queries.get(i));
        }
        return ans;
    }

    public double calc(List<List<String>> equations, List<Double> values,List<String> target){
        if(!exist(equations,target)){
            return -1;
        }

        for(int i=0;i<equations.size();i++){
            List<String> equation = equations.get(i);
            if(equation.get(0).equals(target.get(0))){
                if(equation.get(1).equals(target.get(1))){
                    return values.get(i);
                }else {
                    List<String> temp = new ArrayList<>();
                    temp.add(equation.get(1));
                    temp.add(target.get(1));
                    if(exist(equations,temp)){
                        return values.get(i) * calc(equations,values,temp);
                    }
                }
            }
        }
        return -1;

    }


    // 出现环的话无法判断
    public boolean exist(List<List<String>> equations,List<String> target){
        for(List<String> equation:equations){
            if(equation.get(0).equals(target.get(0))){
                if(equation.get(1).equals(target.get(1))){
                    return true;
                }else {
                    List<String> temp = new ArrayList<>();
                    temp.add(equation.get(1));
                    temp.add(target.get(1));
                    if (exist(equations,temp)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
