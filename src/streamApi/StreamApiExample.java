package streamApi;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample {
    public static void main(String[] args) {
        //Stream api has been added to use filter/map/reduce/collect like operations with the collection.
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"Computer",14500));
        products.add(new Product(2,"Phone",1400));
        products.add(new Product(3,"Glasses",100));
        products.add(new Product(4,"Mouse",500));
        products.add(new Product(5,"Keyboard",400));
        products.add(new Product(6,"Monitor",1500));
        products.add(new Product(7,"Slippers",45));

        //In Map, you can iterate your collection and return them or their attributes to a new collection.
        List<Long> productPrices = products.stream().map(product -> {
            return product.getPrice();
        }).collect(Collectors.toList());
        System.out.println(productPrices);

        //You can use .filter() to filter your collection.
        //Also, you can use these functions together.
        List<String> expensiveProducts = products.stream().filter(product -> product.getPrice()>1200).map(product -> product.getName()).collect(Collectors.toList());
        System.out.println(expensiveProducts);

        //You can use .forEach() to iterate your collections.
        products.stream().forEach(product -> {
            System.out.println("Name: " +product.getName()+ "\nPrice: "+product.getPrice());
        });
    }
}
