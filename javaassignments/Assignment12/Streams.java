package javaassignments;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    public void printAllDepartments(List<Student> list)
    {

        //1. Print the name of all departments in the college?

        Set<String> set =list.stream()
                .map(student-> student.engDepartment)
                .collect(Collectors.toSet());

        for (String department : set)
            System.out.println(department+" ");

    }

    public void studentsEnrolledAfter2018(List<Student> list)
    {
        // 2.Get the names of all students who have enrolled after 2018?


        List<String> after2018=list.stream()
                .filter(student -> student.yearOfEnrollment>2018)
                .map(student -> student.name)
                .collect(Collectors.toList());

        for(String name : after2018)
            System.out.println(name+", ");
    }

    public List<Student> maleStudentsInCSE(List<Student> list)
    {
        //3. Get the details of all male student in the computer sci department?
        List<Student> maleInCse=list.stream()
                .filter(student -> student.gender.equals("Male") && student.engDepartment.equals("Computer Science"))
                .collect(Collectors.toList());
        System.out.println("There are "+maleInCse.size()+" male students in cse department");
        return maleInCse;

    }

    public void genderCount(List<Student> list)
    {

        //4. How many male and female student are there ?
        Long male=list.stream()
                .filter((student -> student.gender.equals("Male")))
                .collect(Collectors.counting());

        Long female=list.stream()
                .filter((student -> student.gender.equals("Female")))
                .collect(Collectors.counting());

        System.out.println("No of Male students : "+male+"\n"+"No of Female students : "+female);
    }


    public void averageAge(List<Student> list)
    {
        //5.What is the average age of male and female students?
        Double male=list.stream()
                .filter((student -> student.gender.equals("Male")))
                .collect(Collectors.averagingInt(student -> student.age));

        Double female=list.stream()
                .filter((student -> student.gender.equals("Female")))
                .collect(Collectors.averagingInt(student -> student.age));

        System.out.println("Avg age of Male students : "+male+"\n"+"Avg age of Female students : "+female);

    }

    public void highestPercentage(List<Student> list)
    {
        //6.Get the details of highest student having highest percentage ?
        Optional<Student> highest=list.stream()
                .collect(Collectors.maxBy
                        (Comparator.comparing(student->student.perTillDate)));
        System.out.println("Name of student with highest percentage is "+(highest.isPresent()?highest.get().name:"Not possible"));
    }

    public void studentsInEachDepartment(List<Student> list)
    {
        //7.Count the number of students in each department?
        Set<String> set = list.stream()
                .map(student -> student.engDepartment)
                .collect(Collectors.toSet());

        for (String department : set) {
            Long count = list.stream()
                    .filter((student -> student.engDepartment.equals(department)))
                    .collect(Collectors.counting());
            System.out.println(department + " " +count);
        }
    }

    public void averagePercentage(List<Student> list) {
        //8. What is the average percentage achieved in each department?
        Set<String> set = list.stream()
                .map(student -> student.engDepartment)
                .collect(Collectors.toSet());

        for (String department : set) {
            Double avg = list.stream()
                    .filter((student -> student.engDepartment.equals(department)))
                    .collect(Collectors.averagingDouble(student->student.perTillDate));
            System.out.println("Department : "+department + "\n"+ "Average Percentage :"+avg+"\n");
        }
    }
    public void youngestStudentInElectronics(List<Student> list)
    {
        //9. Get the details of youngest male student in the Electronic department?
        Optional<Student> highest=list.stream().filter(student->student.engDepartment.equals("Electronic"))
                .collect(Collectors.minBy
                        (Comparator.comparing(student->student.age)));
        System.out.println("Name of student with highest percentage is "+(highest.isPresent()?highest.get().name:"Not possible"));
    }

    public void genderCountInCse(List<Student> list)
    {
        //10.How many male and female students are there in the computer science department?
        Long male=list.stream()
                .filter((student -> student.gender.equals("Male") && student.engDepartment.equals("Computer Science")))
                .collect(Collectors.counting());

        Long female=list.stream()
                .filter((student -> student.gender.equals("Female") && student.engDepartment.equals("Computer Science")))
                .collect(Collectors.counting());

        System.out.println("No of Male students in CSE : "+male+"\n"+"No of Female students in CSE : "+female);
    }

    public static void main(String[] args) {
        List<Student> employeeList = new ArrayList<>();
        employeeList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        employeeList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        employeeList.add( new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        employeeList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        employeeList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        employeeList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        employeeList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        employeeList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        employeeList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        employeeList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        employeeList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        employeeList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        employeeList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        employeeList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        employeeList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        employeeList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        employeeList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        Streams example=new Streams();
        example.studentsInEachDepartment(employeeList);
}
}