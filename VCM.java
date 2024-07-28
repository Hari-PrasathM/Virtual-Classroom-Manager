import java.util.*;

class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Classroom " + className + " already exists.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(studentId);
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    private void displayMenu() {
        System.out.println("\nVirtual Classroom Manager");
        System.out.println("1. Add Classroom");
        System.out.println("2. Add Student");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            manager.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter classroom name: ");
                    String className = scanner.nextLine();
                    manager.addClassroom(className);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter classroom name: ");
                    className = scanner.nextLine();
                    manager.addStudent(studentId, className);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting Virtual Classroom Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

class Classroom {
    private String name;
    private Set<String> students;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

    public void addStudent(String studentId) {
        students.add(studentId);
    }
}