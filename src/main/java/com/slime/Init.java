package com.slime;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by owen on 6/19/16.
 */
@Mod(modid = "slime_factory", name = "Slime Factory", version = "1.9")
public class Init {
    public static String modid = "slime_factory";
    public static String name = "Slime Factory";
    public static String version = "1.9";

    public void init(FMLPreInitializationEvent event) {
        BlockInit.init();
    }
}
