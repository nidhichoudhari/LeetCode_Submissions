class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
    private int n;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        Arrays.sort(nums);
        generatePermutations(nums, new ArrayList<>());
        return result;
    }

    private void generatePermutations(int[] nums, List<Integer> current) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;

            if(i > 0 && (nums[i - 1] == nums[i]) && used[i - 1] == false) 
                continue;
            
            current.add(nums[i]);
            used[i] = true;

            generatePermutations(nums, current);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}