class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        
        DisjointUnion du = new DisjointUnion(m * n);
        
        for(int r = 0; r < m; r++)
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    if(c + 1 < n && grid[r][c + 1] == '1')
                        du.union(r * n + c, r * n + (c + 1));
                    if(r + 1 < m && grid[r + 1][c] == '1')
                        du.union(r * n + c, (r + 1) * n + c);
                    if(c - 1 > -1 && grid[r][c - 1] == '1')
                        du.union(r * n + c, r * n + c - 1);
                    if(r - 1 > -1 && grid[r - 1][c] == '1')
                        du.union(r * n + c, (r - 1) * n + c);
                }
            }
        
        int[] freqMap = new int[m * n];
        int islandCount = 0;
        for(int r = 0; r < m; r++)
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    int root = du.root(r * n + c);
                    if(freqMap[root] == 0)
                        islandCount++;
                    freqMap[root]++;
                }
            }
        
        return islandCount;
    }
}

class DisjointUnion {
    int[] parent;
    int[] rank;
    
    public DisjointUnion(int n){
        parent = new int[n];
        rank = new int[n];
        initializeSet();
    }
    
    private void initializeSet(){
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
    }
    
    public int root(int i){
        while(parent[i] != i)
            i = parent[i];
        
        return parent[i];
    }
    
    public void union(int a, int b){
        int rootOfA = root(a), rootOfB = root(b);
        
        if(rootOfA == rootOfB)
            return;
        
        if(rank[rootOfA] < rank[rootOfB])
            parent[rootOfA] = rootOfB;
        else if(rank[rootOfA] > rank[rootOfB])
            parent[rootOfB] = rootOfA;
        else{
            parent[rootOfA] = rootOfB;
            rank[rootOfB]++;
        }
    }
    
}