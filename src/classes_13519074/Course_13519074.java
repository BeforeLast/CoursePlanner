package classes_13519074;
import java.util.ArrayList;

public class Course_13519074 {
    private ArrayList<String> prereq;
    private String courseID;
    
    /*** constructor ***/
    // Course_13519074 : Create objeck with the given input string as the objeck CourseID
    // input :
    //      courseID : String
    public Course_13519074(String courseID){
        this.prereq = new ArrayList<String>();
        this.courseID=courseID;
    }

    /*** getter ***/
    // getCourseID : get object's course ID
    // output : String
    public String getCourseID(){
        return courseID;
    }

    // getTotalPrereq : get object's prereq size
    // output : int
    public int getTotalPrereq(){
        return prereq.size();
    }

    // getPrereqList : get object's prereq List
    // output : ArrayList<String>
    public ArrayList<String> getPrereqList(){
        return prereq;
    }

    /*** editing attributes ***/
    // addPrereq : add string (course id) to object's prereq List
    // input :
    //      courseID : String
    public void addPrereq(String courseID){
        prereq.add(courseID);
    }

    // removePrereq : remove string (course id) from object's prereq List
    // input :
    //      courseID : String
    public void removePrereq(String courseID){
        if (prereq.contains(courseID)) prereq.remove(courseID);
    }

    // printInfo : print course info along with it's requirement
    public void printInfo(){
        System.out.println("COURSE ID : " + courseID);
        for (String cID : prereq){
            System.out.println('-' + cID);
        }
    }
    
}