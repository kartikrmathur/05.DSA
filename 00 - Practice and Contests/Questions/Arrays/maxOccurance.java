package Questions.Arrays;

public class maxOccurance {
    


    public static int maximum(int num[], int target){ 
        int occurance = 0;

        for(int i =0; i<num.length ;i++){
           if (num[i]==target) {
            occurance ++;
           } 
        }
        return occurance;
    }
    public static void main(String[] args) {
        int num[]= {1,2,3,2,1,2,2,2,2};
        int target = 2;
        int checkmaxoccur = maximum(num, target);
        System.out.println(checkmaxoccur);
    }
}
