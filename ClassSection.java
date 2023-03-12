package ADTBinarySearchTree;
/**
 * Implement the class section
 * @author Junyu Sun
 * @version 1.0
 */
public class ClassSection implements Comparable<ClassSection>{
    private int classNumber;
    private String courseSubject;
    private int catalogNumber;
    private String classTitle;
    private String level;

    /**
     * Create a default course information
     */
    public ClassSection(){
        classNumber = -1;
        courseSubject = "";
        catalogNumber = -1;
        classTitle = "";
        level = "";
    }

    public ClassSection(int classNumber, String courseSubject, int catalogNumber, String classTitle, String level){
        this.classTitle = classTitle;
        this.catalogNumber = catalogNumber;
        this.classNumber = classNumber;
        this.courseSubject = courseSubject;
        this.level = level;

    }

    /**
     * Compare the size of the course number
     * @param o the object to be compared.
     * @return A number representing the result of the comparison
     */
    public int compareTo(ClassSection o){
        return Integer.compare(this.classNumber,o.classNumber);
    }

    /**
     * Print the Class schedule information
     * @return the Class schedule information
     */
    public String toString(){
        return"Class Number :" + classNumber + "  Course Subject :" + courseSubject + "  Catalog Number :" + catalogNumber
                + "  Class Title :" + classTitle + "  Level :" + level;
    }
}
