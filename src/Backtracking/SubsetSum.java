package src.Backtracking;

public class SubsetSum {
    public static void main(String args[]){
        int weights[] = {10, 7, 5, 18, 12, 20, 15};
        int k = 35;

        solveSS(weights,k);
    }

    static void solveSS(int weights[], int k){

        boolean use[] = new boolean[weights.length];

        backtrack(weights,use,k,0);
    }

    static void backtrack(int weights[], boolean use[], int k,int n){

        if(n==7)
            return;

        use[n]=true;
        checkSum(k,use,weights);

        backtrack(weights,use,k,n+1);

        use[n] = false;
        //checkSum(k,use,weights);
        backtrack(weights,use,k,n+1);

    }

    static void checkSum(int sum, boolean use[],int weights[]){
        int s = 0;
        for(int i=0; i< use.length; i++){
            if(use[i]==true)
                s+=weights[i];
        }

        if(s==sum){
            for(int i=0;i<use.length;i++){
                if(use[i])
                    System.out.print(weights[i]+" ");
            }
            System.out.println();
        }


    }
}
