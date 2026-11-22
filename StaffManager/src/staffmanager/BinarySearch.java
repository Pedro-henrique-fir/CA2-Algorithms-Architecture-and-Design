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
public class BinarySearch {
    
    
    public static int binarySearch(ArrayList<Employee> employees, int left, int right, String name) {


        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        int comparison = name.compareToIgnoreCase(employees.get(mid).getFullName());


        if (comparison == 0) {
            return mid;
            
        }


        if (comparison < 0) {
            return binarySearch(employees, left, mid - 1, name);
            
        }


        return binarySearch(employees, mid + 1, right, name);
    }

    
    
}
