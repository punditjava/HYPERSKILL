package com.company;

import java.util.Date;
import java.util.Random;

class Creator
{
    Singleton blockchain;

    Creator(Singleton blockchain)
    {
        this.blockchain = blockchain;
    }

    void createBlock()
    {
        int id, magic;
        String previousBlock, hashBlock;
        long timestap, generatingTime;

        timestap = new Date().getTime();
        id = blockchain.getBlocks().size();
        if (id == 0) {
            previousBlock = "0";
        } else previousBlock = blockchain.getBlocks().get(id - 1).getHashBlock();

        do {
            magic = new Random().nextInt(100000000);
            hashBlock = new Sha256().applySha256(previousBlock + magic);
        }
        while (new Sha256().Proved(hashBlock, blockchain.getN()));

        generatingTime = (new Date().getTime() - timestap) / 1000;

        blockchain.getBlocks().add(new Block(id, timestap, magic, previousBlock, hashBlock, generatingTime));
    }

}
