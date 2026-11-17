
class Solution {
    public int compress(char[] chars) {

        int read = 0;
        int write = 0;

        while (read < chars.length) {

            char current = chars[read];
            int count = 0;

            // Count consecutive repeating characters
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write count only if greater than 1
            if (count > 1) {
                String num = String.valueOf(count);

                for (int i = 0; i < num.length(); i++) {
                    chars[write++] = num.charAt(i);
                }
            }
        }

        return write;
    }
}
