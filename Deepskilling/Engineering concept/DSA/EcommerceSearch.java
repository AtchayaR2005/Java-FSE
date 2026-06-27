package DSA;

class Product{

    int id;
    String name;

    Product(int id,String name){
        this.id=id;
        this.name=name;
    }
}

public class EcommerceSearch {

    public static void main(String args[]) {

        Product p[]={
                new Product(1,"Laptop"),
                new Product(2,"Mouse"),
                new Product(3,"Keyboard")
        };

        String search="Mouse";

        for(Product x:p){
            if(x.name.equals(search)){
                System.out.println("Found : "+x.name);
            }
        }

    }

}