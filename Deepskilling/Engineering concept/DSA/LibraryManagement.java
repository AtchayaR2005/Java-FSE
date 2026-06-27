package DSA;

public class LibraryManagement {

    public static void main(String args[]) {

        String books[]={"Java","Python","C++","HTML"};

        String search="Python";

        for(String b:books){

            if(b.equals(search)){

                System.out.println("Book Found");

            }

        }

    }

}
