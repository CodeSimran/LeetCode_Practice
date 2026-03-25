class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));

        for(int[] point : points){

            maxHeap.add(point);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];

        while(k > 0){
            res[--k] = maxHeap.poll();
        }

        return res;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}