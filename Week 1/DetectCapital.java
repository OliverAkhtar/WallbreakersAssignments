class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.isEmpty())
            return true;
        
        boolean firstIsUpper = Character.isUpperCase(word.charAt(0));
        int upperCount = 0;
        
        for(int i = 0; i < word.length(); i++)
            if(Character.isUpperCase(word.charAt(i)))
                upperCount++;
        
        return upperCount == 0 || upperCount == word.length() || (firstIsUpper && upperCount == 1);
    }
}