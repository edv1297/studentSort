import java.util.Comparator;

/**
 * Created by Varela on 3/4/17.
 */
    public class SUBoxComparator implements Comparator<Student> {


        public SUBoxComparator(Student a, Student b){

        }

        public int compare(Student a, Student b){
            int aa = a.getSuBox();
            int bb = b.getSuBox();

            return (aa-bb);
            }
        }


