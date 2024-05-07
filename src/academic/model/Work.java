package academic.model;
import java.util.ArrayList;

/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */
public class Work {

    private static ArrayList<Student> Std;
    private static ArrayList<Lecturer> Lctr;
    private static ArrayList<Enrollment> Enrl;
    private static ArrayList<Course> Crs;
    private static ArrayList<OpenCourse> Open;
    private static ArrayList<BestStudent> BestStudent;
    private static int idxCrsOpen;

    public Work() {
        Std = new ArrayList<Student>();
        Lctr = new ArrayList<Lecturer>();
        Enrl = new ArrayList<Enrollment>();
        Crs = new ArrayList<Course>();
        Open = new ArrayList<OpenCourse>();
        BestStudent = new ArrayList<BestStudent>();
        idxCrsOpen = 0;
    }

    public void addCourse(String[] pecahan) {
        Crs.add(new Course(pecahan[1], pecahan[2], pecahan[3], pecahan[4]));
    }

    public void openCourse(String[] pecahan) {
            String matkul = "";
            int sks = 0;
            String passGrade = "";
            for(Course C : Crs){
                if(C.getCode().equals(pecahan[1])){
                    matkul = C.getname();
                    sks = Integer.parseInt(C.getCredit());
                    passGrade = C.getPassingGrade();
                }
            }
            String Dosen[] = pecahan[4].split(",");
            int countDosen = Dosen.length;
            boolean stdExist = false;
            boolean lctExist = false;
            for(Course C : Crs){
                if(C.getCode().equals(pecahan[1])){
                    stdExist = true;
                    break;
                }
            }
            for(Lecturer l : Lctr){
                for(int i = 0; i < countDosen; i++){
                    if(l.getInitial().equals(Dosen[i])){
                        lctExist = true;
                        break;
                    }
                }
            }           
            if(stdExist == true && lctExist == true){
                Open.add(new OpenCourse(pecahan[1], matkul, sks, passGrade, pecahan[2], pecahan[3], LecturerList(Dosen, countDosen)));
                idxCrsOpen++;
            }
    }

    public String LecturerList(String[] list, int countDosen){
        String LecList = "";
        int posisi = 1;
        for(int i = 0; i < countDosen; i++){
            for(Lecturer l : Lctr){
                if(l.getInitial().equals(list[i])){
                    String temp = l.getEmail();
                    LecList = LecList.concat(list[i] + " (+" + temp + ")");
                    continue;
                }
            }
            if(posisi == countDosen){
                continue;
            }
            LecList = LecList.concat(";");
            posisi++;
        }
        return LecList;
    }

    public void showCourseHistory(String courseCode) {
        String showCourse = courseCode;
        Open.sort((s1, s2) -> s2.getSemester().compareTo(s1.getSemester()));
        for(int i = 0; i < idxCrsOpen; i++){
            String tempCrs = Open.get(i).getCourseCode();
            String tempYear = Open.get(i).getAcademicYear();
            String tempSem = Open.get(i).getSemester();
            System.out.println(Open.get(i).toString());
            if(Open.get(i).getCourseCode().equals(showCourse)){
                for(Enrollment E : Enrl){
                    if(E.getCrs().equals(tempCrs) && E.getYear().equals(tempYear) && E.getSem().equals(tempSem)){
                        System.out.println(E.toString());
                    }
                }
            }

        }
    }

    public void addStudent(String[] pecahan) {
        boolean bool = false;
        for(Student s : Std){
            if(s.getName().equals(pecahan[2])){
            bool = true;
            break;
            }
        }
        if(bool == false){
        Std.add(new Student(pecahan[1], pecahan[2], pecahan[3], pecahan[4]));
        }
    }

    public void addEnrollment(String[] pecahan) {
        Enrl.add(new Enrollment(pecahan[1], pecahan[2], pecahan[3], pecahan[4]));
    }

    public void markRemedial(String[] pecahan) {
        for(Enrollment E : Enrl){
            if(E.getCrs().equals(pecahan[1]) && E.getStd().equals(pecahan[2]) && E.getYear().equals(pecahan[3]) && E.getSem().equals(pecahan[4])){
                if(E.getGrade().equals("None")){
                    continue;  
                }
                if(E.getStatus().equals("Remed")){
                    continue;
                } else {
                    String temp = E.getGrade();
                    String simpan = "";
                    E.setGrade(pecahan[5]);
                    simpan = simpan.concat(E.getGrade() + "(" + temp + ")");
                    E.setStatus("Remed");
                    E.setTemp(simpan);
                }
            }
        }
    }

    public void addLecturer(String[] pecahan) {
        boolean sama = false;
        for(Lecturer l : Lctr){
            if(l.getId().equals(pecahan[1])){
                sama = true;
                break;
            }
        }  
        if(sama == false){
            Lctr.add(new Lecturer(pecahan[1], pecahan[2], pecahan[3], pecahan[4], pecahan[5]));
        }
    }

    public void updateEnrollmentGrade(String[] pecahan) {
        for(Enrollment E : Enrl){
            if(E.getCrs().equals(pecahan[1]) && E.getStd().equals(pecahan[2]) && E.getYear().equals(pecahan[3]) && E.getSem().equals(pecahan[4])){
                E.setGrade(pecahan[5]);
                E.setTemp(pecahan[5]);
            }
        }
    }

    public void showStudentDetails(String studentId) {
        int index = 0;
        String[] nilai = new String[10];
        int[] sks = new int[10];
        String[] matkul = new String[10];
        for(Enrollment E : Enrl){
            if(E.getStd().equals(studentId)){
                matkul[index] = E.getCrs();
                nilai[index] = E.getGrade();
                    for(Course C : Crs){
                        if(C.getCode().equals(matkul[index])){
                            sks[index] = Integer.parseInt(C.getCredit());
                        }
                    }
                index++;
            }
        }
        for(int i = 0; i < index; i++){
            for(int j = i+1; j < index; j++){
                if(matkul[i].equals(matkul[j])){
                    sks[i] = 0;
                    nilai[i] = "None";
                    matkul[i] = "";
                }
            }
        } 
        Double totalNilai = 0.00;
        Double IPK = 0.00;
        int totalSKS = 0;
        for(int i = 0; i < index; i++){
            if(nilai[i].equals("A")){
                totalNilai = totalNilai + (sks[i] * 4.00);
            }
            if(nilai[i].equals("AB")){
                totalNilai = totalNilai + (sks[i] * 3.50);
            }
            if(nilai[i].equals("B")){
                totalNilai = totalNilai + (sks[i] * 3.00);
            }
            if(nilai[i].equals("BC")){
                totalNilai = totalNilai + (sks[i] * 2.50);
            }
            if(nilai[i].equals("C")){
                totalNilai = totalNilai + (sks[i] * 2.00);
            }
            if(nilai[i].equals("D")){
                totalNilai = totalNilai + (sks[i] * 1.00);
            }
            if(nilai[i].equals("E")){
                totalNilai = totalNilai + (sks[i] * 0.00);
            }
            if(nilai[i].equals("None")){
                totalNilai = totalNilai + (sks[i] * 0.00);
                sks[i] = 0;
            }
            totalSKS = totalSKS + sks[i];
        }     
        if(totalSKS == 0){
            IPK = 0.00;
        } else {
            IPK = totalNilai / totalSKS;   
        }   
        for(Student Stdnt : Std){
            if(Stdnt.getId().equals(studentId)){
                System.out.print(Stdnt.toString()+"|");
                System.out.print(String.format(("%.2f"), IPK));
                System.out.println("|" + totalSKS);
            }
        }
    }

    public void findTheBestStudent(String tahun, String semester){
        ArrayList<Enrollment> tempEnrl = new ArrayList<Enrollment>();
        ArrayList<Enrollment> unfilteredErnl = new ArrayList<Enrollment>();
        for(Enrollment E : Enrl){
            if(E.getSem().equals(semester) && E.getYear().equals(tahun)){
                tempEnrl.add(E);
                unfilteredErnl.add(E);
            }   
        }
        tempEnrl.sort((e1, e2) -> e1.getGrade().compareTo(e2.getGrade()));
        String bestGrade = tempEnrl.get(0).getGrade();
        String bestStudent = new String();
        int count = 0;
        for(Enrollment E : tempEnrl){
            if(E.getGrade().equals(bestGrade)){
                count++;
            }
        }
        if(count > 1){
            bestStudent = unfilteredErnl.get(1).getStd();
        }else {
            bestStudent = unfilteredErnl.get(0).getStd();
        }
        String studentGrade = "";
        for(Enrollment E : Enrl){
            if(E.getStd().equals(bestStudent) && E.getYear().equals(tahun) && E.getSem().equals("odd")){
                studentGrade = E.getGrade() + "/";
            }
        }
        for(Enrollment E : Enrl){
            if(E.getStd().equals(bestStudent) && E.getYear().equals(tahun) && E.getSem().equals("even")){
                studentGrade += E.getGrade();
            }
        }
        BestStudent.add(new BestStudent(bestStudent, studentGrade));
    }

    public void printData() {
        for (Lecturer lecturer : Lctr) {
            System.out.println(lecturer.toString());
        }
        for (Course course : Crs) {
            System.out.println(course.toString());
        }
        for (Student student : Std) {
            System.out.println(student.toString());
        }
        for (Enrollment enrollment : Enrl) {
            System.out.println(enrollment.toString());
        }
        for(BestStudent B : BestStudent){
            System.out.println(B.toString());
        }
    }
}