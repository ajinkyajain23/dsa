class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[][] dist = new int[rows][columns];
        for(int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        dist[0][0] = 0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int pd = cell[0];
            int x = cell[1];
            int y = cell[2];
            
            if(x == rows - 1 && y == columns - 1){
                return pd;
            }
            
            for(int i = 0; i < 4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < columns){
                    int ndf = Math.max(Math.abs(heights[nx][ny] - heights[x][y]), pd);
                    if(ndf < dist[nx][ny]){
                        dist[nx][ny] = ndf;
                        pq.add(new int[]{ndf, nx, ny});
                    }
                }
            }
            
        }
        return -1;
    }
}
