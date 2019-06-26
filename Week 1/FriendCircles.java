class Solution {
    public int findCircleNum(int[][] M) {
        if(M.length == 0)
            return 0;
        
        int n = M.length;
        
        DisjointUnion du = new DisjointUnion(n);
        
        for(int r = 0; r < n; r++)
            for(int c = r + 1; c < n; c++)
                if(M[r][c] == 1)
                    du.union(r, c);
        
       
        
        return du.count;
    }
}

class DisjointUnion {
    int[] parent;
    int[] rank;
    int count;
    
    public DisjointUnion(int n){
        parent = new int[n];
        rank = new int[n];
        count = n;
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
        
        count--;
    }
    
}