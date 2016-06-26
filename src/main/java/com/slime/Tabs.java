package com.slime;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by owen on 6/19/16.
 */
public class Tabs {
    public static CreativeTabs genetics = new CreativeTabs("Slime Factory") {
        @Override
        public Item getTabIconItem() {
            return ItemInit.petriDish;
        }
    };

    public static void init() {
    }
}
