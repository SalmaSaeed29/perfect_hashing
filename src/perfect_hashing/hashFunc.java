package perfect_hashing;

import java.util.Random;

public class hashFunc {	
    private int rowsH;
    matrixMethod matrixH;
    
    public hashFunc(int tableSize) {
    	rowsH = (int) (Math.log(tableSize) / Math.log(2));
    	matrixH = new matrixMethod(rowsH, 32);
        Random random = new Random();
        for(int i = 0; i < rowsH; i++) {
            for(int j = 0; j < 32; j++) {
            	matrixH.set(i, j, random.nextInt()%2);
            }
        }
    }

    public int hash(int key){
    	matrixMethod matrixX = new matrixMethod(key);
    	matrixMethod HX = matrixMethod.multiply(matrixH, matrixX);
    	/* convert the resulting binary matrix into a decimal number */
        int decimal = 0;
        int radix = 1;
        for (int i = 0; i < rowsH; i++) {
            if (HX.get(i, 0) == 1) {
            	decimal += radix;
            }
            radix *= 2;
        }
        return decimal;
    }

}