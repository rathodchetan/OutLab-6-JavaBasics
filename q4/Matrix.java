
public class Matrix {
    private float[][] A;
    private int numberOfRows, numberOfColumns;

    public Matrix(int n, float v) {
        A = new float[n][n];
        numberOfRows = n;
        numberOfColumns = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = v;
            }
        }
    }

    public Matrix(int n, int m, float v) {
        A = new float[n][m];
        numberOfRows = n;
        numberOfColumns = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = v;
            }
        }
    }

    public Matrix(int n, int m) {
        A = new float[n][m];
        numberOfRows = n;
        numberOfColumns = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = 0;
            }
        }
    }

    public Matrix(int n) {
        A = new float[n][n];
        numberOfRows = n;
        numberOfColumns = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = 0;
            }
        }
    }

    public Matrix add(Matrix x) {
        Matrix z = new Matrix(numberOfRows, numberOfColumns);
        float value;

        if (numberOfRows == x.getrows() && numberOfColumns == x.getcols()) {
            for (int i = 0; i < x.getrows(); i++) {
                for (int j = 0; j < x.getcols(); j++) {
                    value = A[i][j] + x.getelem(i, j);
                    z.setelem(i, j, value);
                }
            }
            return z;
        } else {
            System.out.println("Matrices cannot be added");
            Matrix y = new Matrix(1, 1, 0);
            return y;
        }
    }

    public Matrix matmul(Matrix x) {
        Matrix z = new Matrix(numberOfRows, x.getcols());
        float value;

        if (numberOfColumns == x.getrows()) {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < x.getcols(); j++) {
                    float sum = 0;
                    for (int k = 0; k < x.getrows(); k++) {
                        sum += A[i][k] * x.getelem(k, j);
                    }
                    value = sum;
                    z.setelem(i, j, value);
                }
            }
            return z;
        } else {
            System.out.println("Matrices cannot be multiplied");
            Matrix y = new Matrix(1, 1, 0);
            return y;
        }
    }

    public void scalarmul(int s) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                A[i][j] *= s;
            }
        }
    }

    public int getrows() {
        return numberOfRows;
    }

    public int getcols() {
        return numberOfColumns;
    }

    public float getelem(int i, int j) {
        if (i >= numberOfRows || j >= numberOfColumns) {
            System.out.println("Index out of bound");
            return -100;
        }
        return A[i][j];
    }

    public void setelem(int i, int j, float v) {
        if (i >= numberOfRows || j >= numberOfColumns) {
            System.out.println("Index out of bound");
            return;
        }
        A[i][j] = v;
    }

    public void printmatrix() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
