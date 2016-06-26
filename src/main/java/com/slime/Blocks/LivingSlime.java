package com.slime.Blocks;

import com.slime.Tabs;
import com.slime.Init;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by owen on 6/19/16.
 */
public class LivingSlime extends Block {
    public LivingSlime() {
        super(Material.plants, MapColor.greenColor);
        this.setCreativeTab(Tabs.genetics).setUnlocalizedName("livingSlime").setRegistryName(Init.modid, this.getUnlocalizedName());
    }
}
