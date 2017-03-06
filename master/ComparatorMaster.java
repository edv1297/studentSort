import java.util.Comparator;
//Pre: Given a vector of student objects: grab two objects, get their names
//Post: After comparing both names, place the lower one first.
//
public class ComparatorMaster implements Comparator<Student>{

    String comparison;

    // The String passed through the constructor determines what we compare the students by.
    public ComparatorMaster(String compareType){
        comparison = compareType;
    }

    /*
    Method that compares two Students by certain criteria:
    A = name comparison
    B = SU box num comparison
    C = vowel count comparison
    D = address frequency comparison
    */
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

        // Numerical comparison by number of vowels in name
        } else if (comparison.equals("C")){
            int vowel1 = a.getVowels();
            int vowel2 = b.getVowels();

            return vowel1 - vowel2;

        } else {
            return 0;
        }
    }
}
