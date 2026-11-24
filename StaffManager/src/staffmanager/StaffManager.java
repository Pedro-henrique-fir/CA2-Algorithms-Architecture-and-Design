/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package staffmanager;

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

        ArrayList<String> fileMessages = new ArrayList<>();

        ArrayList<Employee> employees = EmployeeFileReader.readFile("schoolEmployees.txt", fileMessages);

        for (String message : fileMessages) {
            StaffView.showMessage(message);

        }

        EmployeeModel model = new EmployeeModel(employees);
        StaffController controller = new StaffController(model);

        controller.run();

    }

}
