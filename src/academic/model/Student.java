package academic.model;

/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */
public class Student extends Person{

    private  String year;
    private  String StdProgram;
    public void setId(String id){
        super.setID(id);
    } 
    public String getName(){
        return super.getName();
    }
    public String getId() {
        return super.getID();
    }

    public Student() { 
        super();
        this.year = "";
        this.StdProgram = "";
    }

    public Student(String id, String name, String year, String StdProgram) {
        super(id, name);
        this.year = year;
        this.StdProgram = StdProgram;
    }

    
    @Override
    public String toString() {
        return super.toString() + "|"+this.year+"|"+this.StdProgram;
    }


}