class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int costA = 0, i = 0;
        int N = costs.length/2;
        int[] costBArr = new int[2*N];
        for (i = 0; i < 2*N; i ++){
            costA += costs[i][0];
            costBArr[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(costBArr);
        for (i = 0; i < N; i++){
            costA += costBArr[i];
        }
        return costA;
        
    }
}
