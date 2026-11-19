/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author mac
 */
public class EmployeeFileReader {
 
    
    
    public static void main(String[] args) {

        ArrayList<Employee> employees = readFile("SchoolEmployees.txt");

        System.out.println("Total: " + employees.size());

        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    
    public static ArrayList<Employee> readFile(String fileName) {
        
        ArrayList<Employee> employees = new ArrayList<>();

        File file = new File(fileName);

        try (Scanner fileReader = new Scanner(file)) {

            
            while (fileReader.hasNextLine()) {
                
                String line = fileReader.nextLine();
                
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                
                String[] data = line.split(",", -1);
                
                if (data.length != 8) {
                    System.out.println("Invalid record: " + line);
                    continue;
                }
                
                if (data[0].trim().equalsIgnoreCase("firstName") && data[1].trim().equalsIgnoreCase("lastName")) {
                    continue;
                    
                }

                String firstName = data[0].trim();
                String lastName = data[1].trim();
                String gender = data[2].trim();
                double salary = Double.parseDouble(data[4].trim());
                String email = data[3].trim();
                String department = data[5].trim();
                String jobTitle = data[6].trim();
                String managerType = data[7].trim();

                Employee employee = new Employee(firstName, lastName, gender, email, salary, department, jobTitle, managerType);

                employees.add(employee);
                 

             
                
            }

            
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            
            
        }
        
        return employees;
    }

    
}
