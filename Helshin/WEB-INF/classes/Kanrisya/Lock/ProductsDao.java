package Kanrisya.Lock;
import java.util.List;

public interface ProductsDao{
	//�e���\�b�h���I�[�o�[���C�h����B
	public void addProduct(Product p);
	public List getProduct(String pid);
	public List getAllProducts();
}
