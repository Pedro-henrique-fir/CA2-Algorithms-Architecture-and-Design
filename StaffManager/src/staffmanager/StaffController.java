/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanager;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class StaffController {

    private final EmployeeModel model;
    private final Scanner myKB = new Scanner(System.in);

    public StaffController(EmployeeModel model) {
        this.model = model;
    }

    public void run() {

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

                    String name = requiredField("Enter employee full name: ");

                    Employee employee = model.searchEmployee(name);

                    if (employee == null) {
                        StaffView.showMessage("Employee not found.");


                    } else {
                        StaffView.showSearchResult(employee);


                    }

                    break;

                case ADD_RECORDS:
                    String firstName = requiredField("\nFirst name: ");
                    String lastName = requiredField("Last name: ");

                    String[] departments = model.getDepartments();
                    String[] managerTypes = model.getManagerTypes();

                    StaffView.showOptions("Departments:", departments);


                    int departmentChoice = takeChoice("\nChoose a department: ", departments.length);
                    String department = departments[departmentChoice - 1];


                    StaffView.showOptions("Manager Types:", managerTypes);

                    int managerChoice = takeChoice("\nChoose a manager type: ", managerTypes.length);
                    String managerType = managerTypes[managerChoice - 1];


                    String gender = requiredField("Gender: ");

                    String email = checkEmail();

                    double salary = checkSalary();

                    String jobTitle = requiredField("Job title: ");


                    Employee newEmployee = new Employee(firstName, lastName, gender, email, salary, department, jobTitle, managerType);

                    model.addEmployee(newEmployee);
                    StaffView.showEmployeeDetails(newEmployee);

                    StaffView.showMessage("\nEmployee added successfully!");

                    StaffView.showMessage("Total employees: " + model.getEmployeeCount());

                    StaffView.showNewEmployees(
                            model.getNewEmployees());

                    break;

                case BINARY_TREE:

                    EmployeeTree tree = model.buildEmployeeTree();

                    StaffView.showEmployeeTree(tree.levelOrderTraversal(), tree.getHeight(), tree.getNodeCount());

                    break;

                case EXIT:
                    StaffView.showMessage("Exit");
                    return;

                default:
                    StaffView.showMessage("Invalid option");

            }
        }

    }


    private String requiredField(String message) {

        while (true) {
            StaffView.showPrompt(message);
            String value = myKB.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            StaffView.showMessage("This can not be empty. Try again.");
        }
    }

    private int takeChoice(String message, int max) {

        while (true) {
            StaffView.showPrompt(message);

            try {
                int choice = Integer.parseInt(myKB.nextLine().trim());

                if (choice >= 1 && choice <= max) {
                    return choice;
                }

                StaffView.showMessage("Choose a number between 1 and " + max + ".");


            } catch (NumberFormatException e) {
                StaffView.showMessage("Invalid. Enter a number.");

            }
        }
    }

    private String checkEmail() {

        while (true) {
            StaffView.showPrompt("Email: ");
            String email = myKB.nextLine().trim();

            if (!email.isEmpty() && email.contains("@")) {
                return email;
            }

            StaffView.showMessage("Invalid email. Try again.");
        }
    }

    private double checkSalary() {

        while (true) {
            StaffView.showPrompt("Annual salary: ");

            try {
                double salary = Double.parseDouble(myKB.nextLine().trim());

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
