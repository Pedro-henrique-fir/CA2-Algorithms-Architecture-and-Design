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

        ArrayList<String> fileMessages = new ArrayList<>();

        ArrayList<Employee> loadedEmployees = EmployeeFileReader.readFile("SchoolEmployees.txt", fileMessages);

        EmployeeModel model = new EmployeeModel(loadedEmployees);

        for (String message : fileMessages) {
            StaffView.showMessage(message);
            
        }
        
            
        while(true){
            
            StaffView.showMenu();
            
            MenuOption option = MenuOption.findOption(myKB.nextLine().trim());

            if (option == null) {
                StaffView.showMessage("Invalid option. Try again.");
                continue;
            }
               
            switch (option) {

                case SORT:
                    
                    if (model.isEmpty()) {
                        StaffView.showMessage("No employees available.");
                        break;
                    }
                    
                    model.sortEmployees();

                    int limit = 20;

                    if (model.getEmployeeCount() < 20) {
                        limit = model.getEmployeeCount();
                        
                    }

                    StaffView.showSortedEmployees(model.getEmployees(), limit);

                    break;

                case SEARCH:
                    if (model.isEmpty()) {
                        StaffView.showMessage("No employees available.");
                        break;
                    }

                    String name = requiredField(myKB, "Enter employee full name: ");

                    Employee employee = model.searchEmployee(name);

                    if (employee == null) {
                        StaffView.showMessage("Employee not found.");
                        
                        
                    } else {
                        StaffView.showSearchResult(employee);
                        
                        
                    }

                    break;

                case ADD_RECORDS:
                    String firstName = requiredField(myKB, "\nFirst name: ");
                    String lastName = requiredField(myKB, "Last name: ");
                    
                    StaffView.showOptions("Departments:", departments);

                    
                    int departmentChoice = takeChoice(myKB, "\nChoose a department: ", departments.length);
                    String department = departments[departmentChoice - 1];
                    
                    
                    StaffView.showOptions("Manager Types:", managerTypes);
                    
                    int managerChoice = takeChoice(myKB, "\nChoose a manager type: ", managerTypes.length);
                    String managerType = managerTypes[managerChoice - 1];


                    String gender = requiredField(myKB, "Gender: ");

                    String email = checkEmail(myKB);

                    double salary = checkSalary(myKB);

                    String jobTitle = requiredField(myKB, "Job title: ");

                    
                    Employee newEmployee = new Employee(firstName, lastName, gender, email, salary, department, jobTitle, managerType);
                    
                    model.addEmployee(newEmployee);
                    StaffView.showEmployeeDetails(newEmployee);
                    
                    StaffView.showMessage(
                            "\nEmployee added successfully!");

                    StaffView.showMessage(
                            "Total employees: " + model.getEmployeeCount());

                    StaffView.showNewEmployees(
                            model.getNewEmployees());

                    break;

                case EXIT:
                    StaffView.showMessage("Exit");
                    return;

                default:
                    StaffView.showMessage("Invalid option");
                    
            }
        }
        
    }
    
    
    private static String requiredField(Scanner scanner, String message) {

        while (true) {
            StaffView.showPrompt(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            StaffView.showMessage("This can not be empty. Try again.");
        }
    }

    private static int takeChoice(Scanner scanner, String message, int max) {

        while (true) {
            StaffView.showPrompt(message);

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice >= 1 && choice <= max) {
                    return choice;
                }

                StaffView.showMessage("Choose a number between 1 and " + max + ".");

                
            } catch (NumberFormatException e) {
                StaffView.showMessage("Invalid. Enter a number.");
                
            }
        }
    }

    private static String checkEmail(Scanner scanner) {

        while (true) {
            StaffView.showPrompt("Email: ");
            String email = scanner.nextLine().trim();

            if (!email.isEmpty() && email.contains("@")) {
                return email;
            }

            StaffView.showMessage("Invalid email. Try again.");
        }
    }

    private static double checkSalary(Scanner scanner) {

        while (true) {
            StaffView.showPrompt("Annual salary: ");

            try {
                double salary = Double.parseDouble(scanner.nextLine().trim());

                if (salary > 0) {
                    return salary;
                }

                StaffView.showMessage("It must be a positive number");
                

            } catch (NumberFormatException e) {
                StaffView.showMessage("Invalid salary. Enter a number.");
                
            }
        }
    }

    
}
