/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package staffmanager;

import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author mac
 */
public class StaffManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean isEmployeeSorted = false;
        
        Scanner myKB = new Scanner(System.in);
        
        ArrayList<Employee> employees = EmployeeFileReader.readFile("SchoolEmployees.txt");
        System.out.println(employees.size());
        
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
                    
                    if (employees.isEmpty()) {
                        System.out.println("No employees available.");
                        break;
                    }

                    MergeSort.mergeSort(employees, 0, employees.size() - 1);
                    isEmployeeSorted = true;

                    System.out.println("\nEmployees Sorted:");

                    int limit = 20;
                    
                    if (employees.size() < 20) {
                         limit = employees.size();
                        
                    }

                    for (int i = 0; i < limit; i++) {
                        System.out.println((i + 1) + " - " + employees.get(i).getFullName());
                    }

                    break;

                case "2":
                    if (employees.isEmpty()) {
                        System.out.println("No employees");
                        break;
                        
                    }

                    System.out.print("Enter employee full name: ");
                    String name = myKB.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    if(!isEmployeeSorted){
                        MergeSort.mergeSort(employees, 0, employees.size() - 1);
                        
                    }

                    
                    int index = BinarySearch.binarySearch(employees, 0, employees.size() - 1, name);

                    if (index == -1) {
                        System.out.println("Employee not found.");
                        
                    } else {

                        Employee employee = employees.get(index);

                        System.out.println("\nEmployee found!");
                        System.out.println("Name: " + employee.getFullName());
                        System.out.println("Department: " + employee.getDepartment());
                        System.out.println("Manager Type: " + employee.getManagerType());
                    }

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
