package Kanrisya.Lock;
import java.util.List;

public interface ProductsDao{
	//各メソッドをオーバーライドする。
	public void addProduct(Product p);
	public List getProduct(String pid);
	public List getAllProducts();
}
