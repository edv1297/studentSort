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
    protected static Vector<Association<String, Integer>> phoneList;

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

            for (int j= 0; j>phoneBook.size(); j++) {
                boolean swapped = true;

                for (int i = 0; i < addressList.size(); i++) {
                    a = addressList.get(i - 1).getValue();
                    b = addressList.get(i).getValue();

                    int result = a - b;
                    if (result > 0) {
                        swapVecAssociations(addressList,i - 1, i);
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }

            //at this point the vector of associations should be populated and sorted.
            int studentAmt = addressList.getLast().getValue();
            String searchAddress = addressList.getLast().getKey();

            //sort students by address to make faster.
            phoneBook.sort(question);
            System.out.println("Most popular Building on campus\n" +
                                "-------------------------------\n");

            for(int i =0; i<studentAmt; i++){
                Student s = phoneBook.binarySearch(phoneBook, searchAddress);
                System.out.println(s);
            }

        }
        if(question.equalsIgnoreCase("E")){
            populatePhoneAssociations(phoneBook);
            int a,b;

            for(int i = 0; i<phoneBook.size(); i++){
                boolean swapped = true;
                for(int j = 1; j<phoneList.size();j++){
                    a = phoneList.get(j-1).getValue();
                    b = phoneList.get(j).getValue();

                    int result = a-b;
                    if(result>0){
                        swapVecAssociations(phoneList,j-1,j);
                    }
                }
            if(!swapped){
                break;
                }
            }
            int start = phoneList.size();

            for(int i= start-1; i<start-10; i--){
                String areaCode = phoneList.get(i).getKey();
                System.out.println(areaCode);
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

    public static void swapVecAssociations (Vector<Association<String, Integer>> v,int i, int j){
        Association temp = v.get(i);
        v.set(i,v.elementAt(j));
        v.set(j,temp);
    }

    public static void populateVecAssociations (Vector<Student> studentList){
        String address;

        for (int i = 0; i<studentList.size();i++){
            //substring of size 5 in order to get the name of the building because no one lives in the same
            //address, rather the same building.

            address = studentList.get(i).getAddress().substring(0,5);
            boolean keyExists = false;

            if(!address.equals("UNKNO")){
                for(int j=0;j<addressList.size(); j++) {
                    Association<String, Integer> value = addressList.get(j);

                    if (value.getKey().equals(address)) {
                        keyExists = true;
                        value.setValue(value.getValue() + 1);
                        break;
                    }
                }
                if (!keyExists && !address.equals("UNKNO")) {
                    Association<String, Integer> newEntry = new Association<String, Integer>(address, 1);
                    addressList.add(newEntry);
                }
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

    public Student binarySearch(Vector<Student> s, String search){
        int low= 0;
        int high= s.size()-1;
        String studentAddress;

        while(high>=low){
            int mid = (low+high)/2;
            studentAddress= s.get(mid).getAddress().substring(0,5);
            if(studentAddress.equals(search)){
                return s.get(mid);
            }
            else if(studentAddress.compareTo(search)<0){
                high = mid-1;
            } else{
                high= mid + 1;
            }
        }return null;
    }
    public static void populatePhoneAssociations(Vector<Student> s ){

        long areaCode;

        for(int i = 0; i<s.size();i++){
            boolean flag = false;
            areaCode = s.get(i).getHomePhone();
            String strLong = Long.toString(areaCode);

            if(strLong.length()>2){
            strLong.substring(0,3);
            for(int j = 0; j <s.size();j++){
                Association<String, Integer> value = phoneList.get(j);
                if(value.getKey().equals(strLong)){
                    flag = true;
                    value.setValue(value.getValue()+1);
                    break;
                }
            }
                if(!flag && strLong.length()>2){
                    Association<String, Integer> newEntry =
                            new Association<String, Integer>(strLong,1);
                    phoneList.add(newEntry);
                }
            }

        }
    }
}