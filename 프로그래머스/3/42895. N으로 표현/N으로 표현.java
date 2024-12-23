import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number){
            return 1;
        }
        List<Set<Integer>> setList = new ArrayList<>();
        int n = N;
        setList.add(new HashSet<>());
        for(int i=1; i<=8; i++){
            setList.add(new HashSet<>());
            setList.get(i).add(n);
            n = n*10 + N;
        }
        for(int i=2; i<=8; i++){
            for(int j=1; j<i; j++){
                int k = i-j;
                for(int fst:setList.get(j)){
                    for(int sec:setList.get(k)){
                        setList.get(i).add(fst+sec);
                        setList.get(i).add(fst-sec);
                        setList.get(i).add(fst*sec);
                        if(fst!=0 && sec!=0){
                            setList.get(i).add(fst/sec);
                        }
                    }
                }
            }
            if(setList.get(i).contains(number)){
                return i;
            }
        }

        return -1;
    }
}