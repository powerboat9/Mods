package com.ships.Enities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.*;

/**
 * Created by owen on 6/23/16.
 */
public class Ship {
    private int id;
    private int partNum;
    private World world;
    private HashMap parts = new HashMap();
    private List<int[]> connections;
    private boolean isDirty;

    public void markDirty() {
        isDirty = true;
        FindTrueShipPartLove.get(world).markDirty();
    }

    public HashMap getParts() {
        HashMap partList = new HashMap();
        partList.putAll(parts);
        return partList;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void addPart(ShipPart partIn) {
        parts.put(partIn, partIn.getPartID());
    }

    public int getNextPartID() {
        return partNum + 1;
    }

    public Ship(World worldIn, List<int[]> connectionsIn) {
        world = worldIn;
        id = FindTrueShipPartLove.getNextShipID();
        connections = connectionsIn;
    }

    public Ship(World worldIn, NBTTagCompound nbt) {
        world = worldIn;
        id = nbt.getInteger("id");
        NBTTagList connectionNBT = nbt.getTagList("connections", Constants.NBT.TAG_COMPOUND);
        for (int[] data : connections) {
            NBTTagCompound newTag = new NBTTagCompound();
            newTag.setInteger("strength", data[0]);
            newTag.setInteger("part_1", data[1]);
            newTag.setInteger("part_2", data[2]);
            connectionNBT.appendTag(newTag);
        }
    }

    public int getID() {
        return id;
    }

    public void save(NBTTagCompound nbt) {
        NBTTagList connectionNBT = nbt.getTagList("connections", Constants.NBT.TAG_COMPOUND);
        for (int[] data : connections) {
            NBTTagCompound newTag = new NBTTagCompound();
            newTag.setInteger("strength", data[0]);
            newTag.setInteger("part_1", data[1]);
            newTag.setInteger("part_2", data[2]);
            connectionNBT.appendTag(newTag);
        }
    }
}