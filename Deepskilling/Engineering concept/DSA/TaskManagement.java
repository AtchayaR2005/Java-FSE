package DSA;

import java.util.LinkedList;

public class TaskManagement {

    public static void main(String args[]) {

        LinkedList<String> task=new LinkedList<>();

        task.add("Coding");
        task.add("Testing");
        task.add("Deployment");

        task.remove("Testing");

        for(String t:task){

            System.out.println(t);

        }

    }

}
