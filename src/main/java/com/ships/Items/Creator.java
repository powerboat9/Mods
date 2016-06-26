package com.ships.Items;

import com.ships.Enities.FindTrueShipPartLove;
import com.ships.Enities.Ship;
import com.ships.Enities.ShipPart;
import com.ships.Init;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by owen on 6/24/16.
 */
public class Creator extends Item {
    public Creator() {
        this.setCreativeTab(CreativeTabs.tabTools).setMaxStackSize(1).setUnlocalizedName("shipCreator").setRegistryName(Init.modid, this.getUnlocalizedName());
    }

    @Override
    public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        if (!world.isRemote) {
            List<BlockPos> toSave = FindTrueShipPartLove.getAttached(world, pos);
            if (toSave == null) {
                return EnumActionResult.FAIL;
            }
            Ship newShip = new Ship(world);
            for (BlockPos savePos : toSave) {
                ShipPart newPart = new ShipPart(world, newShip, savePos);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
}
