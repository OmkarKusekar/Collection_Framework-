package main.java.List.ArrayList.Library;

import java.util.ArrayList;

public class LibraryManagement {
    public static void main(String[] args) {
        ArrayList<Book> library= new ArrayList<>();
        library.add(new Book("abc","wqw","1234"));
        library.add(new Book("mkm","lol","9090"));
        System.out.println("After adding books :" +library);

        //  Add a book at a specific position
        library.add(1,new Book("ewe","ere","8787"));
        System.out.println("After adding books at index 1 : " + library);

        // AddAll

        ArrayList<Book> newArrival = new ArrayList<>();
        newArrival.add(new Book("mmm","nnn","0000"));
        newArrival.add(new Book("sss","kkk","9999"));

        library.addAll(newArrival);
        System.out.println("After adding new Arrival : "+ library);

        // Add multiple books at a specific index

        ArrayList<Book> classic = new ArrayList<>();
        classic.add(new Book("ouy","poui","2132"));
        library.addAll(0,classic);
        System.out.println(library);

       // Remove a book by object

        Book removeBook = new Book("abc","wqw","1234");
        library.remove(removeBook);
        System.out.println("After removing abc book " + library);

        // Remove a book at a specific index

        library.remove(1);
        System.out.println("After removing index 1 "+ library);

        System.out.println(library.size());
        System.out.println(library.hashCode());


    }
}
