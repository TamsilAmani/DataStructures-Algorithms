package src.Backtracking;

public class Pillar {
    static boolean use[];
    static int MAX = 0;
    static int length;

    public static void main(String args[]){
        int input[] = {1,1,2,3,3};
        length = input.length;
        use = new boolean[length];
        solvePillar(input);
    }

    static void solvePillar(int input[]){


        int temp[] = new int[length];

        long start = System.currentTimeMillis();

        backtrack(input,temp,  0);

        long stop= System.currentTimeMillis();


        System.out.println(MAX);


        System.out.println(stop-start);
    }

    static void backtrack(int input[], int temp[],  int n){
        if(n==length)
            return;

        use[n]=true;
        validate(input);
        backtrack(input,temp, n+1);

        use[n] = false;
        backtrack(input,temp, n+1);
    }


    static void validate(int input[]) {

        int x = 0, y = 0;

        for (int i = 0; i < length; i++) {
            if (use[i]) {
                x += input[i];
            }
        }


        for (int j = input.length - 1; j >= 0; j--) {
            if (!use[j]) {
                y += input[j];

                if (x == y && x > MAX) {
                    MAX = x;
                    /*System.out.println("x= \n");
                    for (int i = 0; i < length; i++) {
                        if (use[i]) {
                            System.out.print(input[i] + " ");
                        }
                    }
                    System.out.println();*/

                }

                if(y>x) break;
            }
        }
    }

}
