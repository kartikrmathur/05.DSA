

public class Largestofstr {
    public static void main(String[] args) {
        String Name[] = {"aarsh","hiya","het "};

        String largest = Name[0];
        
        for(int i =1; i<=Name.length;i++){
            if(largest.compareTo(Name[i])<0){
                largest=Name[i];
            }
        }
        System.out.println(largest);
    }
}
