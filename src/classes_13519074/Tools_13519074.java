package classes_13519074;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Tools_13519074 {
    // convertFileToArray : function to turn .txt file to Array of Course_13519074
    // input :
    //      filedir : String (.txt file name and directory)
    // output : ArrayList of Course_13519074
    public static ArrayList<Course_13519074> convertFileToArray(String filedir) throws FileNotFoundException {
        ArrayList<Course_13519074> CourseData = new ArrayList<Course_13519074>();
        Scanner scanner = new Scanner(new File(filedir));
        while (scanner.hasNextLine()){
            String[] tempStringList = scanner.nextLine().replaceAll(" ", "").split("[,.]");
            if (tempStringList.length==0 || tempStringList[0].length()==0) continue;
            Course_13519074 tempCourse = new Course_13519074(tempStringList[0]);
            for (String courseID : tempStringList){
                if (courseID!=tempStringList[0]) tempCourse.addPrereq(courseID);
            }
            CourseData.add(tempCourse);
        }
        return CourseData;
    }

    // hasCycle : function to check whether any of the Course_13519074 in ArrayList<Course_13519074> has a cycle
    // input :
    //      CourseData : ArrayList<Course_13519074>
    // output : boolean
    public static boolean hasCycle(ArrayList<Course_13519074> CourseData){
        for (Course_13519074 course : CourseData){
            if (checkCycle(CourseData, course, new ArrayList<String>())) return true;
        }
        return false;
    }

    // hasCycle : function to check if the given Course_13519074 in ArrayList<Course_13519074> has a cycle
    // input :
    //      CourseData : ArrayList<Course_13519074>
    // output : boolean
    public static boolean checkCycle(ArrayList<Course_13519074> CourseData, Course_13519074 currentCourse, ArrayList<String> track){
        ArrayList<String> prereqList = currentCourse.getPrereqList();
        
        if (prereqList.size()==0) return false;                                                 // if dont have prereq, automatically not a cycle
        
        if (track.contains(currentCourse.getCourseID())) return true;                           // already passed (recorded in the track)
        else track.add(currentCourse.getCourseID());                                            // add course to track

        boolean cyclecheck = false;
        for (Course_13519074 course : CourseData){
            if (course==currentCourse) continue;                                                // Skip course if it is the same
            if (prereqList.contains(course.getCourseID())){                                     // Check if the iterated course is in prereqlist
                ArrayList<String> branchtrack = new ArrayList<String>(track);                   // Create a branch track to prevent original track carried and changed by other branch
                cyclecheck = cyclecheck || checkCycle(CourseData, course, branchtrack);         // Check cycle for every branch
            }
        }

        return cyclecheck;
    }

    // makePlan : procedure to edit StringBuilder output for later be shown, this is also the main
    //            implementation of Topological Sort
    // input :
    //      output     : StringBuilder
    //      Semester   : int
    //      CourseData : ArrayList of Course_13519074
	public static void makePlan(StringBuilder output, int Semester, ArrayList<Course_13519074> CourseData) {
		if (CourseData.size()==0) return;                                                       // Base reccursion, stop if CourseData have no more course

        // Initialization
        ArrayList<Course_13519074> courseTaken = new ArrayList<Course_13519074>();              // to store Course_13519074 taken
        boolean firstRegister = true;                                                           // for indicating the first course taken in the semester
        output.append(String.format("Semester %s\t:",Romans_13519074.intToRomans(Semester)));   // add current Semester to StringBuilder
        
        for (Course_13519074 course : CourseData){                                              // record taken course and adding Course ID to output
            if (course.getTotalPrereq()==0){
                if (firstRegister) {
                    output.append(" ");
                    firstRegister=false;
                } else output.append(", ");
                output.append(course.getCourseID());
                courseTaken.add(course);
            }
        }
        output.append("\n");                                                                    // newline after taking all semesters

        for (Course_13519074 course : courseTaken){                                             // removing taken course from CourseData
            CourseData.remove(course);
        }

        for (Course_13519074 course : CourseData){                                              // removing taken course from every courses prereq list in
            for (Course_13519074 takenCourse : courseTaken){                                    // CourseData
                if (course.getPrereqList().contains(takenCourse.getCourseID())){
                    course.removePrereq(takenCourse.getCourseID());
                }
            }
        }

        makePlan(output,Semester+1,CourseData);                                                 // Reccursive with passed output, reduced CourseData, and new Semester
	}
}