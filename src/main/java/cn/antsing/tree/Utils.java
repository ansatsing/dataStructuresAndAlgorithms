package cn.antsing.tree;

public final class Utils {
    /**
     * 获取int型数据指定位的二进制值
     *  说明：
     *     二进制  01111111     01111111    01111111    01111111
     *     位序    1------------------------------------------32
     * @param num
     * @param whichBit 位序范围区间[1,32]
     * @return [0,1],-1代表获取失败
     */
    public static byte getSpecialBitValueOfInt(int num,byte whichBit){
        byte r = 0;
        if(whichBit>32 || whichBit < 1){
            System.err.println("指定位数必须是[1,32]区间数");
            return -1;
        }
        r = (byte)(num>>(32-whichBit)&0x1);

        return r;
    }

    public static void main(String[] args) {
        int a = 77;
        for(byte i=1;i<=32;i++){
            System.out.println(Utils.getSpecialBitValueOfInt(a,(byte)i));
        }

    }
}
