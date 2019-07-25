class Solution {
    public void rotate(int[] nums, int k) {
        reverseSubArray(nums, 0, nums.length - 1);
        reverseSubArray(nums, 0, k % nums.length - 1);
        reverseSubArray(nums, k % nums.length, nums.length - 1);
        
        return;
    }
    
    private void reverseSubArray(int[] nums, int start, int end){
        int temp = 0;
        while(start < end){
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}