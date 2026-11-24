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
    

    public static void mergeSort(ArrayList<Employee> employees, int left, int right, boolean sortByManager){

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(employees, left, mid, sortByManager);
            mergeSort(employees, mid + 1, right, sortByManager);

            merge(employees, left, mid, right, sortByManager);
        }
    }


    private static int compareEmployees(Employee a, Employee b, boolean sortByManager) {

        if (sortByManager) {
            return b.getManagerRank() - a.getManagerRank();
        }

        return a.getFullName().compareToIgnoreCase(b.getFullName());
    }


    public static void merge(ArrayList<Employee> employees, int left, int mid, int right, boolean sortByManager){

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

            if (compareEmployees(L.get(i), R.get(j), sortByManager) <= 0) {

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
