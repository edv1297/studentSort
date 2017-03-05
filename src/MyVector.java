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
            System.out.println(student);
        }
    }

    public MyVector(){
        super();
    }

    public void sort(Comparator<E> c){


    }


}
