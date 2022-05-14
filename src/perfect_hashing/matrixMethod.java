package perfect_hashing;

public class matrixMethod {	
	int rows;
	int cols;
	int [][] matrix;
	public matrixMethod(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		matrix = new int[rows][cols];
	}
	
	public matrixMethod(int num) {
		this(32, 1);
        String binary =  Integer.toBinaryString(num);
        for(int i = 0; i < 32; i++) {
            this.set(i, 0, 0);  //initialize with zeros
        }
        for(int i = 0; i < binary.length(); i++) {
            this.set(binary.length()-i-1, 0, binary.charAt(i));
        }
	}
	
	public int get(int i,int j){
	        return matrix[i][j];
	}

	public void set(int i, int j, int element) {
		if (element == -1)
			element = 1;
	    matrix[i][j] = element;
	}
	
	public static matrixMethod multiply(matrixMethod h, matrixMethod x) {
        if(h.cols != x.rows)
            return null;
        matrixMethod resultMatrix = new matrixMethod(h.rows, x.cols);
        for(int i = 0; i < resultMatrix.rows; i++) {
            for(int j = 0; j < resultMatrix.cols; j++) {
                int temp = 0;
                for(int k = 0; k < h.cols; k++) {
                    temp = temp ^ (h.get(i, k) & x.get(k, j));
                }
                resultMatrix.set(i, j, temp);
            }
        }
        return resultMatrix;
    }
}
