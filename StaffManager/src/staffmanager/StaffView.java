/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanager;

import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class StaffView {

    
    public static void showMenu() {
    
        System.out.println("\n===== SCHOOL EMPLOYEE MANAGEMENT =====");

        for (MenuOption option : MenuOption.values()) {
            System.out.println(
                    option.getNumber() + ". " + option.getDescription());
        }

        showPrompt("Choose an option: ");
    }

    public static void showPrompt(String message) {
        System.out.print(message);
        
    }

    public static void showMessage(String message) {
        System.out.println(message);
        
    }

    public static void showOptions(String title, String[] options) {
        System.out.println("\n" + title);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
            
        }
    }

    public static void showSortedEmployees(ArrayList<Employee> employees, int limit) {
        System.out.println("\nEmployees Sorted:");

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + " - " + employees.get(i).getFullName());
            
        }
        
    }

    public static void showSearchResult(Employee employee) {
        System.out.println("\nEmployee found");
        System.out.println("Name: " + employee.getFullName());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Manager Type: " + employee.getManagerType());
        
    }

    public static void showEmployeeDetails(Employee employee) {

        System.out.println("\nEMPLOYEE DETAILS:\n");

        System.out.println("    - Name: " + employee.getFullName());
        System.out.println("    - Gender: " + employee.getGender());
        System.out.println("    - Email: " + employee.getEmail());
        System.out.println("    - Salary: " + employee.getSalary());
        System.out.println("    - Department: " + employee.getDepartment());
        System.out.println("    - Job Title: " + employee.getJobTitle());
        System.out.println("    - Manager Type: " + employee.getManagerType());
    }

    public static void showNewEmployees(ArrayList<Employee> newEmployees) {

        System.out.println("\n=-=-=-= NEW EMPLOYEES =-=-=-=");

        for (int i = 0; i < newEmployees.size(); i++) {

            Employee employee = newEmployees.get(i);

            System.out.println((i + 1) + " - " + employee.getFullName());
            System.out.println("    - Department: " + employee.getDepartment());
            System.out.println("    - Manager Type: " + employee.getManagerType());
        }
    }

    public static void showEmployeeTree(ArrayList<ArrayList<Employee>> levels, int height, int nodeCount) {

        System.out.println("\n=-=-=-= EMPLOYEE HIERARCHY (LEVEL ORDER) =-=-=-=");

        for (int i = 0; i < levels.size(); i++) {

            System.out.println("\nLevel " + i + ":");

            ArrayList<Employee> level = levels.get(i);

            for (int j = 0; j < level.size(); j++) {

                Employee employee = level.get(j);

                System.out.println("    " + employee.getFullName() + " | " + employee.getManagerType() + " | " + employee.getDepartment());
            }
        }

        System.out.println("\nTree height: " + height);
        System.out.println("Total nodes: " + nodeCount);
    }
}

