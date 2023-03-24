package Demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DisplayProduct {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        //activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();//read configuration file
       //create communication link
        factory=cfg.buildSessionFactory();
        //start session
        ses=factory.openSession();
        //transaction is not required while DQL operation
      Product p1=  ses.load(Product.class,1);
        System.out.println(p1.getProductId());
        System.out.println(p1.getProductName());
        System.out.println(p1.getProductCategory());
        System.out.println(p1.getProductPrice());

    }
}
