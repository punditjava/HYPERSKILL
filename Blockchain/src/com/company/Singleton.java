package com.company;

import java.io.*;
import java.util.ArrayList;

final class Singleton implements Serializable
{
    private static volatile Singleton blockСhain;

    private volatile ArrayList<Block> blocks;

    private int N = 0;

    private Singleton(ArrayList<Block> blocks)
    {
        this.blocks = blocks;
    }

    static Singleton getInstance(ArrayList<Block> blocks)
    {
        Singleton result = blockСhain;
        if (result != null) {
            return result;
        }
        synchronized (Singleton.class) {
            if (blockСhain == null) {
                FileInputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream("test.ser");
                } catch (FileNotFoundException e) {
                    blockСhain = new Singleton(blocks);
                    return blockСhain;
                }

                ObjectInputStream objectInputStream;
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (IOException e) {
                    blockСhain = new Singleton(blocks);
                    return blockСhain;
                }

                try {
                    blockСhain = (Singleton)  objectInputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    blockСhain = new Singleton(blocks);
                    return blockСhain;
                }
            }
        }
        return blockСhain;
    }

    void createBlock(Block block)
    {
        AddBlock creator = new AddBlock(block);
            creator.run();
    }

    ArrayList<Block> getBlocks()
    {
        return blocks;
    }

    int getN()
    {
        return N;
    }
    void upN() { N++; System.out.println("N was increased to " + N +"\n");}
    void decreasedN() {N--; System.out.println("N was decreased by 1\n");}
    void stayN() {System.out.println("N stays the same\n");}
}
