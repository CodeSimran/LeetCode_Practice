class Solution {
    private int[] need;
    private int nonzero;  // number of letters with need != 0 (dict size)

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;
        need = new int[26];
        nonzero = 0;
        for (char ch : s1.toCharArray()) add(ch, 1);
        for (int i = 0; i < n2; i++) {
            add(s2.charAt(i), -1);
            if (i >= n1) add(s2.charAt(i - n1), 1);
            if (nonzero == 0) return true;
        }
        return false;
    }

    private void add(char ch, int delta) {  // O(1)
        int k = ch - 'a';
        if (need[k] != 0) nonzero--;
        need[k] += delta;
        if (need[k] != 0) nonzero++;
    }
}