package com.lpy.thread.demo;

import org.openjdk.jol.info.ClassLayout;

public class ClassLayOutDemo {
    //打印内存布局
    public static void main(String[] args) {
        ClassLayOutDemo classLayOutDemo = new ClassLayOutDemo();
        System.out.println(ClassLayout.parseInstance(classLayOutDemo).toPrintable());
    }

    // 指针压缩之后的对象头---96位
//    com.lpy.thread.demo.ClassLayOutDemo object internals:
//    OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//            4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//            8     4        (object header)                           05 c1 00 f8 (00000101 11000001 00000000 11111000) (-134168315)
//            12     4        (loss due to the next object alignment)
//    Instance size: 16 bytes
//    Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


    //关闭指针压缩之后的对象头 128位    添加参数
//    com.lpy.thread.demo.ClassLayOutDemo object internals:
//    OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//            4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//            8     4        (object header)                           f0 30 67 19 (11110000 00110000 01100111 00011001) (426193136)
//            12     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//    Instance size: 16 bytes
//    Space losses: 0 bytes internal + 0 bytes external = 0 bytes total



    //64位虚拟机中
//    16进制: 0X 00 00 00 00 00 00 00 01                                                  是否偏向锁      锁的标志位
//    (64位)2进制: 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000   0                01
}
