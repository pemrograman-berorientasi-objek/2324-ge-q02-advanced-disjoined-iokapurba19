package academic.model;
/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */
public class Enrollment {

    private String student;
    private String course;
    private String year;
    private String semester;
    private String grade = "None";
    private String status = "None";
    private String temp = "";


    public void setTemp(String Temp){
        this.temp = Temp;
    }
    
    public void setStatus(String stat){
        this.status = stat;
    }

    public String getStatus(){
        return this.status;
    }

    public String getStd(){
        return this.student;
    } 
    public String getCrs(){
        return this.course;
    }
    public String getYear(){
        return this.year;
    }
    public String getSem(){
        return this.semester;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String Grade){
        this.grade = Grade;
    }

    public Enrollment(String course, String student, String year, String semester) {
        
        this.student = student;
        this.course = course;
        this.year = year;
        this.semester = semester;
    }


     
    @Override 
    public String toString() {
        return this.course+ "|" + this.student + "|" + this.year + "|" + this.semester + "|" + this.temp;      
    } 
    
    
  
}  