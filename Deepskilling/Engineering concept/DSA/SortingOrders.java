package DSA;
public class SortingOrders {


    public static void main(String args[]) {

        int order[]={5000,2000,9000,3000};

        for(int i=0;i<order.length-1;i++){

            for(int j=0;j<order.length-i-1;j++){

                if(order[j]>order[j+1]){

                    int temp=order[j];
                    order[j]=order[j+1];
                    order[j+1]=temp;

                }

            }

        }

        for(int x:order)
            System.out.println(x);

    }

}