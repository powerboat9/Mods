package com.ships.EntityRenders;

import com.ships.Enities.ShipPart;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by owen on 6/24/16.
 */
public class RenderShipPart implements IRenderFactory {
    @Override
    public Render createRenderFor(RenderManager manager) {
        return new Render(manager) {
            @Override
            protected ResourceLocation getEntityTexture(Entity entity) {
                return ((ShipPart) entity).getBlockState().getBlock().getRegistryName();
            }
        };
    }
}
