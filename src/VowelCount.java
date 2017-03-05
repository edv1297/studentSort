/**
 * Created by Varela on 3/4/17.
 */

import java.util.Comparator;
//Pre: Given a vector of student objects grab two objects, get their names
//Post: After comparing both names, place the lower one first.
//
public class VowelCount implements Comparator <Student>{

    public VowelCount (Student s1, Student s2){

        compare(s1, s2);
    }
    //if a<b return -1
    //if a=b return 0
    //if a>b return 1
    public int compare(Student s, Student s2){
        String name1 = s.getName();
        String name2 = s2.getName();
        int name1Vowel = 0;
        int name2Vowel = 0;
        for(int i = 0; i<name1.length()-1; ++i){

            if(name1.charAt(i)=='a' || name1.charAt(i)=='e' ||
            name1.charAt(i)=='i' || name1.charAt(i)=='o' ||
            name1.charAt(i)=='u'){
                name1Vowel++;
            }
        }
        for (int j = 0; j<name2.length()-1; ++j){
            if(name2.charAt(j) == 'a' || name2.charAt(j)=='e'||
               name2.charAt(j) == 'i' || name2.charAt(j)=='o' ||
               name2.charAt(j) == 'u'){
                name2Vowel++;
            }

        }
        return name1Vowel-name2Vowel;
    }
}
