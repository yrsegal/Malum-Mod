package com.sammy.malum.core.init.worldgen;

import com.sammy.malum.MalumMod;
import com.sammy.malum.common.world.features.tree.HugeSunKissedBlockStateProvider;
import com.sammy.malum.common.world.features.tree.SunKissedFoliagePlacer;
import com.sammy.malum.core.init.blocks.MalumBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class MalumFeatures
{
    public static final BlockClusterFeatureConfig SHORT_SUN_KISSED_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(MalumBlocks.SHORT_SUN_KISSED_GRASS.get().getDefaultState(), 3).addWeightedBlockstate(MalumBlocks.SUN_KISSED_GRASS.get().getDefaultState(), 2), SimpleBlockPlacer.PLACER)).tries(32).build();
    public static final BlockClusterFeatureConfig TALL_SUN_KISSED_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MalumBlocks.TALL_SUN_KISSED_GRASS.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(36).func_227317_b_().build();
    
    public static final BlockClusterFeatureConfig LAVENDER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MalumBlocks.LAVENDER.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(24).func_227317_b_().build();
    public static final BlockClusterFeatureConfig CORNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MalumBlocks.CORNFLOWER.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(24).func_227317_b_().build();
    
    public static final ConfiguredFeature<?, ?> RANDOM_GRASS = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "random_sun_kissed_grass", Feature.RANDOM_PATCH.withConfiguration(SHORT_SUN_KISSED_GRASS_CONFIG));
    public static final ConfiguredFeature<?, ?> SHORT_SUN_KISSED_GRASS = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "short_sun_kissed_grass", Feature.RANDOM_PATCH.withConfiguration(SHORT_SUN_KISSED_GRASS_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.6D, 50, 2))));
    public static final ConfiguredFeature<?, ?> TALL_SUN_KISSED_GRASS = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "tall_sun_kissed_grass", Feature.RANDOM_PATCH.withConfiguration(TALL_SUN_KISSED_GRASS_CONFIG).withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT).square().withPlacement(Features.Placements.PATCH_PLACEMENT).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.7D, 25, 1))));
    public static final ConfiguredFeature<?, ?> LAVENDER = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "lavender", Feature.RANDOM_PATCH.withConfiguration(LAVENDER_CONFIG).withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT).square().withPlacement(Features.Placements.PATCH_PLACEMENT).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0.8D, 0, 25))));
    public static final ConfiguredFeature<?, ?> CORNFLOWER = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "cornflower", Feature.RANDOM_PATCH.withConfiguration(CORNFLOWER_CONFIG).withPlacement(Features.Placements.FLOWER_TALL_GRASS_PLACEMENT).square().withPlacement(Features.Placements.PATCH_PLACEMENT).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 25, 0))));
    
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SUN_KISSED_TREE = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "sun_kissed_tree", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MalumBlocks.SUN_KISSED_LOG.get().getDefaultState()), new SimpleBlockStateProvider(MalumBlocks.SUN_KISSED_LEAVES.get().getDefaultState()), new SunKissedFoliagePlacer(FeatureSpread.func_242253_a(3, 2), FeatureSpread.func_242253_a(1, 3), FeatureSpread.func_242253_a(2, 1)), new StraightTrunkPlacer(7, 3, 1), new TwoLayerFeature(3, 1, 3)).build()));
    
    public static final ConfiguredFeature<?, ?> RARE_SUN_KISSED_TREE = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "rare_sun_kissed_tree", SUN_KISSED_TREE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.2F, 1))));
    
    public static final ConfiguredFeature<?, ?> GROUPED_SUN_KISSED_TREE = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "grouped_sun_kissed_tree", SUN_KISSED_TREE.withPlacement(Features.Placements.PATCH_PLACEMENT).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.6D, 6, 0))));
    
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> HUGE_SUN_KISSED_TREE = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MalumMod.MODID + ":" + "huge_sun_kissed_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MalumBlocks.SUN_KISSED_LOG.get().getDefaultState()), new HugeSunKissedBlockStateProvider(MalumBlocks.SUN_KISSED_LEAVES.get().getDefaultState()), new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), FeatureSpread.func_242253_a(13, 4)), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).build()));
}