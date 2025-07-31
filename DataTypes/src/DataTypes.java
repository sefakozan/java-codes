public class DataTypes {
    public static void main(String[] args) {
        binary((long) Long.MIN_VALUE);
    }

    public static void binary(Object object) {
        Class<?> type = null;

        if (object != null) {
            type = object.getClass();
        }

        byte size = 0;
        String binaryStr = "";

        if (type == Byte.class) {
            size = Byte.SIZE;
            binaryStr = Long.toBinaryString((byte) object); // obj, 64 bitlik yerde binary'den stringe çevrildi
        }
        else if (type == Short.class) {
            size = Short.SIZE;
            binaryStr = Long.toBinaryString((short) object);
        }
        else if (type == Integer.class) {
            size = Integer.SIZE;
            binaryStr = Long.toBinaryString((int) object);
        }
        else if (type == Long.class) {
            size = Long.SIZE;
            binaryStr = Long.toBinaryString((long) object);
        }
        else if (type == Float.class) {
            size = Float.SIZE;
            int bits = Float.floatToIntBits((float) object);
            binaryStr = Long.toBinaryString(bits);
        }
        else if (type == Double.class) {
            size = Double.SIZE;
            long bits = Double.doubleToLongBits((double) object);
            binaryStr = Long.toBinaryString(bits);
        }
        else if (type == Character.class) {
            size = Character.SIZE;
            binaryStr = Long.toBinaryString((char) object);
        }
        else if (type == Boolean.class) {
            size = 1;
            int bits = (boolean) object ? 1 : 0;
            binaryStr = Long.toBinaryString(bits);
        }
        else {
            // null ve non-primitive
            int reference = System.identityHashCode(object);
            size = Integer.SIZE;
            binaryStr = Long.toBinaryString(reference);
        }
        // binaryStr stringin sonundan size'ı kadar stringi keser
        String binaryLastStr = binaryStr.substring(Math.max(0, binaryStr.length() - size));
        // "%8s" gibi ifadeyi yazar
        String formatStr = String.format("%%%ds", size); // printf ile aynı ama ekrana yazdırmayıp geriye dönderir

        String fullBinaryByte = String.format(formatStr, binaryLastStr);
        String bitStr = fullBinaryByte.replace(' ', '0');

        System.out.println(bitStr);
    }
}