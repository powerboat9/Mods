package com.part.render;

import com.part.entities.WorldPart;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by owen on 7/7/16.
 */
public class PartRenderFactory implements IRenderFactory {
    @Override
    public Render createRenderFor(RenderManager manager) {
        return new PartRender(manager);
    }
}
