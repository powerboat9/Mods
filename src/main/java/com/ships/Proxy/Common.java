package com.ships.Proxy;

import com.ships.Blocks.BlockInit;
import com.ships.Enities.EntityInit;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by owen on 6/24/16.
 */
public class Common {
    public void initRenders() {
    }

    public void FMLPreInit(FMLPreInitializationEvent event) {
        BlockInit.init();
        EntityInit.init();
    }

    public void FMLInit(FMLInitializationEvent event) {
    }

    public void FMLPostInit(FMLPostInitializationEvent event) {
    }
}
