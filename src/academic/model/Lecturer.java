package academic.model;
/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */
public class Lecturer extends Person{
    String initial;
    String StdPgr;
    String email;

    public String getId(){
        return super.getID();
    }
    
    public String getNama(){
        return super.getName();
    }
 
    public String getEmail(){
        return this.email;
    }

    public String getInitial(){
        return this.initial;
    }

    public Lecturer(String id, String name, String initial, String email, String StdPgr) {
        super(id, name);
        this.initial = initial;
        this.StdPgr = StdPgr;
        this.email = email;
    }

    public Lecturer(){ 
        super();
        this.initial = "";
        this.StdPgr = "";
        this.email = "";
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.initial + "|" + this.email + "|" + this.StdPgr;
    }
    
}
