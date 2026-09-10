package Tcs.Array;

// you have two dimension array in that
// you have to check if (a , b ) , (b , a)
// so give that 
// type void
// loop 1 = 0 to n
// loop 2 = ii +1 to n

// its easy 

public class SymentricPairs {
    public static void finpairs(int[][] pairs){
        int n = pairs.length;

        for(int i =0 ; i < n ; i++){
            for(int j=0; j < n ; j ++ ){
                if(pairs[i][0]==pairs[j][1] && pairs[i][1]==pairs[j][0]){
                    System.out.println("("+pairs[i][0]+","+pairs[i][1]+")");// this statemnet is unique
                }
            }
        }
    }
    public static void main(String[] args) {
         int[][] pairs = {{1, 2}, {3, 4}, {2, 1}, {5, 6}, {4, 3}, {6, 5}};
        System.out.println("Symmetric Pairs: ");
        finpairs(pairs);
        
    }
}


// this code returns the all the pairs not just one pait
// in this code just ro review for the on elone