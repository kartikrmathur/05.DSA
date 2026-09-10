// package Strings.Questions;

// // in this given route conatining 4 directions
// // (E,w,s,n) find the shortest path to reach directions.


// public class Shortespath {

//     public static float short(String path){
//         int x =0;
//         int y = 0;

//         for(int i =0;i<=path.length();i++){
//             char dir = path.charAt(i);
//         }

//         if (dir == 'S') {
//             y--;
//         }
        
//         if (dir == 'N') {
//             y++;
//         }
        
//         if (dir == 'W') {
//             x--;
//         }
        
//         else{
//             x++;
//         }
//     int x2 = x*x;
//     int y2 = y*y;
//     return (float)Math.sqrt(x2+y2);
//     }
    
//     public static void main(String[] args) {
//         String path = "ENSSEW";
//         System.out.println(short(path));
//     }
// }
package Strings.Questions;

// In this given route containing 4 directions
// (E,W,S,N) find the shortest path to reach directions.

public class ShortestPath {

    public static float shortPath(String path){
        int x = 0;
        int y = 0;

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);

            if (dir == 'S') {
                y--;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'W') {
                x--;
            } else if (dir == 'E') {
                x++;
            }
        }

        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        String path = "ENSSEW";
        System.out.println(shortPath(path));
    }
}
