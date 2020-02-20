package Menu.JDBCFiles;

import java.util.List;
import Menu.Beans.Product;

public interface ProductsDao{
    public void addProduct(Product p);
    public Product getProduct(String pid);
    public List getAllProducts();
}