class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int x, y;
        for(y=1; y<=yellow ; y++){
            if(yellow%y==0){
                x = yellow/y;
                if(x<y) break;
                if(2*x+2*y+4 == brown){
                    answer[0] = x+2;
                    answer[1] = y+2;
                    return answer;
                }
            }
        }
        return answer;
    }
}