package Backend_Tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Employee {
    String id;
    String name;
    int age;
    Date dateOfJoining;

    public Employee(String id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', age=" + age + ", dateOfJoining=" + dateOfJoining + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

public class MyListEmployee {

    private Employee[] array;
    private int size;

    public MyListEmployee() {
        array = new Employee[100];
        size = 0;
    }

    public void addValue(Employee value) {
        if (size == array.length) {
            Employee[] newArray = new Employee[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        if (size <= array.length / 4) {
            Employee[] newArray = new Employee[array.length / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void deleteByValue(Employee value) {
        int index = findIndexByValue(value);
        if (index == -1) {
            System.out.println("Value not found");
            return;
        }
        deleteByIndex(index);
    }

    public Employee findValueByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return null;
        }
        return array[index];
    }

    public int findIndexByValue(Employee value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyListEmployee list = new MyListEmployee();
        Scanner scanner = new Scanner(System.in);
        int choice;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee by index");
            System.out.println("3. Find index by Employee ID");
            System.out.println("4. Delete Employee by index");
            System.out.println("5. Delete Employee by ID");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter Employee Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Employee Age:");
                    int age = scanner.nextInt();
                    System.out.println("Enter Date of Joining (YYYY-MM-DD):");
                    scanner.nextLine();
                    String dateStr = scanner.nextLine();
                    Date dateOfJoining = null;
                    try {
                        dateOfJoining = sdf.parse(dateStr);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                        break;
                    }
                    Employee employee = new Employee(id, name, age, dateOfJoining);
                    list.addValue(employee);
                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.println("Enter index to find Employee:");
                    int indexToFind = scanner.nextInt();
                    Employee emp = list.findValueByIndex(indexToFind);
                    if (emp != null) {
                        System.out.println("Employee at index " + indexToFind + ": " + emp);
                    }
                    break;

                case 3:
                    System.out.println("Enter Employee ID to find index:");
                    String employeeId = scanner.nextLine();
                    int index = list.findIndexByValue(new Employee(employeeId, "", 0, null));
                    if (index != -1) {
                        System.out.println("Index of Employee with ID " + employeeId + ": " + index);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter index to delete Employee:");
                    int indexToDelete = scanner.nextInt();
                    list.deleteByIndex(indexToDelete);
                    System.out.println("Employee deleted at index " + indexToDelete);
                    break;

                case 5:
                    System.out.println("Enter Employee ID to delete:");
                    String idToDelete = scanner.nextLine();
                    list.deleteByValue(new Employee(idToDelete, "", 0, null));
                    System.out.println("Employee deleted with ID " + idToDelete);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
