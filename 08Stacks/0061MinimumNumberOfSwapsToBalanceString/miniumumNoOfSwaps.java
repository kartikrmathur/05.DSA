import java.util.Stack;

// Approach 1: With Stack
class MinSwapsStack {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty() || stack.peek() == ']'){
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        int totalBrackets = stack.size();
        int closedBrackets = totalBrackets/2;
        return (closedBrackets+1)/2;
    }
}

// Approach 2: Without Stack
class MinSwapsNoStack {
    public int minSwaps(String s) {
        int open=0, close=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '[') {
                open++;
            } else {
                if(open<=0){
                    close++;
                } else {
                    open--;
                }
            }
        }
        return (close+1)/2;
    }
}
