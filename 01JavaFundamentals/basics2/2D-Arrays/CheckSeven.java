public class CheckSeven {
     public static int find(int array[][], int key) {
       int counter = 0;
       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array[i].length; j++) {
               if (array[i][j] == key) {
                   counter++;
               }
           }
       }
       return counter;
   }

   public static void main(String[] args) {
       int array[][] = {{4, 7, 8},
                        {8, 8, 7}};
       int key = 7;
       int result = find(array, key);
       System.out.println("The number " + key + " appears " + result + " times in the array.");
   }
}
