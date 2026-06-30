import java.util.Scanner;

class StringsStart {

    // different of strings and arrays
    char arr[] = {'a','b','c'};

    // way to define strings
    String str = "abcd";
    String str2 = new String("xyz");

    // java string is immutable
    // java is primitive data type

    public static void main(String[] args) {
        // string in-op
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine();
        System.out.println(name);
    }
}
