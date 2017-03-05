/**
 * Created by Varela on 3/4/17.
 */

import java.util.Comparator;
//Pre: Given a vector of student objects: grab two objects, get their names
//Post: After comparing both names, place the lower one first.
//
public class NameComparator implements Comparator <Student>{

    public NameComparator (){

    }
    //if a<b return -1
    //if a=b return 0
    //if a>b return 1
    public int compare(Student s, Student s2){
        String name1 = s.getName();
        String name2 = s2.getName();

        return name1.compareTo(name2);
    }

}
