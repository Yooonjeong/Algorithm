class Solution {
    public int solution(int[][] sizes) {
        int x=0, y=0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]>sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            x = Math.max(x, sizes[i][0]);
            y = Math.max(y, sizes[i][1]);
        }
        return x*y;
    }
}