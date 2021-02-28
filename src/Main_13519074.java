import classes_13519074.*;                                                                      // Import user-made classes from package classes_13519074
import java.util.ArrayList;                                                                     // Import to use ArrayList
import javax.swing.JOptionPane;                                                                 // Import to make interfaces
import java.io.File;                                                                            // Import the File class
import java.io.FileNotFoundException;                                                           // Import this class to handle errors


public class Main_13519074 {
    public static void main(String[] args) throws FileNotFoundException {
        // Initialization
    	String path;
        
        while (true){                                                                           // Looping while program is running
            do {
                path = JOptionPane.showInputDialog("Course file directory : ");                 // Interface for input
                if (path==null) break;                                                          // Break from loop if path is null
                if (new File(path).exists()) break;                                             // Break if file is found
                else JOptionPane.showMessageDialog(null,"File not found!");                     // Warning interface if file not found
            } while (true);
            
            if (path==null) break;                                                              // Stop program if pat is null
            
            // Local Initialization
            ArrayList<Course_13519074> CourseData = Tools_13519074.convertFileToArray(path);    // Use convertFileToArray from Tools_13519074 
                                                                                                // to convert file to ArrayList of Course_13519074
            StringBuilder output = new StringBuilder();
            int startsemester = 1;
            
            if (CourseData.size()==0){                                                          // Check whether CourseData has courses or not
                output.append("NO COURSES FOUND!\nPlease check your course file again.\n");
            } else if (Tools_13519074.hasCycle(CourseData)){                                    // Check whether CourseData has cycle or not
                output.append("CYCLE EXIST!\nUnable to create plan.\n");
            } else {                                                                            // Passed all check and proceed to edit output
                Tools_13519074.makePlan(output,startsemester,CourseData);                       // by using Tools_13519074 makePlan
            }
            
            JOptionPane.showMessageDialog(null,                                                 // Show created plan result
                                          output.toString(),
                                          "Course Plan Result",
                                          JOptionPane.INFORMATION_MESSAGE);

            int again = JOptionPane.showConfirmDialog(null,                                     // Option to choose wheter user want to generate
                                                      "Do you want to generate another plan?",  // new course plan or not
                                                      "Try Again Confirmation",
                                                      JOptionPane.YES_NO_OPTION);

            if (again==JOptionPane.NO_OPTION) break;                                            // if NO option is selected, stop program from running
        }
    }
}