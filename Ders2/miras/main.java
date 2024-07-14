public class main{

    public static void main(String[] args){
        System.out.println("test");
    }


}

class Parent{
    String name;
    String surname;

    public Parent(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String GetFullName(){
        return this.name + " " + this.surname ;
    }

    public void introduce(){
        System.out.println( this.GetFullName());
    }
}