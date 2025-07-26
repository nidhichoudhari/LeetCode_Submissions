class Solution {
    public String minWindow(String s, String t) {
        int[] fre = new int[256];         // Frequency map for all ASCII characters
        for (char c : t.toCharArray()) {
            fre[c]++;                     // Count chars in t
        }

        int left = 0;                     // Left pointer of sliding window
        int count = 0;                    // Characters matched from t
        int min = Integer.MAX_VALUE;      // Minimum window length
        int start = 0;                    // Start index of the result window

        char[] chs = s.toCharArray();

        for (int right = 0; right < chs.length; right++) {
            char c = chs[right];

            if (fre[c] > 0) count++;      // Only increase count if char is needed
            fre[c]--;                     // Decrease frequency whether needed or not

            // When we have all required characters
            while (count == t.length()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                char lc = chs[left];      // Left char
                fre[lc]++;                // Restore frequency

                // If restoring brings a needed char back (i.e., count drops)
                if (fre[lc] > 0) {
                    count--;
                }
                left++;                   // Shrink window
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}