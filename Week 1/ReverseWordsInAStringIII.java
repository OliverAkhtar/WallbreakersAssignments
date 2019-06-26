class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder nextWord = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                result.append(nextWord.reverse()).append(' ');
                nextWord = new StringBuilder();
            }
            else
                nextWord.append(s.charAt(i));
        }
        
        result.append(nextWord.reverse());
        
        return result.toString();
    }
}