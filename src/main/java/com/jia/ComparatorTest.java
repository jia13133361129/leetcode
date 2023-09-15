package com.jia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest implements Comparable<ComparatorTest>{

    int num;
    @Override
    public int compareTo(ComparatorTest comparatorTest) {
        return this.num - comparatorTest.num;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Collections.sort(list, (o1, o2) -> {
            if (o1 > o2){
                return 1;
            }else {
                return -1;
            }
        });
    }
}
