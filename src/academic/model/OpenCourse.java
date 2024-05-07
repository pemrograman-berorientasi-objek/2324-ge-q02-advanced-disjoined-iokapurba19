package academic.model;

/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */

public class OpenCourse {
    
    private String CourseCode;
    private String AcademicYear;
    private String Semester;
    private String Lecturer;
    private String CourseName;
    private int Credit;
    private String PassingGrade;

    public OpenCourse (){
        CourseCode = "";
        AcademicYear = "";
        Semester = "";
        Lecturer = "";
        CourseName = "";
        Credit = 0;
        PassingGrade = "";
    }

    public OpenCourse (String crscode, String crsname, int credit , String passgrade, String year, String sem, String lecturer){
        this.CourseCode = crscode;
        this.AcademicYear = year;
        this.Semester = sem;
        this.Lecturer = lecturer;
        this.CourseName = crsname;
        this.Credit = credit;
        this.PassingGrade = passgrade;
    }

    public void setCourseCode (String crscode){
        this.CourseCode = crscode;
    }
    public void setAcademicYear (String year){
        this.AcademicYear = year;
    }
    public void setSemester (String sem){
        this.Semester = sem;
    }
    public void setLecturer (String lecturer){
        this.Lecturer = lecturer;
    }
    public String getCourseCode (){
        return this.CourseCode;
    }
    public String getAcademicYear (){
        return this.AcademicYear;
    }
    public String getSemester (){
        return this.Semester;
    }
    public String getLecturer (){ 
        return this.Lecturer;
    }

    @Override
    public String toString(){
       return this.CourseCode + "|" + this.CourseName + "|" + this.Credit + "|" + this.PassingGrade + "|" + this.AcademicYear + "|" + this.Semester + "|" + this.Lecturer;
    }

}
