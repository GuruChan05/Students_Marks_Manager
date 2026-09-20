class Student {

    int rollNumber;
    String name;

    int java;
    int python;
    int dsa;
    int dbms;
    int ml;

    Student(
            int rollNumber,
            String name,
            int java,
            int python,
            int dsa,
            int dbms,
            int ml
    ) {

        this.rollNumber = rollNumber;
        this.name = name;
        this.java = java;
        this.python = python;
        this.dsa = dsa;
        this.dbms = dbms;
        this.ml = ml;
    }

    int getTotal() {

        return java + python + dsa + dbms + ml;
    }

    double getAverage() {

        return getTotal() / 5.0;
    }

    String getGrade() {

        double average = getAverage();

        if (average >= 90) {
            return "A+";
        }
        else if (average >= 80) {
            return "A";
        }
        else if (average >= 70) {
            return "B";
        }
        else if (average >= 60) {
            return "C";
        }
        else if (average >= 50) {
            return "D";
        }
        else {
            return "F";
        }
    }

    boolean isPass() {

        return java >= 40 &&
               python >= 40 &&
               dsa >= 40 &&
               dbms >= 40 &&
               ml >= 40;
    }

    void display() {

        System.out.println("\n-------------------------");

        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Student     : " + name);

        System.out.println("Java        : " + java);
        System.out.println("Python      : " + python);
        System.out.println("DSA         : " + dsa);
        System.out.println("DBMS        : " + dbms);
        System.out.println("ML          : " + ml);

        System.out.println("-------------------------");

        System.out.println("Total       : " + getTotal() + " / 500");
        System.out.println("Average     : " + getAverage());
        System.out.println("Grade       : " + getGrade());

        if (isPass()) {
            System.out.println("Result      : PASS");
        }
        else {
            System.out.println("Result      : FAIL");
        }

        System.out.println("-------------------------");
    }
}
