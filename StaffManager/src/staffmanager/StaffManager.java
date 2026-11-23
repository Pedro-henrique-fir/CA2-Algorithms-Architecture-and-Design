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
        
        String[] departments = {
            "Mathematics",
            "English",
            "Science",
            "Humanities",
            "IT",
            "Finance",
            "Administration",
            "Student Services"
        };

        String[] managerTypes = {
            "Non-Manager",
            "Head of Department",
            "Deputy Principal",
            "Principal"
        };
        
        Scanner myKB = new Scanner(System.in);
        
        ArrayList<Employee> employees = EmployeeFileReader.readFile("SchoolEmployees.txt");
        System.out.println(employees.size());
        
        while(true){
            
            System.out.println("\n===== SCHOOL EMPLOYEE MANAGEMENT =====");
            
            for (MenuOption menu : MenuOption.values()) {
                System.out.println(
                        menu.getNumber() + ". " + menu.getDescription());
            }
            
            System.out.print("Choose an option: ");      
            
            MenuOption option = MenuOption.findOption(myKB.nextLine().trim());
            
            if (option == null) {
                System.out.println("Invalid option");
                continue;
                
            }

               
            switch (option) {

                case SORT:
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

                case SEARCH:
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

                        System.out.println("\nEmployee found");
                        System.out.println("Name: " + employee.getFullName());
                        System.out.println("Department: " + employee.getDepartment());
                        System.out.println("Manager Type: " + employee.getManagerType());
                    }

                    break;

                case ADD_RECORDS:
                    String firstName = requiredField(myKB, "\nFirst name: ");
                    String lastName = requiredField(myKB, "Last name: ");
                    
                    System.out.println("\nDepartments:");

                    for (int i = 0; i < departments.length; i++) {
                        System.out.println((i + 1) + " - " + departments[i]);
                        
                    }

                    
                    int departmentChoice = takeChoice(myKB, "\nChoose a department: ", departments.length);
                    String department = departments[departmentChoice - 1];
                    
                    
                    System.out.println("\nManager Types:");

                    for (int i = 0; i < managerTypes.length; i++) {
                        System.out.println((i + 1) + " - " + managerTypes[i]);
                        
                        
                    }
                    
                    int managerChoice = takeChoice(myKB, "\nChoose a manager type: ", managerTypes.length);
                    String managerType = managerTypes[managerChoice - 1];


                    String gender = requiredField(myKB, "Gender: ");

                    String email = checkEmail(myKB);

                    double salary = checkSalary(myKB);

                    String jobTitle = requiredField(myKB, "Job title: ");

                    
                    Employee newEmployee = new Employee(firstName, lastName, gender, email, salary, department, jobTitle, managerType);
                    
                    employees.add(newEmployee);
                    isEmployeeSorted = false;


                    System.out.println("\nEMPLOYEE DETAILS:");
                    System.out.println("Name: " + newEmployee.getFullName());
                    System.out.println("Gender: " + gender);
                    System.out.println("Email: " + email);
                    System.out.println("Salary: " + salary);
                    System.out.println("Department: " + department);
                    System.out.println("Job Title: " + jobTitle);
                    System.out.println("Manager Type: " + managerType);

                    System.out.println("\nEmployee added successfully!");

                    break;

                case EXIT:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid option");
                    
            }
        }
        
    }
    
    
    private static String requiredField(Scanner scanner, String message) {

        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This can not be empty. Try again.");
        }
    }

    private static int takeChoice(Scanner scanner, String message, int max) {

        while (true) {
            System.out.print(message);

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice >= 1 && choice <= max) {
                    return choice;
                }

                System.out.println("Choose a number between 1 and " + max + ".");

                
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Enter a number.");
                
            }
        }
    }

    private static String checkEmail(Scanner scanner) {

        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();

            if (!email.isEmpty() && email.contains("@")) {
                return email;
            }

            System.out.println("Invalid email. Try again.");
        }
    }

    private static double checkSalary(Scanner scanner) {

        while (true) {
            System.out.print("Annual salary: ");

            try {
                double salary = Double.parseDouble(scanner.nextLine().trim());

                if (salary > 0) {
                    return salary;
                }

                System.out.println("It must be a positive number");
                

            } catch (NumberFormatException e) {
                System.out.println("Invalid salary. Enter a number.");
                
            }
        }
    }

    
}
