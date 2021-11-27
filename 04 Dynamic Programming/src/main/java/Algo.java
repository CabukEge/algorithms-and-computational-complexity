public class Algo {
    static public void main(String[] args) {
        Test();
    }
    static public void Test(){
        int sxn = 0;
        int a[] = {6, 4, 4, 6}; //Random set of integers
        for (int x:a) {
            sxn += x; //The sum of all a[i]
        }
        if(sxn % 2 == 0) {
            int sHalf = sxn/2; // Half of sxn
            int n = a.length - 1; // n number of a[i]
            int iSet[][] = new int[sHalf+1][n+1]; // Index i ist die Summe aller a[i] für Iteration S!

            for (int i = 0; i <= n; i++) {
                for (int sHalfInIteration = 0; sHalfInIteration <= sHalf; sHalfInIteration++) {
                    iSet[sHalfInIteration][i] = 0;
                    if (a[i] == sHalfInIteration) {
                        iSet[sHalfInIteration][i] = a[i];
                    } else if (a[i] > sHalfInIteration && i > 1) {
                        iSet[sHalfInIteration][i] = iSet[sHalfInIteration][i - 1];
                    } else if (a[i] < sHalfInIteration && i > 1) {
                        int SlessA = sHalfInIteration - a[i];
                        int solA = iSet[SlessA][i] + a[i]; //Two Solutions
                        int solB = iSet[sHalfInIteration][i - 1] + iSet[sHalfInIteration - iSet[sHalfInIteration][i - 1]][i - 1];
                        if (solA >= solB) { //Which solution is better?
                            iSet[sHalfInIteration][i] = solA;
                        } else {
                            iSet[sHalfInIteration][i] = solB;
                        }
                    }
                }
            }
            if( iSet[sHalf][n] == sHalf){
                System.out.println(iSet[sHalf][n]);
                System.out.println(true);
            }
            else {
                System.out.println(false);
            }
        }
        else
        {
            System.out.println(false);
        }
    }


}