/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author mac
 */
public class EmployeeFileReader {
 
    
    
    public static void main(String[] args) {
        readFile("SchoolEmployees.txt");
        
    }

    
    public static void readFile(String fileName) {

        File file = new File(fileName);

        try (Scanner fileReader = new Scanner(file)) {

            
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
                
            }

            
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            
            
        }
    }

    
}
