package Level1;
import java.util.*;

public class Sale {
    private List<Product> products;
    private double total_price;

    public Sale(List<Product> products){
        this.products = products;
        this.total_price = 0;
    }

    public double getTotal() throws EmptySaleException{
        if(products.isEmpty()){
            throw new EmptySaleException("To make a sale you must first add products.");
        }else{
            for(Product product: products){
                total_price += product.getPrice();
            }
        }
        return total_price;
    }
}
