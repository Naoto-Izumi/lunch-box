package Kanrisya;
import java.util.List;
//import tera.Product;

public interface ProductsDao{
	public void addProduct(Product p);
	public List getProduct(String pid);
	public List getAllProducts();
}
