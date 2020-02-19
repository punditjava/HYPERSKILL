package com.company;

import java.util.ArrayList;

class AddBlock
{
    Block block;

    AddBlock(Block block)
    {
        this.block = block;
    }

    public void run()
    {
        Singleton blockChain = Singleton.getInstance(new ArrayList<>());

            blockChain.getBlocks().add(block);
            System.out.println(block.toString());

        if (block.getGeneratingTime() < 15) {
            blockChain.upN();
        } else if (block.getGeneratingTime() > 60) {
            blockChain.decreasedN();
        } else blockChain.stayN();
    }
}
