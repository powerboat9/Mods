package com.part.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.common.util.Constants;

/**
 * Created by owen on 7/6/16.
 */
public class WorldPart extends Entity {
    private double meltPoint;
    private double freezePoint;
    private double heat;
    private double mass;

    public void addEnergy(double joules) {
    }

    public WorldPart(World worldIn) {
        super(worldIn);
    }

    public WorldPart(World worldIn, double meltPointIn, double freezePointIn, double heatIn, double massIn) {
        super(worldIn);
        meltPoint = meltPointIn;
        freezePoint = freezePointIn;
        heat = heatIn;
        mass = massIn;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {
        if (tagCompound.hasKey("meltPoint", Constants.NBT.TAG_DOUBLE) && tagCompound.hasKey("freezePoint") && tagCompound.hasKey("heat", Constants.NBT.TAG_DOUBLE) && tagCompound.hasKey("mass", Constants.NBT.TAG_DOUBLE)) {
            meltPoint = tagCompound.getDouble("meltPoint");
            freezePoint = tagCompound.getDouble("freezePoint");
            heat = tagCompound.getDouble("heat");
            mass = tagCompound.getDouble("mass");
        } else {
            this.setDead();
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setDouble("meltPoint", meltPoint);
        tagCompound.setDouble("freezePoint", freezePoint);
        tagCompound.setDouble("heat", heat);
        tagCompound.setDouble("mass", mass);
    }
}
