package main.java.List.ArrayList;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList <Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 5 ; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);

        arrayList.remove(3);

        System.out.println(arrayList);

        for(int j : arrayList){
            System.out.print(j + " ");
        }
    }
}
