package cn.antsing.bit;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
//        int a = 9;
//        int b = 3;
//        String binaryA = Integer.toBinaryString(a);
//        String binaryB = Integer.toBinaryString(b);
//
//
//        System.out.printf("binaryA:%s\n",binaryA);
//        System.out.printf("binaryB:%s\n",binaryB);

        //测试获取某位的bit
//        int i = 81;
//        int j = 28;
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(getBit(i,j));

        System.out.println("");

        //通过bit位来比较数字大小
        int i = 83;
        int j = 82;
        byte r = compareByBit(i,j);
        System.out.println(r);

        int   MAX_VALUE = 0x7fffffff;
        System.out.println("=======================");
        System.out.println(MAX_VALUE);

        String hashValue = "cd611a31ea969b908932d44d126d195b";
        System.out.println("=============md5哈希值128位二进制或者32位十六进制================");
        System.out.println(hashValue.length());
    }

    /**
     * 获取某数指定位的二进制值
     *  说明：
     *     二进制  01111111     01111111    01111111    01111111
     *     位序    1------------------------------------------32
     * @param i  某数
     * @param j     某位
     * @return  -1:失败
     */
    public static byte getBit(int i,int j){
        byte r = 0;
        if(j>32 || j < 1){
            System.err.println("指定位数必须是[1,32]区间数");
            return -1;
        }
        r = (byte)(i>>(32-j)&0x1);

        return r;
    }

    public static byte compareByBit(int i,int j){
        byte e,f;
        for(int a=1;a<=32;a++){
            e=getBit(i,a);
            f=getBit(j,a);
            //System.out.printf("e:%d,f:%d\n",e,f);
            if(e>f){
               return 1;
            }else if(e == f){
                continue;
            }else {
                return -1;
            }
        }
        return 0;
    }
}
