package Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Collections.emptyList());
        Sale sale1 = new Sale(products);
        try{
            System.out.println(sale1.getTotal());
        }catch (EmptySaleException e){
            System.out.println(e.getMessage());
        }
        products.add(new Product("Jeans",70.1));
        products.add(new Product("Shirt",25.5));
        products.add(new Product("Hat",50.3));
        Sale sale2 = new Sale(products);
        try{
            System.out.println(sale2.getTotal());
        }catch (EmptySaleException e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println(products.get(4));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
