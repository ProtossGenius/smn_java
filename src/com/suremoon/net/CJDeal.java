package com.suremoon.net;

import java.io.UnsupportedEncodingException;

/**
 * Created by popp on 2016/9/23.
 */
public class CJDeal {//
    public static  String toCString(String str){
        return str + "\0";
    }
    public static String getJString(byte[] inp) throws UnsupportedEncodingException {
        int length = CStringLen(inp);
        String tmp = new String(inp, "GB2312");
        if(tmp.length() > 1)tmp = tmp.substring(0, length);
        return tmp;
    }
    public static int CStringLen(byte[] inp){
        int res = 0;
        for(; res < inp.length && inp[res] != 0; ++res);
        return res;
    }
    public static byte[] String2CBytes(String str) throws UnsupportedEncodingException {
        return toCString(str).getBytes("GB2312");
    }
    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[0] = (byte) (res & 0xff);// 最低位
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[2]= (byte) ((res >> 16) & 0xff);// 次高位
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }
    public static byte[] ByteArrayConnect(byte[]... arrays){
        int length = 0;
        for(int i = 0; i < arrays.length; ++i){
            length += arrays[i].length;
        }
        byte[] res = new byte[length];
        int ptr = 0;
        for(int i = 0; i < arrays.length; ++i){
            for(int j = 0; j < arrays[i].length; ++j){
                res[ptr++] = arrays[i][j];
            }
        }
        return res;
    }
    public static int byte2int(byte[] arr) {
// 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
        int targets = (arr[0] & 0xff) | ((arr[1] << 8) & 0xff00) // | 表示安位或
                | ((arr[2] << 24) >>> 8) | (arr[3] << 24);
        return targets;
    }

    public static byte[] double2bytes(double d) {
        long value = Double.doubleToRawLongBits(d);
        return long2bytes(value);
    }
    public static double bytes2double(byte[] arr) {
        return Double.longBitsToDouble(bytes2long(arr));
    }

    public static byte[] long2bytes(Long value) {
        byte[] byteRet = new byte[8];
        for (int i = 0; i < 8; i++) {
            byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
        }
        return byteRet;
    }

    public static Long bytes2long(byte[] arr) {
        long value = 0;
        for (int i = 0; i < 8; i++) {
            value |= ((long) (arr[i] & 0xff)) << (8 * i);
        }
        return value;
    }

}
