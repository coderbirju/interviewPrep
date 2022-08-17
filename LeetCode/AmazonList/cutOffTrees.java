class treeData {
    public int x;
    public int y;
    public int height;
    public treeData(int x, int y, int height){
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        /*
            sort the forest by height
            call bfs minSteps on the position of the smallest tree from 0,0
            in bfs minSteps find the nearest path to the smallest tree and return it, if there's no path return -1
            keep adding the minSteps till all the trees are visited
        */
        PriorityQueue<treeData> pq = new PriorityQueue<>((treeData a, treeData b) -> a.height - b.height);
        int n = forest.size();
        int m = forest.get(0).size();
        if(n == 0 || m == 0){
            return -1;
        }
        
        // boolean[],[] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(forest.get(i).get(j) > 1){
                    treeData tree = new treeData(i,j,forest.get(i).get(j));
                    pq.offer(tree);
                }
                
            }
        }
        
        int stepCount = 0;
        int curX = 0;
        int curY = 0;
        while(!pq.isEmpty()){
            treeData cur = pq.poll();
            int stepsRequired = findMinSteps(curX,curY,cur.x,cur.y,forest);
            if(stepsRequired == -1)
                return -1;
            stepCount += stepsRequired;
            
            curX = cur.x;
            curY = cur.y; 
            forest.get(curX).set(curY, 1);
        }
        return stepCount;
    }
    
    private int findMinSteps(int curX,int curY,int desX,int desY,List<List<Integer>> forest){
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minSteps = 0;
        int rows = forest.size();
        int cols = forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{curX,curY});
        visited[curX][curY] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = q.poll();
                if(curPos[0] == desX && curPos[1] == desY)
                    return minSteps;
                for(int[] dir: directions){
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];
                    if(isWithinBounds(nextX, nextY, rows, cols) && !visited[nextX][nextY] && forest.get(nextX).get(nextY) != 0){
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX,nextY});
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }
    
    private boolean isWithinBounds(int x, int y, int n, int m){
        return (x>=0 && x < n && y>=0 && y<m);
    }
}