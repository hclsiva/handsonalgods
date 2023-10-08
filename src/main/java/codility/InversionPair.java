package codility;

public class InversionPair {
    public int solution(int[] A) {
        int i = 0, j =1, pairCount=0;
        while(i < j){
            if(i < j && A[j] < A[i]) {
                pairCount++;
            }
            if(j>= A.length-1){
                i++;
                j= i+1;
            }else{
                j++;
            }
        }
        return pairCount;
    }
}
