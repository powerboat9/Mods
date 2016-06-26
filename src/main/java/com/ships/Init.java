package com.ships;

import com.ships.Blocks.BlockInit;
import com.ships.Proxy.Common;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by owen on 6/23/16.
 */

@Mod(modid = "slimeShips", name = "Thermal Ships", version = "1.9.4")
public class Init {
    @SidedProxy(clientSide = "com.ships.Proxy.Client", serverSide = "com.ships.Proxy.Server")
    public static Common sidedProxy;
    public static String modid = "slimeShips";

    public static int maxHold;

    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        maxHold = config.get(Configuration.CATEGORY_GENERAL, "maxHold", 4096, "The maximum amount of blocks that can be put on a ship, between 1 and 65565", 1, 65536).getInt();
        sidedProxy.FMLPreInit(event);
    }

    public void init(FMLInitializationEvent event) {
        sidedProxy.FMLInit(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        sidedProxy.FMLPostInit(event);
    }
}
