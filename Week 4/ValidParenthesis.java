class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        
        for(char c : s.toCharArray()){
            if(hashMap.containsKey(c)){
                if(stack.empty() || stack.pop() != hashMap.get(c))
                    return false;
            }
            else
                stack.push(c);
        }
        
        return stack.empty();
    }
}