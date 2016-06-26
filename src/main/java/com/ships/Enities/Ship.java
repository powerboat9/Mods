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
    private HashMap parts = new HashMap();
    private List<int[]> connections = new ArrayList<int[]>();
    private boolean isDirty;
    private UUID shipUUID;

    public void markDirty(World worldIn) {
        isDirty = true;
        FindTrueShipPartLove.get(worldIn).markDirty();
    }

    public HashMap getParts() {
        HashMap partList = new HashMap();
        partList.putAll(parts);
        return partList;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void addPart(ShipPart partIn, boolean isFromNBTLoad) {
        parts.put(partIn.getPartUUID(), partIn);
        if (!isFromNBTLoad) {
            markDirty(partIn.worldObj);
        }
    }

    public void addPart(ShipPart partIn) {
        addPart(partIn, false);
    }

    public void removePart(ShipPart partIn) {
        parts.remove(partIn.getPartUUID());
        markDirty(partIn.worldObj);
    }

    public Ship(World worldIn) {
        shipUUID = UUID.randomUUID();
        markDirty(worldIn);
    }

    public Ship(NBTTagCompound nbt) {
        shipUUID = nbt.getUniqueId("UUID");
        NBTTagList connectionNBT = nbt.getTagList("connections", Constants.NBT.TAG_COMPOUND);
        for (int i = 1; true; i++) {
            NBTTagCompound newTag = (NBTTagCompound) connectionNBT.get(i);
            if (newTag == null) {
                break;
            }
            int[] data = new int[3];
            data[0] = newTag.getInteger("strength");
            data[1] = newTag.getInteger("part_1");
            data[2] = newTag.getInteger("part_2");
            connections.add(data);
        }
    }

    public UUID getShipUUID() {
        return shipUUID;
    }

    public void save(NBTTagCompound nbt) {
        nbt.setUniqueId("shipUUID", shipUUID);
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