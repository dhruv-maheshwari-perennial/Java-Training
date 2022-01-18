package Basic_IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Basic_NIO_02 {
    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            buffer.put(outputBytes);
            buffer.flip();
            int numBytes = binChannel.write(buffer);

            System.out.println("Number of Bytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);

            System.out.println("Number of Bytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-89);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);

            System.out.println("Number of Bytes written was: " + numBytes);

            // Reading using IO package
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//
//            System.out.println(int1);
//            System.out.println(int2);

            // Reading using Java.NIO package
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);

            if (buffer.hasArray()) {
//                System.out.println("Byte Buffer: " + new String(buffer.array()));
                System.out.println("Byte Buffer: " + new String(outputBytes));
            }

            // Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            System.out.println(intBuffer.getInt());

            // Relative Read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
            channel.close();
            ra.close();

//            System.out.println("Output Bytes: " + new String(outputBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();

// getting file path
//            Path dataPath = FileSystems.getDefault().getPath("data.txt");

// writing in file
//            Files.write(dataPath,"\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);

// reading from file
//            List<String> lines = Files.readAllLines(dataPath);

//            for (String line: lines) {
//                System.out.println(line);
//            }
