import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
    static public int fib(int n) {
        if (n < 2) return n;          // base cases

        List<Integer> dp = new ArrayList<>();
        dp.add(0);                    // dp[0] = 0
        dp.add(1);                    // dp[1] = 1

//        solve smaller subproblems first, then build up to bigger ones
        for (int i = 2; i <= n; i++) {
            dp.add(dp.get(i - 1) + dp.get(i - 2));  // recurrence
        }

        return dp.get(n);             // same as dp[-1] in Python
    }


    static void main(String[] args) {
        System.out.println(fib(10));
    }
}