package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main extends CompletableFuture
{

    public static void main(String[] args) throws IOException
    {
        ArrayList<Block> blockArrayList = new ArrayList<>();
        Singleton blockСhain = Singleton.getInstance(blockArrayList);


        int steps = 0;

        ArrayList<Miner> miners = new ArrayList<>();
        miners.add(new Miner(1));
        miners.add(new Miner(2));
        miners.add(new Miner(3));
        miners.add(new Miner(4));
        miners.add(new Miner(5));
        miners.add(new Miner(6));


        while (steps < 6) {

            for (Miner m : miners) {
                m.createBlock();
            }
            boolean flag = true;
            Block block = null;
            while (flag) {
                for (Miner e : miners) {
                    if (( block = e.getBlock() )!= null) {
                        blockСhain.createBlock(block);
                        flag = false;
                        break;
                    }
                }
            }

            for (Miner m : miners) {
                m.interruptCreator();
            }

            steps++;
        }


        FileOutputStream fileOutputStream = new FileOutputStream("test.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(blockСhain);

        objectOutputStream.close();

    }
}
