package academic.model;

/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */
public class Course {  

    private String code;
    private String name;
    private String credits;
    private String passingGrade;
 
    public void setCode(String code) {
        this.code = code;
    }
    public String getname(){
        return this.name;
    } 
    public String getCode() {
        return this.code;
    }
    public String getCredit(){
        return this.credits;
    }
    public String getPassingGrade(){
        return this.passingGrade;
    }

    public Course() { 
        this.code = "";
        this.name = "";
        this.credits = "";
        this.passingGrade = "";
    }

    public Course(String code, String name, String credits, String passingGrade) {
        this.code = code;
        this.name = name; 
        this.credits = credits;
        this.passingGrade = passingGrade;
        
    }

    @Override
    public String toString() {
        return this.code + "|" + this.name + "|" + this.credits + "|" + this.passingGrade;   
    }
        



} 