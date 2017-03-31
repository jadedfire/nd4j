package org.nd4j.linalg.api.ndarray;

import lombok.extern.slf4j.Slf4j;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.buffer.DoubleBuffer;
import org.nd4j.linalg.api.buffer.FloatBuffer;
import org.nd4j.linalg.api.buffer.IntBuffer;
import org.nd4j.linalg.factory.Nd4j;

/**
 * @author Audrey Loeffel
 */
@Slf4j
public abstract class BaseSparseNDArray implements ISparseNDArray {

    protected static final double THRESHOLD_MEMORY_ALLOCATION = 0.5;
    protected transient volatile long nnz = -1;
    protected int nbRows, nbColumns;
    protected Boolean isVector = null;
    protected Boolean isMatrix = null;
    protected Boolean isScalar = null;

    protected DataBuffer reallocate(DataBuffer buffer) {
        System.out.print("initial size: " + buffer.length());
        int newSize = (int) buffer.length() * 2; // should be bound to max(nnz, size*2)
        DataBuffer newBuffer = Nd4j.createBuffer(newSize);

        switch(buffer.dataType()){
            case INT:
                newBuffer.setData(buffer.asInt());
                break;
            case DOUBLE:
                newBuffer.setData(buffer.asDouble());
                break;
            case FLOAT:
                newBuffer.setData(buffer.asFloat());
                break;
            case HALF:
                // ??
                break;
            case COMPRESSED:
                // ??
                break;
            default:
                break;
        }
        System.out.print("new size: " + newBuffer.length());
        return newBuffer;
    }
}
