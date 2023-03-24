package Demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DynamicValues {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        //activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();
        //establish communication link
        factory=cfg.buildSessionFactory();
        //start session
        ses= factory.openSession();
        //accept values from user
        Scanner sc1=new Scanner(System.in);
        System.out.println("ENTER ID, PRODUCT NAME,CATEGORY, PRICE RESPECTIVELY");
        int id=sc1.nextInt();
        String name=sc1.next();
        String category=sc1.next();
        double price=sc1.nextDouble();
        Product p2=new Product();
        p2.setProductId(id);
        p2.setProductName(name);
        p2.setProductCategory(category);
        p2.setProductPrice(price);
        //start transaction
        tx= ses.beginTransaction();
        ses.save(p2);
        tx.commit();
        System.out.println("1 RECORD INSERTED");


    }
}
