package main.java.List.ArrayList;

import java.util.ArrayList;

public class FruitList {
    public static void main(String []args){
        ArrayList<String> Fruits=new ArrayList<>();
        Fruits.add("Mango");
        Fruits.add("Orange");
        Fruits.add("Grapes");
        Fruits.add("Banana");
        System.out.println("Fruits in the List: ");
        for(String fruit:Fruits){
            System.out.println(fruit);
        }

        ArrayList<String> newFruits = new ArrayList<>();
        newFruits.add("Chickoo");
        newFruits.add("Papaya");

        Fruits.addAll(1,newFruits);
        System.out.println(Fruits);

        //System.out.println(Fruits);

//        Fruits.remove("Banana");
//        Fruits.remove(0);
//
//        System.out.println(Fruits);


    }


}
