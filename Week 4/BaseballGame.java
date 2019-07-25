class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0, roundSum, lastScore;
        
        for(String s : ops){
            if(s.equals("+")){
                lastScore = stack.pop();
                roundSum = lastScore + stack.peek();
                stack.push(lastScore);
                stack.push(roundSum);
                totalSum += roundSum;
            }
            else if(s.equals("D")){
                roundSum = stack.peek() * 2;
                stack.push(roundSum);
                totalSum += roundSum;
            }
            else if(s.equals("C")){
                lastScore = stack.pop();
                totalSum -= lastScore;
            }
            else{
                roundSum = Integer.parseInt(s);
                stack.push(roundSum);
                totalSum += roundSum;
            }
        }
        
        return totalSum;
    }
}