package Demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        //activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();//read configuration file
        //create communication link
        factory=cfg.buildSessionFactory();
        //start session
        ses=factory.openSession();
        //transaction is not required while DQL operation
        Product p1=  ses.load(Product.class,1);

        tx=ses.beginTransaction();
        ses.delete(p1);
        tx.commit();
        System.out.println("PRODUCT DELETED");
    }
}
