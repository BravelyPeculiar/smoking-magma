package com.github.bravelypeculiar.smokingmagma;

import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class SmokingMagmaBlockEntity extends BlockEntity {
    public SmokingMagmaBlockEntity(BlockPos pos, BlockState state) {
        super(SmokingMagmaMod.SMOKING_MAGMA_BLOCK_ENTITY_TYPE, pos, state);
    }

    public static void clientTick(World world, BlockPos pos, BlockState state, SmokingMagmaBlockEntity campfire) {
        Random random = world.random;
        int i;
        if (random.nextFloat() < 0.10F) {
            for(i = 0; i < random.nextInt(2) + 2; ++i) {
                CampfireBlock.spawnSmokeParticle(world, pos, (Boolean)state.get(CampfireBlock.SIGNAL_FIRE), false);
            }
        }
    }
}
