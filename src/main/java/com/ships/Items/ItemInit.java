package com.ships.Items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by owen on 6/24/16.
 */
public class ItemInit {
    public static Item creator = new Creator();

    public static void init() {
        GameRegistry.register(creator);
    }
}
