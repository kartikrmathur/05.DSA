package Strings;

// for the concating two strings by +

public class concate {

    // for the print individual 

    public  static  void printing(String str){
        for (int i=0; i<=str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String firstname = "kartik";
        String lastname = "mathur";
        String fullname = firstname + "" + lastname;
        // System.out.println(fullname);


        // for the find character
        // System.out.println(fullname.charAt(1));
    

        printing(firstname);

    }
}
