package com.part.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by owen on 7/6/16.
 */
public class WorldPart extends Entity {
    private double meltPoint;
    private double freezePoint;
    private double heat;
    private double mass;

    public double addEnergy(double joules) {

    }

    public double getHeatEnergy()

    public WorldPart(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {
        meltPoint = tagCompound.getDouble("meltPoint");
        freezePoint = tagCompound.getDouble("freezePoint");
        heat = tagCompound.getDouble("heat");
        mass = tagCompound.getDouble("mass");
        if (!(meltPoint != null && freezePoint != null && heat != null && mass != null)) {

        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {

    }
}
