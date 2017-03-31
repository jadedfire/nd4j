package org.nd4j.linalg.cpu.nativecpu;

import lombok.extern.slf4j.Slf4j;
import org.nd4j.linalg.api.ndarray.*;


/**
 * @author Audrey Loeffel
 */
@Slf4j
public class SparseNDArrayCSR extends BaseSparseNDArrayCSR {

/**
 *
 *
 * The length of the values and columns arrays is equal to the number of non-zero elements in A.
 * The length of the pointerB and pointerE arrays is equal to the number of rows in A.
 * @param data a double array that contains the non-zero element of the sparse matrix A
 * @param columns Element i of the integer array columns is the number of the column in A that contains the i-th value
 *                in the values array.
 * @param pointerB Element j of this integer array gives the index of the element in the values array that is first
 *                 non-zero element in a row j of A. Note that this index is equal to pointerB(j) - pointerB(1)+1 .
 * @param pointerE An integer array that contains row indices, such that pointerE(j)-pointerB(1) is the index of the
 *                 element in the values array that is last non-zero element in a row j of A.
 * @param shape Shape of the matrix A
*/
    public SparseNDArrayCSR(double[] data, int[] columns, int[] pointerB, int[] pointerE, int[] shape) {

        super(data, columns, pointerB, pointerE, shape);
    }


}
