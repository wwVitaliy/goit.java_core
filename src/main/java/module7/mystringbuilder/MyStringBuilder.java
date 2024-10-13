package module7.mystringbuilder;

import java.util.Arrays;

public class MyStringBuilder {
    private static final int DEFAULT_ARRAY_SIZE = 16;
    private byte[] bytes = new byte[DEFAULT_ARRAY_SIZE];
    private int bytesFreeIndex = 0;

    @Override
    public String toString() {
        return new String(bytes).substring(0, bytesFreeIndex);
    }

    public void append(String toAppend) {
        byte[] bytesToAppend = toAppend.getBytes();
        int lengthToAppend = bytesToAppend.length;

        increaseBytesCapacity(lengthToAppend);

        for (int i = 0; i < lengthToAppend; i++) {
            bytes[bytesFreeIndex] = bytesToAppend[i];
            bytesFreeIndex++;
        }

    }

    public void clear(){
        bytes = new byte[DEFAULT_ARRAY_SIZE];
        bytesFreeIndex = 0;
    }

    private void increaseBytesCapacity(int lengthToAppend) {
        while (lengthToAppend > bytes.length - bytesFreeIndex) {
            bytes = Arrays.copyOf(bytes, bytes.length * 2);
        }
    }


}
