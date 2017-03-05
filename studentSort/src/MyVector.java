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

    protected static MyVector <Student> phoneBook;
    protected static Vector<Association<String, Integer>> addressList;

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
        // Enter String "A" for name, "B" for SU, "C" for vowels "D" for the most densely populated dorm
        // Or "E" for the most common area code by their phone number.
        System.out.println("How would you like for your list to be sorted?\n"+
                "A. By name\n"+
                "B. By SU Box\n"+
                "C. By the number of vowels in the students name\n" +
                "D. By the number of people living in one place\n" +
                "E. Most common area code");

        System.out.println("Sorted\n");
        String response = sc.nextLine();

        phoneBook.giveAnswer(response);

    }

    // Constructor for MyVector; calls on the "super()" method to inherit fields and methods from the Vector class
    public MyVector(){
        super();
    }

    // Method to give answers to questions on lab handout: answers to questions A, B, C, and D
    public static void giveAnswer(String question){
        //Since we will be sorting through a vector of association we will not be using the same student
        //object therefore we will have to create a new comparator and swap method.
        if(question.equalsIgnoreCase("D")){
            populateVecAssociations(phoneBook);
            int a;
            int b;

            for (int j= 0; j>0; j++) {
                boolean swapped = true;


                for (int i = 0; i < addressList.size(); i++) {
                    a = addressList.get(i - 1).getValue();
                    b = addressList.get(i).getValue();

                    int result = a - b;

                    if (result > 0) {
                        swapVecAssociations(i - 1, i);
                        swapped = true;
                    }
                }

                if (!swapped) {
                    break;
                }

            }
        }
        else {
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

    public static void swapVecAssociations (int i, int j){
        Association temp = addressList.get(i);
        addressList.set(i,addressList.elementAt(j));
        addressList.set(j,temp);
    }

    public static void populateVecAssociations (Vector<Student> studentList){
        String address;
        for (int i = 0; i<studentList.size();i++){
            address = studentList.get(i).getAddress();
            boolean keyExists = false;

            for(int j=0;j<addressList.size(); j++) {
                Association<String, Integer> value = addressList.get(j);
                if (value.getKey().equals(address)) {
                    keyExists = true;
                    value.setValue(value.getValue() + 1);
                    break;
                }
            }
            if (!keyExists) {
                Association<String, Integer> newEntry = new Association<String, Integer>(address, 1);
                addressList.add(newEntry);

            }
        }
    }


    // Test method to print out sorted list of students from MyVector.
    public static void printSortedList(){
        for (int i = 0; i < phoneBook.size(); i++){
            Student s = phoneBook.get(i);
            System.out.println(s);
        }
    }
}