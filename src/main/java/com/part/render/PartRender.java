package com.part.render;

import com.part.entities.WorldPart;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Created by owen on 7/7/16.
 */
public class PartRender extends Render<WorldPart> {
    private HashMap partDynamicTextures = new HashMap();

    private BufferedImage getSeamlessTexture(BufferedImage image, boolean up, boolean down, boolean left, boolean right) {
        boolean showLeftTopCorner = !up || !left;
        boolean showRightTopCorner = !up || !right;
        boolean showLeftBottomCorner = !down || !left;
        boolean showRightBottomCorner = !down || !right;
        int[] imageArray = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        BufferedImage newImg = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
    }

    protected PartRender(RenderManager renderManager) {
        super(renderManager);
    }

    private DynamicTexture getTexture(WorldPart partIn) {
        if (!partDynamicTextures.containsKey(partIn)) {
            DynamicTexture texture = new DynamicTexture();
            partDynamicTextures.put(partIn, texture);
            return texture;
        }
        return (DynamicTexture) partDynamicTextures.get(partIn);
    }

    public void resetPartTexture(WorldPart partIn) {
    }

    @Override
    protected ResourceLocation getEntityTexture(WorldPart entity) {
        return this.renderManager.renderEngine.getDynamicTextureLocation("worldPart", getTexture(entity));
    }
}