import structure5.*;
import java.util.Scanner;

/**
 * Created by VarelaHong on 3/4/17.
 */

/*

MyVector: an extension of the Vector class that will scan an input text,
gather information about each individual, create objects of class Student,
and add them to the MyVector of Students.

*/
public class MyVector<E> extends Vector<E> {

    protected static MyVector<Student> phoneBook;
    protected static Vector<Association<String, Integer>> addressList = new Vector<Association<String, Integer>>(0);

    public static void main(String args[]){

        phoneBook = new MyVector<Student>();
        Scanner sc = new Scanner(System.in);
        StringBuilder textBuffer = new StringBuilder();

        while (sc.hasNextLine()){

            String name = sc.nextLine();
            textBuffer.append(name);
            textBuffer.append("\n");

            String address = sc.nextLine();
            textBuffer.append(address);
            textBuffer.append("\n");

            long schoolPhone = sc.nextLong();
            textBuffer.append(schoolPhone);
            textBuffer.append("\n");

            int suNum = sc.nextInt();
            textBuffer.append(suNum);
            textBuffer.append("\n");

            long homePhone = sc.nextLong();
            textBuffer.append(homePhone);
            textBuffer.append("\n");

            textBuffer.append(sc.nextLine());
            textBuffer.append("\n");

            String breakLine = sc.nextLine();
            textBuffer.append(breakLine);
            textBuffer.append("\n");

            Student student = new Student(name, address, schoolPhone, suNum, homePhone);
            phoneBook.add(student);

        }
        // TEST CODE
        // Enter String "A" for name, "B" for SU, "C" for vowels, "D" for the most densely populated dorm
        // Or "E" for the most common area code by phone number.
        System.out.println("How would you like for your list to be sorted?\n"+
                "A. By name\n"+
                "B. By SU Box\n"+
                "C. By the number of vowels in the students name\n" +
                "D. By the number of people living in one place\n" +
                "E. Most common area code\n");

        if (args.length == 0){
            System.out.println("Usage: java MyVector <letter choice> < <inputfile.txt>\n");
        } else {
        String response = String.valueOf(args[0]);
        phoneBook.giveAnswer(response);
    }
}

    // Constructor for MyVector; calls on the "super()" method to inherit fields and methods from the Vector class
    public MyVector(){
        super();
    }

    // Method to give answers to questions from the lab handout: Questions A, B, C, and D
    public static void giveAnswer(String question){

        if (question.equals("D")){
            AddressVector address = new AddressVector(phoneBook);

        } else {
            phoneBook.sort(question);
            phoneBook.printSortedList();
            Student first = phoneBook.firstElement();
            Student last = phoneBook.lastElement();
            System.out.print("First " + first + "\n");
            System.out.print("Last " + last + "\n");

        }
    }

    // Method to compare students based on some sort type and swap their positions in the Vector as necessary
    public void sort(String sortType){
        Student student1;
        Student student2;

        // calls master comparator and decides, based on the sortType, how to sort students.
        ComparatorMaster comparator = new ComparatorMaster(sortType);

        // Initialize the swap condition to be false
        for (int j = phoneBook.size(); j>0; j--){
            boolean swapped = false;

            // Starting from i=1, we compare student at i to the student at i-1.
            for (int i = 1; i < phoneBook.size(); i++){
                student1 = phoneBook.get(i-1);
                student2 = phoneBook.get(i);
                int result = comparator.compare(student1,student2);

                // Push the greater values towards the end of the vector
                if(result > 0){
                    swap(i-1, i);
                    swapped = true;
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
    }


    // Test method to print out sorted list of students from MyVector.
    public static void printSortedList(){
        for (int i = 0; i < phoneBook.size(); i++){
            Student s = phoneBook.get(i);
            System.out.println(s);
        }
    }
}
