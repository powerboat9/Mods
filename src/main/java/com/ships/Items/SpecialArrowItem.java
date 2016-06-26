package com.ships.Items;

import com.ships.Init;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by owen on 6/25/16.
 */
public class SpecialArrowItem extends Item {
    public SpecialArrowItem() {
        this.setMaxStackSize(64).setUnlocalizedName("specialArrow").setCreativeTab(CreativeTabs.tabCombat).setRegistryName(Init.modid, this.getUnlocalizedName());
    }
}
