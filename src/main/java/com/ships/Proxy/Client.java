package com.ships.Proxy;

import com.ships.Enities.ShipPart;
import com.ships.EntityRenders.RenderShipPart;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Map;

/**
 * Created by owen on 6/24/16.
 */
public class Client extends Common {
    @Override
    public void FMLPreInit(FMLPreInitializationEvent event) {
        super.FMLPreInit(event);
        RenderingRegistry.registerEntityRenderingHandler(ShipPart.class, new RenderShipPart());
    }
}
