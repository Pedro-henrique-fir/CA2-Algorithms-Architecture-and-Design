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
public class MergeSort {
    

    public static void mergeSort(ArrayList<Employee> employees, int left, int right){

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(employees, left, mid);
            mergeSort(employees, mid + 1, right);
            
            merge(employees, left, mid, right);
        }
    }
    
    
    public static void merge(ArrayList<Employee> employees, int left, int mid, int right){

        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<Employee> L = new ArrayList<>();
        ArrayList<Employee> R = new ArrayList<>();

        
        for (int i = 0; i < n1; i++) {
            L.add(employees.get(left + i));
        }

        for (int j = 0; j < n2; j++) {
            R.add(employees.get(mid + 1 + j));
        }

        int i = 0;
        int j = 0;
        int k = left;

        
        while (i < n1 && j < n2) {

            if (L.get(i).getFullName().compareToIgnoreCase(
                    R.get(j).getFullName()) <= 0) {

                employees.set(k, L.get(i));
                i++;

            } else {

                employees.set(k, R.get(j));
                j++;
            }

            k++;
        }

       
        while (i < n1) {
            employees.set(k, L.get(i));
            i++;
            k++;
        }

        
        while (j < n2) {
            employees.set(k, R.get(j));
            j++;
            k++;
        }
    }

    
}
