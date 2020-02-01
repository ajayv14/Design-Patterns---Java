
//credits: Telusko : https://www.youtube.com/watch?v=nZ76x13Nm8Q
//credits 2 : https://www.journaldev.com/1440/prototype-design-pattern-in-java    
import java.util.ArrayList;
import java.util.List;

/*prototype pattern is used to clone an object when necessary to avoid overhead in re-creating the object each time*/

/*Product class which implements cloneable interface to offer the Product object to be cloned*/
class Product implements Cloneable {
	
	List<String> products;
	
	public Product() {
		this.products = new ArrayList<>();
	}
	
	/*This constructor is required to return the cloned object in the @override clone method, as the clone cannot return a list, but a cloned object of Product class*/
	public Product(List<String> products) {
			this.products = products;		
	}
	
	/*Assume loadData() to represent a database returning a list of products*/
	public List<String> loadData() {

		products.add("Shoe");
		products.add("T-Shirt");
		products.add("AirPods");
		products.add("Phones");

		return products;
	}

	public List<String> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "products = [" + products + "]";
	}
	
	/*Please Read the comments below*/
	/*Please Read the comments below*/
	
	/*an autogenerated clone method, which is actually a shallow copy, meaning it does not clone product object into new object, but just returns a reference to the object*/
	/*try running this uncommented and comment out the other clone() method to know the difference*/
	
	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}*/	
	
	
	
	
	/*We are overriding the clone() method from Cloneable interface to allow creating a deep copy of cloned Product class object*/
	@Override
	public Product clone() {
		
		List<String> productClone = new ArrayList<>();
		
		for(String s : products) {
			productClone.add(s);	
		}
		
		return  new Product(productClone);		
	}
	

}

/* main class to demonstrate prototype pattern */
public class PrototypePattern {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		Product product1 = new Product();
		product1.loadData();
		
		/*use the overridden clone() method to clone the existing Product class object*/
		Product product2 = (Product) product1.clone();
		
		List<String> l1 = product2.getProducts();
		l1.add("Jeans");
		
		
		System.out.println(product1);		
		System.out.println(product2); // you can observe how the change in this object does not reflect in the product1 object, hence validating the deep copy
		

	}

}
