class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
                          "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb;
        HashSet<String> set = new HashSet<String>();
        
        for(int i = 0; i < words.length; i++){
            sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++)
                sb.append(codes[words[i].charAt(j) - 'a']);
            set.add(sb.toString());
        }
        
        return set.size();
    }
}