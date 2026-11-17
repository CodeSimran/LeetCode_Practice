
class Solution {
    public int compress(char[] chars) {

        int i = 0;
        int j = 0;

        while (i < chars.length) {

            char ch = chars[i];
            int count = 0;

            // Count repeating characters
            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

            // Write character
            chars[j] = ch;
            j++;

            // Write count
            if (count > 1) {

                int divisor = 1;

                // Find the highest place value
                while (count / divisor >= 10) {
                    divisor = divisor * 10;
                }

                // Write each digit
                while (divisor > 0) {

                    int digit = count / divisor;

                    chars[j] = (char)(digit + '0');
                    j++;

                    count = count % divisor;
                    divisor = divisor / 10;
                }
            }
        }

        return j;
    }
}
