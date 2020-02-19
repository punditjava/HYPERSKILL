package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Miner
{
    private Creator creator;
    private Block block;
    private int number;

    Miner(int number)
    {
        this.number = number;
    }

    void createBlock()
    {
        block = null;
        creator = new Creator();
        creator.start();
    }

    public void interruptCreator()
    {
        block = null;
        creator.interrupt();
    }

    Block getBlock()
    {
        return block;
    }


    public class Creator extends Thread
    {
        @Override
        public void run()
        {
            Singleton blockchain = Singleton.getInstance(new ArrayList<>());
            int id, magic;
            String previousBlock, hashBlock;
            long timestap, generatingTime;

            timestap = new Date().getTime();
            id = blockchain.getBlocks().size();

            if (id == 0) {
                previousBlock = "0";
            } else previousBlock = blockchain.getBlocks().get(id - 1).getHashBlock();
            System.out.println(previousBlock);
            do {
                magic = new Random().nextInt(100000000);
                hashBlock = new Sha256().applySha256(previousBlock + magic);
            }
            while (new Sha256().Proved(hashBlock, blockchain.getN()));

            generatingTime = (new Date().getTime() - timestap) / 1000;

            String threadName = Integer.toString(number);
            block = new Block(threadName, id, timestap, magic, previousBlock, hashBlock, generatingTime);

        }
    }

}
