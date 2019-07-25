class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        
        for(int num : nums){
            int numOfSubsets = subsets.size();
            for(int i = 0; i < numOfSubsets; i++){
                List<Integer> newSubset = new ArrayList<Integer>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }
        
        return subsets;
    }
}