package tera;
// import java.util.Map;
// import java.util.ArrayList;
// import java.util.Iterator;
import java.util.List;

import dao.AbstractDaoFactory;
import dao.ProductsDao;

public class OrderInsertCommand extends AbstractCommand{

    public ResponseContext execute(ResponseContext resc){
         // HttpSession session = req.getSession();
        // Product ub = (UserBean)session.getAttribute("ub");
        //�f�[�^�x�[�X�Ɍl���E�w���������̂�insert����

        AbstractDaoFactory factory=AbstractDaoFactory.getFactory("orderin");
        ProductsDao dao=factory.getProductsDao();

		Product pr=new Product();
		Map m=(Map)session.getAttribute("list");
		Set s=m.keySet();
        Iterator it=s.iterator();
		while(it.hasNext()){
            String key=(String)it.next();
            String v=(String)m.get(key);
        
            pr.meth(v,key);
            System.out.println("�L�["+key+"�l"+v);
        }

		
		dao.addProduct(pr);


        List products=dao.getAllProducts();

        resc.setResult(products);

        resc.setTarget("complete");

        return resc;








//---------------------------------------------------------------
       


    }
}