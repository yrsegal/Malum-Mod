package com.sammy.malum.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ImperviousRockBlock extends Block
{
    public ImperviousRockBlock(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public boolean canEntityDestroy(BlockState state, IBlockReader world, BlockPos pos, Entity entity)
    {
        return false;
    }
}
