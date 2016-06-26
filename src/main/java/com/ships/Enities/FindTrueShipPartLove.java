package com.ships.Enities;

import com.ships.Init;
import com.sun.crypto.provider.KeyGeneratorCore;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.common.util.Constants;
import sun.security.provider.SHA5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by owen on 6/23/16.
 */
public class FindTrueShipPartLove extends WorldSavedData {
    private Ship[] ships;
    private HashMap shipIDs = new HashMap();
    private HashMap partIDs;
    private int nextID;

    private static final String key = "shipData";

    public int getNextShipID() {
        int check = 0;
        while (true) {
        }
    }

    public Ship getShip(ShipPart partIn, World world) {
        /*Ship retShip = (Ship) shipIDs.get(id);
        if (retShip == null) {
            queue(partIn, id);
        }
        return retShip;*/
        Ship retrivedShip = new Ship(world, )
    }

    public void queue(ShipPart partIn, int id) {
        if (partIDs.get(id) == null) {
            partIDs.put(id, new ArrayList<ShipPart>());
        }
        ((ArrayList<ShipPart>) partIDs.get(id)).add(partIn);
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
        NBTTagList connectionNBT = nbt.getTagList("connections", Constants.NBT.TAG_INT_ARRAY);
        for (Ship ship : (Ship[]) shipIDs.values().toArray()) {
            if (ship.isDirty()) {
                for (ShipPart part : ship.getParts()) {
                    if part.
                }
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
    }
}
