package com.slime;

import com.slime.Blocks.LivingSlime;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by owen on 6/19/16.
 */
public class BlockInit {
    public static LivingSlime livingSlime = new LivingSlime();

    public static void init() {
        //GameRegistry.registerBlock(livingSlime, livingSlime.getUnlocalizedName());
        GameRegistry.register(livingSlime);
    }
}
