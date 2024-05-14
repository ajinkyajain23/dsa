class Solution {
  public:
    int MinimumEffort(int rows, int columns, vector<vector<int>>& heights) {
    auto cmp = [](const vector<int>& a, const vector<int>& b) {
        return a[0] > b[0]; // priority_queue in C++ is a max heap, so we invert the comparison
    };
    priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
    
    vector<vector<int>> dist(rows, vector<int>(columns, INT_MAX));
    
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    dist[0][0] = 0;
    pq.push({0, 0, 0});
        
    while (!pq.empty()) {
        auto cell = pq.top();
        pq.pop();
        int diff = cell[0];
        int r = cell[1];
        int c = cell[2];
        
        if (r == rows - 1 && c == columns - 1) {
            return diff;
        }
        
        for (int i = 0; i < 4; ++i) {
            int nx = dx[i] + r;
            int ny = dy[i] + c;
            if (nx >= 0 && nx < rows && ny >= 0 && ny < columns) {
                int d = max(diff, abs(heights[nx][ny] - heights[r][c]));
                if (d < dist[nx][ny]) {
                    dist[nx][ny] = d;
                    pq.push({d, nx, ny});
                }
            }
        }
    }
    
    return -1;
}
};
