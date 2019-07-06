class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(String s : banned)
            bannedSet.add(s);
        
        String[] words = paragraph.split("[ !?',;.]+");
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        int maxFreq = 0;
        for(String w : words){
            String word = w.toLowerCase();
            if(!bannedSet.contains(word)){
                int freq = map.getOrDefault(word, 0) + 1;
                map.put(word, freq);
                if(freq > maxFreq){
                    answer = word;
                    maxFreq = freq;
                }
            }
        }
        
        
        return answer;
    }
}