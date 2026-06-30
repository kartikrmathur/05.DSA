import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ArrayRotationSolution {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        int l = 0, r = a.size() - 1;

        while (l < r) {
            int temp = a.get(l);
            a.set(l, a.get(r));
            a.set(r, temp);
            l++;
            r--;
        }

        return a;
    }

}

public class ArrayRotation {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            bufferedReader.readLine();

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> res = ArrayRotationSolution.reverseArray(arr);

            bufferedWriter.write(
                    res.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n"
            );
        }
    }
}
