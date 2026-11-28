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
public class EmployeeModel {
    
    private final ArrayList<Employee> employees;
    private final ArrayList<Employee> newEmployees;

    private boolean isEmployeeSorted;

    private final String[] departments = {
        "Mathematics",
        "English",
        "Science",
        "Humanities",
        "IT",
        "Finance",
        "Administration",
        "Student Services"
    };

    private final String[] managerTypes = {
        "Non-Manager",
        "Head of Department",
        "Deputy Principal",
        "Principal"
    };

    public EmployeeModel() {

        this.employees = new ArrayList<>();
        this.newEmployees = new ArrayList<>();
        this.isEmployeeSorted = false;
    }

    public boolean loadEmployees(String fileName, ArrayList<String> messages) {

        ArrayList<Employee> loadedEmployees = EmployeeFileReader.readFile(fileName, messages);

        if (loadedEmployees.isEmpty()) {
            return false;
        }

        employees.addAll(loadedEmployees);
        isEmployeeSorted = false;

        return true;
    }

    public boolean isEmpty() {
        return employees.isEmpty();
        
    }

    public int getEmployeeCount() {
        return employees.size();
        
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
        
    }

    public ArrayList<Employee> getNewEmployees() {
        return new ArrayList<>(newEmployees);

    }

    public String[] getDepartments() {
        return departments;

    }

    public String[] getManagerTypes() {
        return managerTypes;

    }

    public void sortEmployees() {
        MergeSort.mergeSort(employees, 0, employees.size() - 1, false);
        isEmployeeSorted = true;
        
    }

    public Employee searchEmployee(String name) {
        if (!isEmployeeSorted) {
            sortEmployees();
        }

        int index = BinarySearch.binarySearch(employees, 0, employees.size() - 1, name);
        
        if (index == -1) {
            return null;
        }

        return employees.get(index);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        newEmployees.add(employee);
        isEmployeeSorted = false;

    }


    public EmployeeTree buildEmployeeTree() {

        ArrayList<Employee> treeEmployees = new ArrayList<>(employees);
        
        if(!isEmployeeSorted){
            MergeSort.mergeSort(treeEmployees, 0, treeEmployees.size() - 1, false);
            
        }
        
        MergeSort.mergeSort(treeEmployees, 0, treeEmployees.size() - 1, true);

        EmployeeTree tree = new EmployeeTree();

        for (Employee employee : treeEmployees) {
            tree.insert(employee);
        }

        return tree;
    }
}

