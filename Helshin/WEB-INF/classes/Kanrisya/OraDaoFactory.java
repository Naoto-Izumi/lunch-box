package Kanrisya;

public class OraDaoFactory extends AbstractDaoFactory{
	public ProductsDao getProductsDao(){
		return new OraProductsDao();
	}
}
