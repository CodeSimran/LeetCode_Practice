
class Solution {
    public int compress(char[] chars) {

        int read = 0;
        int write = 0;

        while (read < chars.length) {

            char current = chars[read];
            int count = 0;

            // Count consecutive characters
            while (read < chars.length && chars[read] == current) {
                count++;
                read++;
            }

            // Write the character
            chars[write] = current;
            write++;

            // Write count if greater than 1
            if (count > 1) {

                // Store digits temporarily
                int temp = count;
                int digits = 0;

                while (temp > 0) {
                    digits++;
                    temp = temp / 10;
                }

                // Write digits from left to right
                int divisor = 1;

                for (int i = 1; i < digits; i++) {
                    divisor = divisor * 10;
                }

                while (divisor > 0) {
                    int digit = count / divisor;
                    chars[write] = (char) (digit + '0');
                    write++;

                    count = count % divisor;
                    divisor = divisor / 10;
                }
            }
        }

        return write;
    }
}
