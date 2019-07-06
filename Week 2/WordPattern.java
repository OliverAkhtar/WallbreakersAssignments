class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() != str.split(" ").length)
            return false;
        
        String[] patternMap = new String[26];
        Map<String, Character> strMap = new HashMap<String, Character>();
        
        String[] words = str.split(" ");
        for(int i = 0; i < pattern.length(); i++){
            char patternChar = pattern.charAt(i);
            if(patternMap[patternChar - 'a'] == null && !strMap.containsKey(words[i])){
                patternMap[patternChar - 'a'] = words[i];
                strMap.put(words[i], patternChar);
            }
            else if(!words[i].equals(patternMap[patternChar - 'a']) || !strMap.get(words[i]).equals(patternChar))
                return false;
        }
        
        return true;
    }
}