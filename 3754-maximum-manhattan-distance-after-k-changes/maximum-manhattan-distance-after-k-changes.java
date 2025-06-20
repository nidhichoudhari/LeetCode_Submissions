class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int netY = 0, netX = 0; 
        int dist = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N': netY++; break;
                case 'S': netY--; break;
                case 'E': netX++; break;
                case 'W': netX--; break;
            }

            int d = Math.abs(netY) + Math.abs(netX) + 2 * k;
            dist = Math.max(dist, Math.min(d, i + 1));
        }

        return dist;
    }
}