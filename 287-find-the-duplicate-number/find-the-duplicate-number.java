class Solution {
    public int findDuplicate(int[] nums) {
        //hare tortoise
        //find collision point
        int slow = nums[0];
        int fast = nums[0];
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        //find circle start
        fast = nums[0];
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

