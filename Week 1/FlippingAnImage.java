class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < (A[0].length + 1) / 2; j++){
                int temp = A[i][j] ^ 1;
                A[i][j] = A[i][A[0].length - 1 - j] ^ 1;
                A[i][A[0].length - 1 - j] = temp;
            }
        
        return A;
    }
}