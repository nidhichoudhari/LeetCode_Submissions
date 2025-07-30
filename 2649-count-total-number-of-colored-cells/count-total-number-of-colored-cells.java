class Solution {
    public long coloredCells(int n) {
        long res = (long)Math.pow(n-1,2)+(long)Math.pow(n,2);
        return res;
    }
}