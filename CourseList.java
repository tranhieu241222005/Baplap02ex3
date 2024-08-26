package iuh.fit.KTPM;
import java.util.HashMap;
import java.util.Map;

/**
 * @description :
 * @author: Tran Hieu
 * @version: 1.0
 * @created :  25/08/2024 11:29 SA
 */
public class CourseList {
    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }
    // them 1 khoa hoc vao danh sach
    public boolean addCourse(Course course) {
        if (course == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (course.getId().equals(courses[i].getId())) {
                return false; // Khóa học đã tồn tại
            }
        }
        if (count == courses.length) {
            return false; // Danh sách đã đầy
        }
        courses[count++] = course;
        return true;
    }
    // in ra danh sach
    public Course[] getCoursesCopy() {
        Course[] copy = new Course[count];
        System.arraycopy(courses, 0, copy, 0, count);
        return copy;
    }
    //xoa khoa hoc
    public boolean removeCourse(String id) {
        for(int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                for (int j = i; j < count-1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[count - 1] = null;
                count --;
                return true;
            }
        }
        return false;
    }
    // tim khoa hoc theo id
    public Course findCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }
    // tim khoa học theo ten khoa hoc
    public Course findCourseByTitle(String name) {
        for (int i = 0; i < count; i++) {
            if(courses[i].getTitle().equalsIgnoreCase(name)) {
                return courses[i];
            }
        }
        return null;
    }
    //tim khoa hoc theo ten khoa
    public Course[] findCoursesByDepartment(String department) {
        // Đếm số lượng khóa học thuộc khoa phụ trách
        int countInDepartment = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                countInDepartment++;
            }
        }

        // Tạo mảng với kích thước chính xác
        Course[] result = new Course[countInDepartment];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                result[index++] = courses[i];
            }
        }

        return result;
    }
    //sap xep
    public Course[] sortCoursesByTitle() {
        Course[] sortedCourses = getCoursesCopy();
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (sortedCourses[i].getTitle().compareToIgnoreCase(sortedCourses[j].getTitle()) < 0) {
                    Course temp = sortedCourses[i];
                    sortedCourses[i] = sortedCourses[j];
                    sortedCourses[j] = temp;
                }
            }
        }
        return sortedCourses;
    }
    //tim kiem maxCredit
    public Course[] findCoursesWithMaxCredit(){
        if (count == 0) {
            return new Course[0];
        }
        int maxcredit = courses[0].getCredit();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > maxcredit) {
                maxcredit = courses[i].getCredit();
            }
        }
        int numMaxCreditCourses = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxcredit) {
                numMaxCreditCourses++;
            }
        }
        Course[] maxCreditCourses = new Course[numMaxCreditCourses];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxcredit) {
                maxCreditCourses[index++] = courses[i];
            }
        }

        return maxCreditCourses;
    }
    // tim khoa co so luong khoa hoc nhieu nhat
    public String findDepartmentWithMostCourses() {
        if (count == 0) {
            return null; // Trả về null nếu không có khóa học nào
        }

        // Tạo một HashMap để lưu trữ số lượng khóa học của mỗi khoa
        Map<String, Integer> departmentCountMap = new HashMap<>();

        // Duyệt qua danh sách khóa học để đếm số lượng khóa học theo từng khoa
        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCountMap.put(department, departmentCountMap.getOrDefault(department, 0) + 1);
        }

        // Tìm khoa có số lượng khóa học nhiều nhất
        String maxDepartment = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : departmentCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDepartment = entry.getKey();
            }
        }

        return maxDepartment;
    }
}

