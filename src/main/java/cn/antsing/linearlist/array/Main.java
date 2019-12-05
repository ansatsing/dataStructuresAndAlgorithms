package cn.antsing.linearlist.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.addAll(Arrays.asList(1,2,3,4,5));
        //list.add(5,9);//不报错
        list.add(6,9);//java.lang.IndexOutOfBoundsException: Index: 6, Size: 5
        list.forEach(i ->System.out.print(i+"\t"));
        System.out.println();
    }
}
