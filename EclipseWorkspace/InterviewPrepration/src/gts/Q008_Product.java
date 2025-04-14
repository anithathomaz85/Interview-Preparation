package gts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List<Product> ls = Arrays.asList(new Product(1,""abc"",  "test"",100.00),
                                    new Product(2, ""Xyz"", "test1"", 10.00),
                                    new Product(3, ""Xyz"", "test3"", 50.00),
                                    new Product(4, ""Ntd"", "test1"", 60.00));
		
   1. find the productId price is greater than 55.00
   2. find the list of products that belong to category. 
      like retrun the Map<String,List<Product>>
 * 
 * */
class Product{
    int productId;
    String name;
    String category;
    double price;
    
	public Product(int productId, String name, String category, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ "]";
	}
	

    
}

public class Q008_Product {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
			    new Product(1, "laptop", "electronics", 100.00),
			    new Product(2, "phone", "electronics", 10.00),
			    new Product(3, "teddy bear", "toys", 50.00),
			    new Product(4, "supper man", "toys", 60.00)
			);
		
		//find the productId price is greater than 55.00
		List<Integer> productIds = products.stream()
										.filter(p->p.getPrice()>55.00)
										.map(Product::getProductId)
										.collect(Collectors.toList());
		System.out.println("Product IDs with price > 55: " + productIds);
		
		//find the list of products that belong to category.
		products.stream()
        		.collect(Collectors.groupingBy(Product::getCategory))
        		.forEach((category, productList) -> System.out.println(category + " => " + productList));
	}

}
