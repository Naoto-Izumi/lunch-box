package tera;
// import java.util.Map;
// import java.util.ArrayList;
// import java.util.Iterator;
import java.util.List;

import dao.AbstractDaoFactory;
import dao.ProductsDao;

public class GetProductsCommand extends AbstractCommand{

    public ResponseContext execute(ResponseContext resc){
        AbstractDaoFactory factory=AbstractDaoFactory.getFactory("menu");
        ProductsDao dao=factory.getProductsDao();

        List products=dao.getAllProducts();

        resc.setResult(products);

        resc.setTarget("view");

        return resc;
    }
}