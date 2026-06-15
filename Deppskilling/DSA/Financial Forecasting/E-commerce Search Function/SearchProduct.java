public class SearchProduct {
    public static void main(String[] args) {
        String[] products = {
                "Laptop",
                "Mobile",
                "Tablet",
                "Headphone"
        };
        String searchItem = "Mobile";
        boolean found = false;
        for(String product : products) {
            if(product.equalsIgnoreCase(searchItem)) {
                found = true;
                break;
            }
        }
        if(found) {
            System.out.println("Product Found");
        }
        else {
            System.out.println("Product Not Found");
        }
    }
}