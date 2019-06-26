class Solution {
    public String reverseVowels(String s) {
        char[] result = s.toCharArray();
        HashSet<Character> h = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if(!h.contains(result[i]))
                i++;
            else if(!h.contains(result[j]))
                j--;
            else{
                char temp = result[i];
                result[i++] = result[j];
                result[j--] = temp;
            }
        }
        
        return new String(result);
    }
}