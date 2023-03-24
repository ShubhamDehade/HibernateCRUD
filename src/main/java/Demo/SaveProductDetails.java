package Demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProductDetails {
    public static void main(String[] args) {
        //declare objects
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        //step 1-->activate hibernate framework
       cfg=new Configuration();
       cfg=cfg.configure();//reads data from cfg file
        //step2-->establish communication link
        factory =cfg.buildSessionFactory();
        //step 3--.start session
         ses= factory.openSession();
         //step 4--->create object of domain class
        Product p1=new Product();
        p1.setProductId(1);
        p1.setProductName("MOBILE");
        p1.setProductCategory("ELECTRONICS");
        p1.setProductPrice(20000.578);
        //step 5-->start transaction
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("PRODUCT INSERTED SUCCESSFULLY");
    }
}
