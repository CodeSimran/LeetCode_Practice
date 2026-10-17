class Solution {
    public int numPermsDISequence(String s) {
        return (int) (Arrays.stream(IntStream.range(0, s.length()).boxed().reduce(new int[]{1}, (dp, i) -> IntStream.range(0, dp.length + 1).map(j -> (int) (IntStream.range(s.charAt(i) == 'D' ? j : 0, s.charAt(i) == 'D' ? dp.length : j).mapToLong(k -> dp[k]).sum() % 1000000007)).toArray(), (a, b) -> a)).asLongStream().sum() % 1000000007);
    }
}