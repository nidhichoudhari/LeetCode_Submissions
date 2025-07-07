class Solution {
    //Optimal solution : TUsing Prefix sum + HashMap,
    //Hashmap will store key as prefix sum, and value as its frequency in the array
    //TC: O(n), SC: O(n)
    public int subarraySum(int[] nums, int k) {
        int sum = 0, n = nums.length, cnt=0;
        HashMap<Integer, Integer> preSumFreq = new HashMap<>(); //key -> prefix sum, value its frequency
        //We are adding this bcz sum of empty subarrya can lead to 0, 
        //bcz sum == k can start from index 0.
        preSumFreq.put(0,1); 
        for(int i=0;i<n;i++){
           sum+=nums[i];
           //we will check if that prefix sum has occured still at that index i, 
           //if yes we will add that freq in our cnt
           if(preSumFreq.containsKey(sum - k)){
            cnt += preSumFreq.get(sum - k);
           }
           //Update the frequency of sum in map
           preSumFreq.put(sum, preSumFreq.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}