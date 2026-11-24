/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package staffmanager;

/**
 *
 * @author mac
 */
public enum MenuOption {
    
    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD_RECORDS(3, "Add Employee"),
    BINARY_TREE(4, "Binary Tree"),
    EXIT(5, "Exit");

    private int number;
    private String description;

    
    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
        
        
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption findOption(String input) {
        try {
            int number = Integer.parseInt(input.trim());

            for (MenuOption option : MenuOption.values()) {
                if (option.getNumber() == number) {
                    return option;
                }
            }

        }catch (NumberFormatException e) {
            return null;
            
        }

        return null;
    }
    
}
