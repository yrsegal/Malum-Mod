package com.sammy.malum;

import com.sammy.malum.core.data.BlockStateProvider;
import com.sammy.malum.core.data.BlockTagProvider;
import com.sammy.malum.core.data.ItemModelProvider;
import com.sammy.malum.core.data.LangProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static com.sammy.malum.core.init.MalumBlocks.BLOCKS;
import static com.sammy.malum.core.init.MalumFeatures.FEATURES;
import static com.sammy.malum.core.init.MalumItems.ITEMS;

@SuppressWarnings("unused")
@Mod("malum")
public class MalumMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "malum";
    public static final Random RANDOM = new Random();
    
    public MalumMod()
    {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        FEATURES.register(modBus);
        
        modBus.addListener(this::gatherData);
    }
    
    public void gatherData(GatherDataEvent evt)
    {
        evt.getGenerator().addProvider(new BlockStateProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ItemModelProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new LangProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(new BlockTagProvider(evt.getGenerator()));
    }
}