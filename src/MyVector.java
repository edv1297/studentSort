import java.util.Comparator;
import structure5.*;
import java.util.Scanner;

/*

MyVector: an extension of the Vector class that will scan an input text,
gather information about each individual, create objects of class Student,
and add them to the MyVector of Students.

*/
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
        // Enter String "name" for name comparisons, String "SU" for SU comparisons
        //phoneBook.sort(phoneBook, "name");
        phoneBook.sort("name");

    }

    // Constructor for MyVector; calls on the "super()" method to inherit fields and methods from the Vector class
    public MyVector(){
        super();

    }

    // Method to compare students based on some sort type and swap their positions in the Vector as necessary
    public void sort(String sortType){
        Student student1;
        Student student2;

        // A class that implements the Comparator class and handles how the students are to be sorted
        ComparatorMaster comparator = new ComparatorMaster(sortType);

        // Initalize the swap condition to be false
        for (int j = phoneBook.size()-1; j>0; j++){
            boolean swapped = false;
            // TEST CODE
            System.out.println(j);

            //
            for (int i = 1; i < phoneBook.size(); i++){
                student1 = phoneBook.get(i-1);
                student2 = phoneBook.get(i);
                int result = comparator.compare(student1,student2);

                if(result > 0){
                    swap(i-1, i);
                    swapped=true;
                }
            }
            if(!swapped)
                break;
        }
    }

    // Helper method to sort students after they've been compared by some criteria
    public static void swap(int i, int j){
        Student temp = phoneBook.get(i);
        phoneBook.set(i, phoneBook.elementAt(j));
        phoneBook.set(j,temp);

        // TEST CODE
        System.out.println("\nSwapped " + phoneBook.get(i) + " " + phoneBook.get(j));
    }

    //public static void printSortedList


}
