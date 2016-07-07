package com.part;

import com.part.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by owen on 7/6/16.
 */
@Mod(modid = "partMod", name = "Part Mod", version = "0.1.0 for 1.9")
public class Init {
    @SidedProxy(clientSide = "com.part.proxy.ClientProxy", serverSide = "com.part.proxy.ServerProxy")
    public CommonProxy proxy;

    public void FMLPreInit(FMLPreInitializationEvent event) {
        proxy.FMLPreInit(event);
    }

    public void FMLInit(FMLInitializationEvent event) {
        proxy.FMLInit(event);
    }

    public void FMLPostInit(FMLPostInitializationEvent event) {
        proxy.FMLPostInit(event);
    }
}
