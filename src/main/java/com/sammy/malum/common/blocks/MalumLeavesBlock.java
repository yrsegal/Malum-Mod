package com.sammy.malum.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class MalumLeavesBlock extends LeavesBlock
{
    public static final IntegerProperty COLOR = IntegerProperty.create("color",0,9);
    public MalumLeavesBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(COLOR, 0));
    
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(COLOR);
    }
    
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(COLOR, 0);
    }
    
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if (player.getHeldItem(handIn).getItem().equals(Items.COAL))
        {
            worldIn.setBlockState(pos,state.with(COLOR, (state.get(COLOR) + 1) % 9));
            doAction(player,handIn);
        }
        if (player.getHeldItem(handIn).getItem().equals(Items.GLOWSTONE_DUST))
        {
            worldIn.setBlockState(pos,state.with(COLOR, (state.get(COLOR) + 3) % 9));
            doAction(player,handIn);
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    public void doAction(PlayerEntity playerEntity, Hand hand)
    {
        playerEntity.swingArm(hand);
        playerEntity.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1F, 1.5f + RANDOM.nextFloat() * 0.5f);
    }
}
