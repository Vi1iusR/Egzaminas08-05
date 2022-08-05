//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import com.company.DAO.MenuDAO;
import com.company.DAO.UserDAO;
import com.company.Entity.Menu;
import com.company.Utils.HibernateUtil;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scan = new Scanner(System.in);
        System.out.println("What you would like to do?:\n1. For login.\n2. For register.\nPlease select a number for operation:");
        String loginOrReg = scan.next();
        if (loginOrReg.contains("1")) {
            System.out.println("Enter your username:");
            String logUsername = scan.next();
            System.out.println("Enter your password:");
            String logPassword = scan.next();
            if (userDAO.login(logUsername, logPassword)) {
                if (userDAO.getUserRole(logUsername).equals("user")) {
                    userFunc();
                } else {
                    adminFunc();
                }
            }
        } else if (loginOrReg.contains("2")) {
            System.out.println("Create your username:");
            String regUsername = scan.next();
            System.out.println("Create your password:");
            String regPassword = scan.next();
            userDAO.registration(regUsername, regPassword);
        }

        HibernateUtil.getSessionFactory().close();
    }

    public static void adminFunc() {
        while(true) {
            MenuDAO menuDAO = new MenuDAO();
            Scanner scan = new Scanner(System.in);
            int resetOrderCount = 0;
            System.out.println("Welcome! Which operation you would like to execute?\n1. For adding a new dish.\n2. For deleting a dish.\n3. For editing a dish.\n4. For approving orders.\n5. For log out.\nPlease enter the number of the option:");
            String chooseOpAdmin = scan.next();
            if (chooseOpAdmin.contains("1")) {
                System.out.println("Name of the dish?:");
                scan.nextLine();
                String addDish = scan.nextLine();
                System.out.println("Description of the dish?:");
                String descDish = scan.nextLine();
                System.out.println("Adding the dish!");
                Menu newDish = new Menu(addDish, descDish);
                menuDAO.addDish(newDish);
            } else if (chooseOpAdmin.contains("2")) {
                menuDAO.allDishesUser();
                System.out.println("\nOrdered dishes are not currently shown!\n");
                System.out.println("Enter the ID of the dish to delete:");
                int dishDelete = scan.nextInt();
                menuDAO.deleteDishByID(dishDelete);
            } else if (chooseOpAdmin.contains("3")) {
                menuDAO.allDishesUser();
                System.out.println("\nOrdered dishes are not currently shown!\n");
                System.out.println("Enter id of the dish to edit:\n");
                int dishUpdate = scan.nextInt();
                System.out.println("Enter new name of the dish:\n");
                scan.nextLine();
                String updateDish = scan.nextLine();
                System.out.println("Enter new description of the dish:\n");
                String updateDishDesc = scan.nextLine();
                menuDAO.editDish(dishUpdate, updateDish, updateDishDesc);
                System.out.println("Dish updated!");
            } else {
                if (!chooseOpAdmin.contains("4")) {
                    System.out.println("Logging out!");
                    return;
                }

                System.out.println("All orders:\n");
                menuDAO.allDishesAdmin();
                System.out.println("Write the id of the order you want to approve:\n");
                int approveOrder = scan.nextInt();
                menuDAO.approveOrder(approveOrder, resetOrderCount);
                System.out.println("Order approved!");
            }
        }
    }

    public static void userFunc() {
        while(true) {
            MenuDAO menuDAO = new MenuDAO();
            Scanner scan = new Scanner(System.in);
            System.out.println("\nPlease select the operation by number:\n1. For searching for dishes.\n2. For log out.\n");
            String chooseOpUser = scan.next();
            if (!chooseOpUser.equals("1")) {
                System.out.println("Logging out!");
                return;
            }

            menuDAO.allDishesUser();
            System.out.println("Write the id of the dish you want to order:");
            int pickDish = scan.nextInt();
            System.out.println("How many orders are you going to make?:");
            int orderCount = scan.nextInt();
            menuDAO.orderFood(pickDish, orderCount);
            System.out.println("Order complete!");
        }
    }
}
