import java.util.*;

class Main {

    static HashSet<Integer> rollNumbers = new HashSet<>();


 
    static int readMark(Scanner sc, String subject) {

        int mark;

        do {

            System.out.print(
                    "Enter " + subject + " mark (0-100): "
            );

            mark = sc.nextInt();

            if (mark < 0 || mark > 100) {

                System.out.println(
                        "Invalid mark! Please enter between 0 and 100."
                );
            }

        } while (mark < 0 || mark > 100);

        return mark;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        ArrayList<Student> students = new ArrayList<>();


        while (true) {

            System.out.println("\n===== STUDENT MARKS MANAGER =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Class Average");
            System.out.println("5. Find Top Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {


                case 1 -> {
                    System.out.print("Enter roll number: ");

                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    
                    
                  
                    if (rollNumbers.contains(rollNumber)) {

                        System.out.println(
                                "Roll number already exists!"
                        );

                        System.out.println(
                                "Student not added."
                        );

                        break;
                    }
                    
                    
                    System.out.print("Enter student name: ");

                    String name = sc.nextLine();
                    
                    
                    int java = readMark(sc, "Java");

                    int python = readMark(sc, "Python");

                    int dsa = readMark(sc, "DSA");

                    int dbms = readMark(sc, "DBMS");

                    int ml = readMark(sc, "ML");
                    
                    
                  
                    Student student = new Student(
                            rollNumber,
                            name,
                            java,
                            python,
                            dsa,
                            dbms,
                            ml
                    );
                    
                    
                   
                    students.add(student);
                    
               
                    rollNumbers.add(rollNumber);
                    
                    
                    System.out.println(
                            "\nStudent added successfully!"
                    );
                }

                case 2 -> {
                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    }
                    else {

                        System.out.println(
                                "\n===== ALL STUDENTS ====="
                        );

                        for (Student s : students) {

                            s.display();
                        }
                    }
                }

                case 3 -> {
                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    }
                    else {

                        System.out.print(
                                "Enter student name to search: "
                        );

                        String searchName = sc.nextLine();

                        boolean found = false;
                        
                        
                    
                        for (Student s : students) {

                            if (s.name.equalsIgnoreCase(searchName)) {

                                System.out.println(
                                        "\nStudent Found!"
                                );

                                s.display();

                                found = true;

                                break;
                            }
                        }
                        
                        
                        if (!found) {

                            System.out.println(
                                    "Student not found."
                            );
                        }
                    }
                }


                case 4 -> {
                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    }
                    else {

                        int totalMarks = 0;
                        
                        
                        for (Student s : students) {

                            totalMarks += s.getTotal();
                        }
                        
                        
                        double classAverage =
                                (double) totalMarks / students.size();
                        
                        
                        System.out.println(
                                "\nClass Average = "
                                        + classAverage
                        );
                    }
                }



                case 5 -> {
                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    }
                    else {

                        Student top = students.get(0);
                        
                        
                        for (Student s : students) {

                            if (s.getTotal() > top.getTotal()) {

                                top = s;
                            }
                        }
                        
                        
                        System.out.println(
                                "\n===== TOP STUDENT ====="
                        );

                        top.display();
                    }
                }


                case 6 -> {
                    System.out.println(
                            "\nThank you for using Student Marks Manager!"
                    );

                    sc.close();

                    return;
                }


                default -> System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }
    }
}
