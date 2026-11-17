/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package staffmanager;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class StaffManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myKB = new Scanner(System.in);
        
        while(true){
            
            System.out.println("\n===== SCHOOL EMPLOYEE MANAGEMENT =====");
            
            System.out.println("1. Sort Employees");
            System.out.println("2. Search Employee");
            System.out.println("3. Add Employee");
            System.out.println("4. Exit");
            
            System.out.print("Choose an option: ");      
            String option = myKB.nextLine().trim();
               
            switch (option) {

                case "1":
                    System.out.println("Sort");
                    break;

                case "2":
                    System.out.println("Search");
                    break;

                case "3":
                    System.out.println("Add Employee");
                    break;

                case "4":
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid option!");
                    
            }
        }
        
    }
    
}
