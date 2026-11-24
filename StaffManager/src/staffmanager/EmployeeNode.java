/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanager;

/**
 *
 * @author mac
 */
public class EmployeeNode {

    private Employee employee;
    private EmployeeNode left;
    private EmployeeNode right;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }

    public void setLeft(EmployeeNode left) {
        this.left = left;
    }

    public void setRight(EmployeeNode right) {
        this.right = right;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getLeft() {
        return left;
    }

    public EmployeeNode getRight() {
        return right;
    }

}
