package tera;

// import java.util.Map;

import dao.AbstractDaoFactory;
import dao.ProductsDao;

public class AddProductCommand extends AbstractCommand{

    // public String execute(){

    //     Product pr=new Product();

    //     Map data=getParameters();

    //     String[] a=(String[])data.get("name");
    //     String[] b=(String[])data.get("price");


    //     pr.setName(a[0]);
    //     pr.setPrice(b[0]);
    //     System.out.println(a[0]);
    //     System.out.println(b[0]);



    //     DbDummy.addProduct(pr);



    //     return "/WEB-INF/jsp/start.jsp";

    // }

    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc=getRequestContext();

        String[] pids=reqc.getParameter("pid");
        String pid=pids[0];

        String[] names=reqc.getParameter("name");
        String name=names[0];

        String[] prices=reqc.getParameter("price");
        String price=prices[0];

        Product p=new Product();

        p.setPid(pid);
        p.setName(name);
        p.setPrice(price);

        AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
        ProductsDao dao=factory.getProductsDao();
        dao.addProduct(p);

        resc.setTarget("start");

        return resc;
    }

    
}





















/*import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import tera.DbDummy;


public class AddProductCommand extends HttpServlet{
    private DbDummy db=new DbDummy();

    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        req.setCharacterEncoding("Windows-31J");

        String name=req.getParameter("name");
        String price=req.getParameter("price");

        db.addProduct(name);

        HttpSession session=req.getSession();
        session.setAttribute("db",db);

        RequestDispatcher dispatcher=req.getRequestDispatcher("/start.jsp");

        dispatcher.forward(req,res);


    }
}*/

