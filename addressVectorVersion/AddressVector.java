import structure5.*;
import java.util.Scanner;

/**


*/
public class AddressVector{

    protected MyVector<Student> studentList;
    protected Vector<Association<String, Integer>> addressList = new Vector<Association<String, Integer>>(0);

    public AddressVector(MyVector<Student> students){

        studentList = students;
        createAssociations(studentList);
        int a;
        int b;

        for (int j= 0; j>0; j++) {
            boolean swapped = true;
            for (int i = 0; i < addressList.size(); i++) {
                a = addressList.get(i - 1).getValue();
                b = addressList.get(i).getValue();
                int result = a - b;
                if (result > 0) {
                    swap(i - 1, i);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        //at this point the vector of associations should be populated and sorted.
        int studentCount = addressList.getLast().getValue();
        String searchAddress = addressList.getLast().getKey();

        //sort students by address to make faster.
        //studentList.sort(question);
        System.out.println("Most popular building on campus\n" +
                            "-------------------------------\n");

        for (int i = 0; i < studentCount; i++){
            Student s = binarySearch(studentList, searchAddress);
            System.out.println(s);
        }
    }

    public void createAssociations(MyVector<Student> studentList){
        String address;

        for (int i = 0; i<studentList.size(); i++){
            //substring of size 5 in order to get the name of the building because no one lives in the same
            //address, rather the same building.

            address = studentList.get(i).getAddress().substring(0,5);
            boolean keyExists = false;

            if(!address.equals("UNKNO")){
                for(int j = 0; j < addressList.size(); j++) {
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

    public Student binarySearch(MyVector<Student> s, String search){
        int low = 0;
        int high= s.size()-1;
        String studentAddress;

        while (high >= low){
            int mid = (low+high)/2;
            studentAddress = s.get(mid).getAddress().substring(0,5);
            if (studentAddress.equals(search)){
                return s.get(mid);
            } else if (studentAddress.compareTo(search) < 0){
                high = mid-1;
            } else {
                high = mid + 1;
            }
        }
        return null;
    }


    public void swap(int i, int j){
        Association<String, Integer> temp = addressList.get(i);
        addressList.set(i,addressList.elementAt(j));
        addressList.set(j,temp);
    }
}
