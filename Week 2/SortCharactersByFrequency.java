class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < s.length(); i++){
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), freq);
            if(freq > maxFreq)
                maxFreq = freq;
        }
        
        List<Character>[] buckets = new List[maxFreq + 1];
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new ArrayList<>();
            buckets[entry.getValue()].add(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1; i > 0; i--)
            if(buckets[i] != null)
                for(Character c : buckets[i])
                    for(int j = 0; j < i; j++)
                        sb.append(c);
        
        return sb.toString();
    }
}