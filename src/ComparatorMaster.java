import java.util.Comparator;
//Pre: Given a vector of student objects: grab two objects, get their names
//Post: After comparing both names, place the lower one first.
//
public class ComparatorMaster implements Comparator<Student>{

    String comparison;

    // The compareType passed through the constructor determines what we compare the students by.
    public ComparatorMaster(String compareType){

        comparison = compareType;

    }

    //if a<b return -1
    //if a=b return 0
    //if a>b return 1
    public int compare(Student a, Student b){

        // Alphabetical comparison by name
        if (comparison.equals("A")){
            String name1 = a.getName();
            String name2 = b.getName();

            return name1.compareTo(name2);

        // Numerical comparison by SU Box number
        } else if (comparison.equals("B")){

            int num1 = a.getSuBox();
            int num2 = b.getSuBox();

            return num1-num2;
        } else {
            return -10;
        }
    }
}
