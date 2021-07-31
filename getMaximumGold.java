class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                maxGold = Math.max(maxGold, findMaxGold(grid, m, n, r, c));
        return maxGold;
    }
    //int[] DIR = new int[]{0, 1, 0, -1, 0};
        // create a array of arrays, where the first entry in the array is the x moves, and the second the y.
    int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int findMaxGold(int[][] grid, int m, int n, int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0) return 0;
        int origin = grid[r][c];
        grid[r][c] = 0; // mark as visited
        int maxGold = 0;
        //for (int i = 0; i < 4; i++)
            //maxGold = Math.max(maxGold, findMaxGold(grid, m, n, DIR[i] + r, DIR[i+1] + c));
        for (int[] move : moves) {
            // loop through the array and add the contents of the array to whatever row/col you're at. 
            maxGold = Math.max(maxGold, findMaxGold(grid,m,n, r + move[0], c + move[1]));
        }
        grid[r][c] = origin; // backtrack
        return maxGold + origin;
    }
}
