class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;

            if (freq[index] > maxFreq) {
                maxFreq = freq[index];
            }

            if (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return n - left;
    }
}