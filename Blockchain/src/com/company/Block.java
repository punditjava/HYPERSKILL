package com.company;

import java.io.Serializable;

public class Block implements Serializable
{
    private int id;
    private String previousHashBlock;
    private String hashBlock;
    private long timestap;
    private long generatingTime;
    private int magicNumber;
    private String miner;

    Block(String miner, int id, long timestamp, int magic, String previousHashBlock, String hashBlock, long generatingTime)
    {
        this.miner = miner;
        this.id = id;
        this.timestap = timestamp;
        this.magicNumber = magic;
        this.hashBlock = hashBlock;
        this.previousHashBlock = previousHashBlock;
        this.generatingTime = generatingTime;
    }

    @Override
    public String toString()
    {
        return "Block:\n" +
                "Created by miner # " + miner +
                "\nId: " + (id + 1) +
                "\nTimestamp: " + timestap +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block: \n" +
                previousHashBlock +
                "\nHash of the block: \n" + hashBlock +
                "\nBlock was generating for " + generatingTime + " seconds";
    }

    String getHashBlock()
    {
        return hashBlock;
    }

    String getPreviousHashBlock()
    {
        return previousHashBlock;
    }

    public long getGeneratingTime()
    {
        return generatingTime;
    }
}
