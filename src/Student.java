/**
 * Created by Varela on 3/4/17.
 */
//instructions to proceed, create comparator methods
//name them compare name or whatever attribute we want to compare
// then use this accessor methods in order to get the information
//from the student object and then compare them and implement the
//bubble sort algs.]

public class Student{

    protected String aName;
    protected String anAddress;
    protected long aPhone;
    protected int aSuBox;
    protected long aHomePhone;

    public Student(String name, String address, long schoolPhone, int suBox, long homePhone){

        aName = name;
        anAddress = address;
        aPhone = schoolPhone;
        aSuBox = suBox;
        aHomePhone = homePhone;

    }
    public String getName(){
        return aName;
    }

    public String getAddress(){
        return anAddress;
    }

    public long getSchoolPhone(){
        return aPhone;
    }

    public int getSuBox(){
        return aSuBox;
    }

    public long getHomePhone(){
        return aHomePhone;
    }
    public String toString(){

        // NAME AND SU TEST
        //return "Name: " + this.getName() + "\nSU Box: " +
        return "" + this.getSuBox();

        // + "\nAddress: " + this.getAddress() + "\nSchool phone: " + this.getSchoolPhone() +


         //+ "\nHome phone: " + this.getHomePhone()+ ". \n";



    }
}
