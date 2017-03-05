import java.util.Comparator;
import structure5.*;
import java.util.Scanner;

public class MyVector<E> extends Vector<E> {
    protected static MyVector <Student> phoneBook;

    public static void main(String args[]){

        phoneBook = new MyVector<Student>();

        Scanner sc = new Scanner(System.in);
        StringBuilder textBuffer = new StringBuilder();

        while (sc.hasNextLine()){
            String linebreak = "\n";

            String name = sc.nextLine();
            textBuffer.append(name);
            textBuffer.append(linebreak);

            String address = sc.nextLine();
            textBuffer.append(address);
            textBuffer.append(linebreak);

            long schoolPhone = sc.nextLong();
            textBuffer.append(schoolPhone);
            textBuffer.append(linebreak);

            int suNum = sc.nextInt();
            textBuffer.append(suNum);
            textBuffer.append(linebreak);

            long homePhone = sc.nextLong();
            textBuffer.append(homePhone);
            textBuffer.append(linebreak);

            textBuffer.append(sc.nextLine());
            textBuffer.append(linebreak);

            String breakLine = sc.nextLine();
            textBuffer.append(breakLine);
            textBuffer.append(linebreak);

            Student student = new Student(name, address, schoolPhone, suNum, homePhone);
            phoneBook.add(student);


            // TEST CODE
            System.out.println(student);


        }
        // TEST CODE
        phoneBook.sortByNames(phoneBook);

    }

    public MyVector(){
        super();

    }

    //implementing bubble sort for names
    public void sortByNames(MyVector<Student> students){
        Student student1;
        Student student2;
        NameComparator compareNames = new NameComparator();

        for (int j = students.size()-1; j>0; j++){
            boolean swapped = false;

            for (int i = 1; i < students.size(); i++){
                student1 = students.get(i-1);
                student2 = students.get(i);
                int result = compareNames.compare(student1,student2);

                if(result >0){
                    swap(students, i-1,i);
                    swapped=true;
                }
            }
            if(!swapped)
                break;
        }

    }

    public void sortBySUBox(MyVector<Student> students){
        Student s1;
        Student s2;
        SUBoxComparator compareSU= new SUBoxComparator();
        for(int i= students.size()-1; i>0; i++){
            boolean swapped = false;

        for (int j = 1; j<students.size()-1; j++){
            s1 = students.get(j-1);
            s2 = students.get(j);
            int suBoxResult = compareSU.compare(s1,s2);

            if(suBoxResult>0){
                swap(students,j-1,j);
                swapped = true;
            }
        }
            if(!swapped)
                break;
        }

    }
    public static void swap(MyVector<Student> student, int i, int j){
        Student temp = student.get(i);
        student.set(i,student.elementAt(j));
        student.set(j,temp);

        // TEST CODE
        System.out.println("\nSwapped " + student.get(i) + student.get(j));
    }


}
