public class Matrix
{
    private int rows;
    private int columns;
    private double[][] data;

    public Matrix(int row, int column) {
        this.rows = row;
        this.columns = column;
        data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException(
                    "column of this matrix is not equal to row "
                            + "of second matrix, cannot multiply");
        }

        double[][] product = new double[this.rows][other.columns];
        double sum = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < other.rows; k++) {
                    sum = sum + data[i][k] * other.data[k][j];
                }
                product[i][j] = sum;
            }
        }
        return new Matrix(product);
    }
}
