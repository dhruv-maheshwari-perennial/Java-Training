package Basic_IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Basic_NIO_03 {
    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data2.dat");
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-5);

            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos +Integer.BYTES +outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data2.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Int 3: " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Int 2: " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Int 1: " + readBuffer.getInt());

            // copy content from one file to another
            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred: " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98).put(outputBytes2).putInt(100);
//            buffer.flip();


//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//
//            System.out.println("Input String: " + new String(inputString));
//            System.out.println("int 1: " + readBuffer.getInt());
//            System.out.println("int 2: " + readBuffer.getInt());
//
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//
//            System.out.println("Input String: " + new String(inputString2));
//            System.out.println("int 3: " + readBuffer.getInt());


//    byte[] outputString = "Hello World!".getBytes();
//    long str1Pos = 0;
//    long newInt1Pos = outputString.length;
//    long newInt2Pos = newInt1Pos + Integer.BYTES;
//
//    byte[] outputString2 = "Nice to meet you".getBytes();
//    long str2Pos = newInt2Pos + Integer.BYTES;
//    long newInt3Pos = str2Pos + outputString2.length;
//
//    ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(200);
//                    intBuffer.flip();
//                    binChannel.position(newInt1Pos);
//                    binChannel.write(intBuffer);
//
//                    intBuffer.flip();
//                    intBuffer.putInt(-50);
//                    intBuffer.flip();
//                    binChannel.position(newInt2Pos);
//                    binChannel.write(intBuffer);
//
//                    intBuffer.flip();
//                    intBuffer.putInt(1000);
//                    intBuffer.flip();
//                    binChannel.position(newInt3Pos);
//                    binChannel.write(intBuffer);
//
//                    binChannel.position(str1Pos);
//                    binChannel.write(ByteBuffer.wrap(outputString));
//
//                    binChannel.position(str2Pos);
//                    binChannel.write(ByteBuffer.wrap(outputString2));