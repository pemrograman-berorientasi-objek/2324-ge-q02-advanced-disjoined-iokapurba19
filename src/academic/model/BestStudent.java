package academic.model;

/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */
public class BestStudent{

    private  String Id;
    private  String Grade;

    public BestStudent(String _id, String _grade){
        this.Id = _id;
        this.Grade = _grade;
    }

    @Override
    public String toString() {
        return this.Id+"|"+this.Grade;
    }


}