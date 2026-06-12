package com.meinprojekt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        File from = new File("/home/mika/Pictures/Poke/red_retro_grey.png");
        File to = new File("/home/mika/Pictures/Poke/red_retro_grey_copy.png");
        File quelle = new File("/home/mika/Documents/Uni/Pk1/Übung/Blatt5/src/main/java/com/meinprojekt/App.java");

        copy(from, to);
        cat(quelle);
    }

    static void copy(File from, File to) throws NullPointerException {
        if (from == null || to == null)
            throw new NumberFormatException();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            int c;
            while ((c = fis.read()) != -1)
                fos.write(c);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (fis != null)
                    fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                if (fos != null)
                    fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void cat(File quelle) throws NullPointerException {

        if (quelle == null)
            throw new NumberFormatException();

        try (RandomAccessFile raf = new RandomAccessFile(quelle, "rw");) {

            OutputStreamWriter is = new OutputStreamWriter(System.out);

            for (int c = raf.read(); c != -1; c = raf.read()) {
                is.write(c);
            }

            is.flush();

        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
