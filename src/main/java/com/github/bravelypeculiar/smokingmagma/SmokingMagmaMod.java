package com.github.bravelypeculiar.smokingmagma;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class SmokingMagmaMod implements ModInitializer {
    public static String NAMESPACE = "smoking_magma";

    public static Identifier SMOKING_MAGMA_BLOCK_ID;
    public static Identifier SMOKING_MAGMA_BLOCK_ENTITY_ID;

    public static Block SMOKING_MAGMA_BLOCK;

    public static BlockEntityType<SmokingMagmaBlockEntity> SMOKING_MAGMA_BLOCK_ENTITY_TYPE;

    @Override
    public void onInitialize() {
        SMOKING_MAGMA_BLOCK_ID = new Identifier(NAMESPACE, "smoking_magma_block");
        SMOKING_MAGMA_BLOCK_ENTITY_ID = new Identifier(NAMESPACE, "smoking_magma_block_entity");

        SMOKING_MAGMA_BLOCK = Registry.register(Registry.BLOCK, SMOKING_MAGMA_BLOCK_ID, new SmokingMagmaBlock(FabricBlockSettings
                .of(Material.STONE, MapColor.DARK_RED)
                .requiresTool().luminance((state) -> 3)
                .ticksRandomly().strength(0.5F)
                .allowsSpawning((state, world, pos, entityType) -> entityType.isFireImmune())
                .postProcess((state, world, pos) -> true)
                .emissiveLighting((state, world, pos) -> true)
        ));

        SMOKING_MAGMA_BLOCK_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, SMOKING_MAGMA_BLOCK_ENTITY_ID, FabricBlockEntityTypeBuilder.create(SmokingMagmaBlockEntity::new, SMOKING_MAGMA_BLOCK).build(null));
    }
}
