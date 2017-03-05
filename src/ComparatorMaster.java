import java.util.Comparator;
//Pre: Given a vector of student objects: grab two objects, get their names
//Post: After comparing both names, place the lower one first.
//
public class ComparatorMaster implements Comparator <Student>{

    String comparison;

    public ComparatorMaster(String compareType){

        comparison = compareType;

    }

    //if a<b return -1
    //if a=b return 0
    //if a>b return 1
    public int compare(Student a, Student b){

        if (comparison.equals("name")){
            String name1 = a.getName();
            String name2 = b.getName();

            return name1.compareTo(name2);

        } else if (comparison.equals("SU")){

            int aa = a.getSuBox();
            int bb = b.getSuBox();

            return (aa-bb);
        } else {
            return -10;
        }
    }
}
