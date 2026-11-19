class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] psum = new int[n];
        for(int i=0;i<bookings.length;i++){
            int f = bookings[i][0];
            int l = bookings[i][1];
            int seat = bookings[i][2];
            for(int j = f-1;j<l;j++)
            {
                psum[j]+=seat;
            }
        }
        return psum;
    }
}