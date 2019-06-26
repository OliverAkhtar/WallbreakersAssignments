class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A.length <= 1)
            return A;
        
        int i = 0, j = A.length - 1, temp = 0;
        
        while(i < j){
            if(A[i] % 2 == 0)
                i++;
            else{
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j--;
            }
        }
        
        return A;
    }
}