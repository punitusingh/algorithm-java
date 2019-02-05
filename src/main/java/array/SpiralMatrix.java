package array;

public class SpiralMatrix {

    static void matrixspiral(int n) {

        int[][] a = new int[n][n];

        int k=1;

        int firstRow=0;

        int lastRow=n-1;

        int firstColumn=0;

        int lastColumn=n-1;



        while(firstRow<=lastRow && firstColumn<=lastColumn) {

            //first row

            for(int i=firstColumn;i<=lastColumn;i++) {

                a[firstRow][i]=k++;

            }

            firstRow++;



            //last column

            for(int i=firstRow;i<=lastRow;i++) {

                a[i][lastColumn]=k++;

            }

            lastColumn--;



            //last row

            for(int i=lastColumn;i>=firstColumn;i--) {

                a[lastRow][i]=k++;

            }

            lastRow--;



            //first column

            for(int i=lastRow;i>=firstRow;i--) {

                a[i][firstColumn]=k++;

            }

            firstColumn++;

        }

        System.out.println(a);

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        matrixspiral(1);
    }

}
