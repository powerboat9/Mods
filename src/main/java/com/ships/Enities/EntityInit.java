package com.ships.Enities;

import com.ships.Init;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by owen on 6/24/16.
 */
public class EntityInit {
    public static void init() {
        EntityRegistry.registerModEntity(ShipPart.class, "ShipPart", EntityRegistry.findGlobalUniqueEntityId(), Init.class, 80, 3, true);
    }
}
