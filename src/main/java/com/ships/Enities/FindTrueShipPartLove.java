package com.ships.Enities;

import com.ships.Init;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by owen on 6/23/16.
 */
public class FindTrueShipPartLove extends WorldSavedData {
    private HashMap ships;
    private static final String key = "shipData";

    public Ship getShip(UUID uuidIn) {
        return (Ship) ships.get(uuidIn);
    }

    public boolean registerPart(UUID shipUUID, ShipPart partIn, boolean isFromNBTLoad) {
        if (!ships.containsKey(shipUUID)) {
            return false;
        }
        Ship ship = (Ship) ships.get(shipUUID);
        ship.addPart(partIn, isFromNBTLoad);
        return true;
    }

    public boolean registerPart(UUID shipUUID, ShipPart partIn) {
        return registerPart(shipUUID, partIn, false);
    }

    public static List<BlockPos> getAttached(World world, BlockPos pos) {
        if (world.isAirBlock(pos)) {
            return null;
        }
        List<BlockPos> blocks = new ArrayList<BlockPos>();
        List<BlockPos> proccessing = new ArrayList<BlockPos>();
        int maxBlocksCanAddNext = Init.maxHold - 1; //We automatically add the first block
        proccessing.add(pos);
        blocks.add(pos);
        while (true) {
            BlockPos next = proccessing.get(0);
            proccessing.remove(0);
            if (next == null) {
                break;
            }
            for (EnumFacing facing : EnumFacing.VALUES) {
                BlockPos checkPos = next.offset(facing);
                if (!world.isAirBlock(checkPos)) {
                    if (maxBlocksCanAddNext < 1) {
                        return null;
                    } else {
                        maxBlocksCanAddNext--;
                    }
                    proccessing.add(checkPos);
                    blocks.add(pos);
                }
            }
        }
        return blocks;
    }

    public FindTrueShipPartLove() {
        super(key);
    }

    public static FindTrueShipPartLove get(World worldIn) {
        MapStorage storage = worldIn.getPerWorldStorage();
        FindTrueShipPartLove save = (FindTrueShipPartLove) storage.loadData(FindTrueShipPartLove.class, key);
        if (save == null) {
            save = new FindTrueShipPartLove();
            storage.setData(key, save);
        }
        return save;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList data = nbt.getTagList("shipSave", Constants.NBT.TAG_COMPOUND);
        for (Ship ship : (Ship[]) ships.values().toArray()) {
            if (ship.isDirty()) {
                NBTTagCompound newTag = new NBTTagCompound();
                ship.save(newTag);
                data.appendTag(newTag);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        NBTTagList data = nbt.getTagList("shipSave", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; true; i++) {
            NBTTagCompound newTag = (NBTTagCompound) data.get(i);
            Ship newShip = new Ship(newTag);
            ships.put(newShip.getShipUUID(), newShip);
        }
    }
}
