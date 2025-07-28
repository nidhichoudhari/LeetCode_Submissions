class Solution {

    private int count = 0;
    private int[] nums;
    private int[] suffixOr;

    private void backtrack(int m, int start, int currentOr) {
        if (currentOr == m) {
            count++;
            // Continue searching for other subsets
        }

        for (int i = start; i < nums.length; i++) {
            int newOr = currentOr | nums[i];
            // Prune if even adding all remaining elements can't reach m
            if ((newOr | suffixOr[i]) < m) {
                continue;
            }
            backtrack(m, i + 1, newOr);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        int n = nums.length;

        int maxi = 0;
        for (int num : nums) {
            maxi |= num;
        }

        // Precompute suffix OR array
        suffixOr = new int[n];
        suffixOr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixOr[i] = suffixOr[i + 1] | nums[i];
        }

        count = 0;
        backtrack(maxi, 0, 0);
        return count;
    }
}