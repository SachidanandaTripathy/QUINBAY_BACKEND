package Backend_Tasks;

import java.util.Scanner;

public class GenericMyList<T> {

    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public GenericMyList() {
        array = (T[]) new Object[100];
        size = 0;
    }

    public void addValue(T value) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
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
            T[] newArray = (T[]) new Object[array.length / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void deleteByValue(T value) {
        int index = findIndexByValue(value);
        if (index == -1) {
            System.out.println("Value not found");
            return;
        }
        deleteByIndex(index);
    }

    public T findValueByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return null;
        }
        return array[index];
    }

    public int findIndexByValue(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GenericMyList<Object> list = new GenericMyList<>();
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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the type of value to add (1: Integer, 2: String, 3: Custom Object):");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    if (type == 1) {
                        System.out.println("Enter Integer value:");
                        Integer intValue = scanner.nextInt();
                        list.addValue(intValue);
                    } else if (type == 2) {
                        System.out.println("Enter String value:");
                        String stringValue = scanner.nextLine();
                        list.addValue(stringValue);
                    } else if (type == 3) {
                        System.out.println("Enter Student's name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter Student's age:");
                        int age = scanner.nextInt();
                        list.addValue(new Student(name, age));
                    } else {
                        System.out.println("Invalid type selected.");
                    }
                    break;

                case 2:
                    System.out.println("Enter index to find value:");
                    int indexToFind = scanner.nextInt();
                    Object value = list.findValueByIndex(indexToFind);
                    if (value != null) {
                        System.out.println("Value at index " + indexToFind + ": " + value);
                    }
                    break;

                case 3:
                    System.out.println("Enter value to find index:");
                    // scanner.nextLine();
                    Object valueToFind = scanner.nextLine();
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
                    scanner.nextLine();
                    Object valueToDelete = scanner.nextLine();
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

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Student student = (Student) obj;
            return age == student.age && name.equals(student.name);
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }
}
