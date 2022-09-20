class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 =  version1.length();
        int n2 =  version2.length();
        int p1 = 0, p2 = 0;
        int i1, i2;
        // Pair<Integer, Integer> pair;
        int[] values = new int[2];
        while (p1 < n1 || p2 < n2) {
          values = getNextChunk(version1, p1);
          i1 = values[0];
          p1 = values[1];

          values = getNextChunk(version2, p2);
          i2 = values[0];
          p2 = values[1];
          if (i1 != i2) {
            return i1 > i2 ? 1 : -1;
          }
        }
        return 0;
    } 
    
    
    public int[] getNextChunk(String s, int start){
        int[] nextChunk = new int[2];
        int n = s.length();
         if (start > n - 1) {
          return new int[]{0,start};
        }
        // find the end of chunk
        int i, end = start;
        while (end < n && s.charAt(end) != '.') {
          ++end;
        }
        
        if(end != s.length() -1){
            nextChunk[0] = Integer.parseInt(s.substring(start,end));
        } else{
            nextChunk[0] = Integer.parseInt(s.substring(start, s.length()));
        }
        start = end + 1;
        nextChunk[1] = start;
        return nextChunk;
    }
    
}