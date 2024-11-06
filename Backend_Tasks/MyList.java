package Backend_Tasks;
import java.util.Scanner;

public class MyList {

    private int[] array;
    private int size;

    public MyList() {
        array = new int[100];
        size = 0;
    }

    public void addValue(int value) {
        if (size == array.length) {
            // Using Arrays.copyOf() to resize the array
            // array = Arrays.copyOf(array, array.length * 2); 
            int[] newArray = new int[array.length * 2];  // Manually resizing the array
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
            // Using Arrays.copyOf() to shrink the array
            // array = Arrays.copyOf(array, array.length / 2);  
            int[] newArray = new int[array.length / 2];  // Manually resizing the array
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i]; 
            }
            array = newArray; 
        }
    }

    public void deleteByValue(int value) {
        int index = findIndexByValue(value);
        if (index == -1) {
            System.out.println("Value not found");
            return;
        }
        deleteByIndex(index);
    }

    public int findValueByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return -1;
        }
        return array[index];
    }

    public int findIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add value");
            System.out.println("2. Find value by index");
            System.out.println("3. Find index by value");
            System.out.println("4. Delete by index");
            System.out.println("5. Delete by value");
            System.out.println("6. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter value to add:");
                    int valueToAdd = scanner.nextInt();
                    list.addValue(valueToAdd);
                    System.out.println("Value added.");
                    break;

                case 2:
                    System.out.println("Enter index to find value:");
                    int indexToFind = scanner.nextInt();
                    int value = list.findValueByIndex(indexToFind);
                    if (value != -1) {
                        System.out.println("Value at index " + indexToFind + ": " + value);
                    }
                    break;

                case 3:
                    System.out.println("Enter value to find index:");
                    int valueToFind = scanner.nextInt();
                    int index = list.findIndexByValue(valueToFind);
                    if (index != -1) {
                        System.out.println("Index of value " + valueToFind + ": " + index);
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter index to delete:");
                    int indexToDelete = scanner.nextInt();
                    list.deleteByIndex(indexToDelete);
                    System.out.println("Element deleted at index " + indexToDelete);
                    break;

                case 5:
                    System.out.println("Enter value to delete:");
                    int valueToDelete = scanner.nextInt();
                    list.deleteByValue(valueToDelete);
                    System.out.println("Element deleted with value " + valueToDelete);
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
