package iuh.fit.KTPM;

import java.util.Scanner;

/**
 * @description :
 * @author: Tran Hieu
 * @version: 1.0
 * @created :  25/08/2024 11:30 SA
 */
public class TestCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        Course c1 = new Course("C001","DevC",3,"fit");
        Course c2 = new Course("C002","Java",3,"fit");
        Course c3 = new Course("C003","Hecosodulieu",4,"fit");
        Course c4 = new Course("C004","toancaocap2",3,"toan");

        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);
        for(Course c: courseList.getCourses())
            if(c != null)
                System.out.println(c);
        System.out.println("All Courses:");
        for (Course course : courseList.getCoursesCopy()) {
            System.out.println(course);
        }
        //xoa
        System.out.println("\nEnter the ID of the course to remove:");
        String idToRemove = scanner.nextLine();
        boolean removed = courseList.removeCourse(idToRemove);
        if (removed) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course with ID '" + idToRemove + "' not found.");
        }
        // In danh sách các khóa học sau khi xóa
        System.out.println("\nAll Courses after removal:");
        for (Course course : courseList.getCoursesCopy()) {
            System.out.println(course);
        }
        // Tìm khóa học theo ID
        System.out.println("\nEnter the ID of the course to find:");
        String idToFind = scanner.nextLine();
        Course foundById = courseList.findCourseById(idToFind);
        System.out.println(foundById != null ? foundById : "Course not found.");

        // Tìm khóa học theo tên
        System.out.println("\nEnter the title of the course to find:");
        String titleToFind = scanner.nextLine();
        Course foundByTitle = courseList.findCourseByTitle(titleToFind);
        System.out.println(foundByTitle != null ? foundByTitle : "Course not found.");

        // Tìm khóa học theo khoa phụ trách
        System.out.println("\nEnter the department to find courses:");
        String departmentToFind = scanner.nextLine();
        Course[] foundCoursesByDepartment = courseList.findCoursesByDepartment(departmentToFind);
        if (foundCoursesByDepartment.length > 0) {
            for (Course course : foundCoursesByDepartment) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found for the department.");
        }

        // Sắp xếp các khóa học theo tên
        System.out.println("\nSorted Courses by Title:");
        for (Course sortedCourse : courseList.sortCoursesByTitle()) {
            System.out.println(sortedCourse);
        }

        // Tìm các khóa học có số tín chỉ lớn nhất
        System.out.println("\nCourses with Maximum Credit:");
        for (Course maxCreditCourse : courseList.findCoursesWithMaxCredit()) {
            System.out.println(maxCreditCourse);
        }

        // Tìm khoa phụ trách có nhiều khóa học nhấtasad
        System.out.println("\nDepartment with Most Courses:");
        System.out.println(courseList.findDepartmentWithMostCourses());

        scanner.close();
    }

}

