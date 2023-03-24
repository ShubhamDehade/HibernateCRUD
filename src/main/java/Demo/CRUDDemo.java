package Demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class CRUDDemo {
    public static void main(String[] args) {
        Configuration con;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        con=new Configuration();
        con=con.configure();
        factory= con.buildSessionFactory();
        ses= factory.openSession();
        Scanner sc1=new Scanner(System.in);
        System.out.println("1.ADD PRODUCT\t2.UPDATE PRODUCT\t3.DELETE PRODUCT\t4.DISPLAY PRODUCT");
        int choice=sc1.nextInt();
        Product p1=new Product();
        if(choice==1){
            System.out.println("ENTER ID,NAME,CATEGORY,PRICE");
            int id= sc1.nextInt();
            String name= sc1.next();
            String category=sc1.next();
            double price=sc1.nextDouble();
            p1.setProductId(id);
            p1.setProductName(name);
            p1.setProductCategory(category);
            p1.setProductPrice(price);
            tx=ses.beginTransaction();
            ses.save(p1);
            tx.commit();
            System.out.println("PRODUCT ADDED");
        } else if (choice==2) {
            System.out.println("ENTER PRODUCT ID");
             int id=sc1.nextInt();
             p1=ses.load(Product.class,id);
            System.out.println("WHAT YOU WANT TO UPDATE ?\n1.NAME 2.CATEGORY 3.PRICE");
            int option= sc1.nextInt();
            switch (option){
                case 1:
                    System.out.println("ENTER NEW NAME");
                    String name=sc1.next();
                    p1.setProductName(name);
                    ses.update(p1);
                    break;
                case 2:System.out.println("ENTER NEW CATEGORY");
                    String category=sc1.next();
                    p1.setProductCategory(category);
                    ses.update(p1);
                    break;
                case 3:System.out.println("ENTER NEW PRICE");
                   double price=sc1.nextDouble();
                    p1.setProductPrice(price);
                    ses.update(p1);
                    break;
            }
            tx=ses.beginTransaction();
            ses.update(p1);
            tx.commit();
            System.out.println("PRODUCT UPDATED");
        } else if (choice==3) {
            System.out.println("ENTER ID");
            int id= sc1.nextInt();
            p1=ses.load(Product.class,id);
            tx= ses.beginTransaction();
            ses.delete(p1);
            tx.commit();
            System.out.println("PRODUCT DELETED");
        } else if (choice==4) {
            System.out.println("ENTER ID");
            int id= sc1.nextInt();
            p1=ses.load(Product.class,id);
            System.out.println("ID\tNAME\tCATEGORY\tPRICE");
            System.out.println(p1.getProductId()+"\t"+p1.getProductName()+"\t"+p1.getProductCategory()+"\t"+p1.getProductPrice());

        }
    }
}
