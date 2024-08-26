package iuh.fit.KTPM;

/**
 * @description :
 * @author: Tran Hieu
 * @version: 1.0
 * @created :  25/08/2024 11:29 SA
 */
public class Course {
    private String id;
    private String title;
    private int  credit;
    private String department;
    public Course() {
        this("","",0,"");
    }
    public Course(String id, String title, int credit, String department) {
        this.id = id ;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.trim().length()<3){
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        for(int i=0;i<id.length();i++){
            char ch = id.charAt(i);
            if(!Character.isLetterOrDigit(ch)){
                throw new IllegalArgumentException("ID must contain letters");
            }
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if(credit <= 0){
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return String.format("%-10s%-25s%10s   %-10s",id, title,credit,department);
    }
}
