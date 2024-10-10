package com.test.service;

import java.io.IOException;
import java.net.*;

public class WakeOnLan {
    /**
     * main方法，发送UDP广播，实现远程开机，目标计算机的MAC地址为：28D2443568A7
     */
//    public static void send(String[] args) {
//        String ip = "192.168.1.255";//广播IP地址
//        int port = 9;//端口号
//        String mac = "1C1B0D6CA8C2";
//        //魔术包数据
//        String magicPacage = "0xFFFFFFFFFFFF" +
//                mac + mac + mac + mac +
//                mac + mac + mac + mac +
//                mac + mac + mac + mac +
//                mac + mac + mac + mac;
//        //转换为2进制的魔术包数据
//        byte[] command = hexToBinary(magicPacage);
//
//        //广播魔术包
//        try {
//            //1.获取ip地址
//            InetAddress address = InetAddress.getByName(ip);
//            //2.获取广播socket
//            MulticastSocket socket = new MulticastSocket(port);
//            //3.封装数据包
//            /*public DatagramPacket(byte[] buf,int length
//             *      ,InetAddress address
//             *      ,int port)
//             * buf：缓存的命令
//             * length：每次发送的数据字节数，该值必须小于等于buf的大小
//             * address：广播地址
//             * port：广播端口
//             */
//            DatagramPacket packet = new DatagramPacket(command, command.length, address, port);
//            //4.发送数据
//            socket.send(packet);
//            //5.关闭socket
//            socket.close();
//        } catch (UnknownHostException e) {
//            //Ip地址错误时候抛出的异常
//            e.printStackTrace();
//        } catch (IOException e) {
//            //获取socket失败时候抛出的异常
//            e.printStackTrace();
//        }
//    }

//    private static byte[] hexToBinary(String hexString){
//        //1.定义变量：用于存储转换结果的数组
//        byte[] result = new byte[hexString.length()];
//
//        //2.去除字符串中的16进制标识"0X"并将所有字母转换为大写
//        hexString = hexString.toUpperCase().replace("0X", "");
//
//        //3.开始转换
//        //3.1.定义两个临时存储数据的变量
//        char tmp1 = '0';
//        char tmp2 = '0';
//        //3.2.开始转换，将每两个十六进制数放进一个byte变量中
//        for(int i = 0; i < hexString.length(); i += 2){
//            result[i/2] = (byte)((hexToDec(tmp1)<<4)|(hexToDec(tmp2)));
//        }
//
//        Integer num = Integer.parseInt(hexString, 16);
//        System.out.println(Integer.toBinaryString(num));
//        return result;
//    }


    private static byte[] getMacBytes(String mac) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = mac.split("(\\:|\\-)");
        if (hex.length != 6) {
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }

    public static String Wake(String name, String host, String mac, int port) {
        try {
            byte[] macBytes = getMacBytes(mac);//转成字节类型
            byte[] bytes = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length); //放入16个MAC地址
            }
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
            return "wol_package_sent_success";
        } catch (Exception e) {
            return "wol_package_sent_fail";
        }
    }

    /**
     * 用于将16进制的单个字符映射到10进制的方法
     * @param c：16进制数的一个字符
     * @return：对应的十进制数
     */
    private static byte hexToDec(char c){
        return (byte)"0123456789ABCDEF".indexOf(c);
    }


    public static void main(String[] args) {
        WakeOnLan.Wake("","218.79.129.82","1C-1B-0D-6C-A8-C2",7);
    }
}