//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company.DAO;

import com.company.Entity.Menu;
import com.company.Utils.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

public class MenuDAO {
    public MenuDAO() {
    }

    public void addDish(Menu menu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(menu);
        session.getTransaction().commit();
        System.out.println("Dish added!");
    }

    public void editDish(int id, String name, String desc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = (Menu)session.get(Menu.class, id);
        menu.setDishName(name);
        menu.setDishDesc(desc);
        System.out.println(menu);
        session.update(menu);
        session.getTransaction().commit();
    }

    public void deleteDishByID(int dishId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = (Menu)session.get(Menu.class, dishId);
        session.delete(menu);
        System.out.println("Dish deleted by ID.");
        session.getTransaction().commit();
    }

    public void allDishesAdmin() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Menu> menu = session.createQuery("select  a from Menu a where bought = 1").getResultList();
        System.out.println("All ordered dishes\n");
        Iterator var3 = menu.iterator();

        while(var3.hasNext()) {
            Menu list = (Menu)var3.next();
            System.out.println(list);
        }

        session.getTransaction().commit();
    }

    public void approveOrder(int id, int orderCount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = (Menu)session.get(Menu.class, id);
        menu.setBought(false);
        menu.setOrderCount(orderCount);
        session.update(menu);
        session.getTransaction().commit();
    }

    public void allDishesUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Menu> menu = session.createQuery("select a from Menu a where bought = 0").getResultList();
        System.out.println("All dishes on the menu:\n");
        Iterator var3 = menu.iterator();

        while(var3.hasNext()) {
            Menu list = (Menu)var3.next();
            System.out.println(list);
        }

        session.getTransaction().commit();
    }

    public void orderFood(int id, int orderCount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = (Menu)session.get(Menu.class, id);
        menu.setOrderCount(orderCount);
        menu.setBought(true);
        session.update(menu);
        session.getTransaction().commit();
    }
}
