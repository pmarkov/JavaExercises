package com.markov;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main2 {

    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();

//            buffer.put(outputBytes).putInt(245).putInt(-98245).put(outputBytes2).putInt(1000);
//            buffer.flip();

            buffer.put(outputBytes);
            int intPos1 = outputBytes.length;
            buffer.putInt(245);
            int intPos2 = intPos1 + Integer.BYTES;
            buffer.putInt(-98245);
            buffer.put(outputBytes2);
            int intPos3 = intPos2 + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

            channel.position(intPos3);
            channel.read(readBuffer);
            System.out.println("int1 = " + readBuffer.getInt(0));
            readBuffer.flip();

            channel.position(intPos2);
            channel.read(readBuffer);
            System.out.println("int2 = " + readBuffer.getInt(0));
            readBuffer.flip();

            channel.position(intPos1);
            channel.read(readBuffer);
            System.out.println("int3 = " + readBuffer.getInt(0));
            readBuffer.flip();

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            byte[] inputBytes = new byte[outputBytes.length];
//            readBuffer.get(inputBytes);
//            System.out.println("inputString = " + new String(inputBytes));
//            System.out.println(readBuffer.getInt(intPos3));
//            readBuffer.getInt();
//            System.out.println(readBuffer.getInt(intPos2));
//            readBuffer.getInt();
//            byte[] inputBytes2 = new byte[outputBytes2.length];
//            readBuffer.get(inputBytes2);
//            System.out.println("inputString2 = " + new String(inputBytes2));
//            System.out.println(readBuffer.getInt(intPos1));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

















