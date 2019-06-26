class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        
        for(int i = 0; i < s.length(); i++)
            num += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 'A' + 1);
        
        return num;
    }
}