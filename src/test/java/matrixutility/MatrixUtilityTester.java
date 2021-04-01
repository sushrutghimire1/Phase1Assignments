package matrixutility;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MatrixUtilityTester {


    @InjectMocks
    MatrixApplication matrixApplication = new MatrixApplication();


    @Mock
    MatrixUtils matrixUtils;

    @Test
    public void testAdd() {
        int[][] matrix1 = {{1, 3, 1}, {1, 0, 0}};
        int[][] matrix2 = {{0, 0, 5}, {7, 5, 0}};
        int[][] resultant = {{1, 3, 6}, {8, 5, 0}};
        when(matrixUtils.addMatrices(matrix1, matrix2)).thenReturn(resultant);

        Assert.assertEquals(matrixApplication.addMatrices(matrix1, matrix2), resultant);
    }
}
