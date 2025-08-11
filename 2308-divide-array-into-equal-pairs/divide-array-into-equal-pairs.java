//solution base on understnding 
class Solution {
    public boolean divideArray(int[] nums) {
        int xor = 0;
        for (int e : nums) {
            xor ^= e;
        }
        if (xor != 0) return false;

        //We can directly do this 
        int[] freq = new int[501]; 
        for (int e : nums) {
            freq[e]++;
        }
        for (int count : freq) {
            if (count % 2 != 0) return false;
        }
        return true;
    }
}