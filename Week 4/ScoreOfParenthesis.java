class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(')
                stack.push(-1);
            else{
                if(stack.peek() == -1){
                    stack.pop();
                    stack.push(1);
                }
                else{
                    int sum = 0;
                    while(stack.peek() != -1){
                        sum += stack.pop();
                    }
                    stack.pop();
                    stack.push(sum * 2);
                }
            }
        }
        
        int score = 0;
        while(!stack.isEmpty())
            score += stack.pop();
        
        return score;
    }
}