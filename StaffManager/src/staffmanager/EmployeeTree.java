/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffmanager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mac
 */
public class EmployeeTree {

    private EmployeeNode root;

    public void insert(Employee employee) {

        EmployeeNode newNode = new EmployeeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            EmployeeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }

    public ArrayList<ArrayList<Employee>> levelOrderTraversal() {

        ArrayList<ArrayList<Employee>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int nodesInLevel = queue.size();
            ArrayList<Employee> level = new ArrayList<>();

            for (int i = 0; i < nodesInLevel; i++) {

                EmployeeNode current = queue.poll();
                level.add(current.getEmployee());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }

            levels.add(level);
        }

        return levels;
    }

    public int getHeight() {
        return height(root);
    }

    private int height(EmployeeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int getNodeCount() {
        return countNodes(root);
    }

    private int countNodes(EmployeeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

}
