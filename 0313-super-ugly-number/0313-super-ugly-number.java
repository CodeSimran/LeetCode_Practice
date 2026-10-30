class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] superUglyNumbers = new long[n];
        superUglyNumbers[0] = 1;
        int[] primePointerIndices = new int[primes.length];
        long[] nextMultipleForPrime = new long[primes.length];
        for (int i = 0; i < primes.length; i++) {
            nextMultipleForPrime[i] = primes[i];
        }
        for (int i = 1; i < n; i++) {
            long minNextUglyNumber = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (nextMultipleForPrime[j] < minNextUglyNumber) {
                    minNextUglyNumber = nextMultipleForPrime[j];
                }
            }
            superUglyNumbers[i] = minNextUglyNumber;
            for (int j = 0; j < primes.length; j++) {
                if (nextMultipleForPrime[j] == minNextUglyNumber) {
                    primePointerIndices[j]++;
                    nextMultipleForPrime[j] = superUglyNumbers[primePointerIndices[j]] * primes[j];
                }
            }
        }
        return (int) superUglyNumbers[n - 1];
    }
}