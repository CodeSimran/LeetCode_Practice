class Solution {

    public int[] singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] arr = new int[2];
        int j = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int val = entry.getValue();

            if(val == 1) {
                arr[j] = entry.getKey();
                j++;
            }
        }

        return arr;
    }
}