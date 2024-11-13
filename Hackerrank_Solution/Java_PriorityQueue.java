import java.util.*;
public class Java_PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}


class Student implements Comparable<Student> {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {
        if (this.cgpa > other.cgpa) {
            return -1;
        } else if (this.cgpa < other.cgpa) {
            return 1;
        } else {
            if (!this.name.equals(other.name)) {
                return this.name.compareTo(other.name);
            } else {
                return Integer.compare(this.id, other.id);
            }
        }
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>();
        
        for (String event : events) {
            String[] parts = event.split(" ");
            String command = parts[0];
            
            if (command.equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                queue.add(new Student(id, name, cgpa));
            } else if (command.equals("SERVED")) {
                queue.poll();
            }
        }
        
        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        
        return students;
    }
}