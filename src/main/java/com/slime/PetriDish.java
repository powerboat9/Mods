package com.slime;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by owen on 6/19/16.
 */
public class PetriDish extends Item {
    public PetriDish() {
        this.setUnlocalizedName("petriDish").setCreativeTab(Tabs.genetics).setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        BlockPos placePos = new BlockPos(pos.getX() + facing.getFrontOffsetX(), pos.getY() + facing.getFrontOffsetY(), pos.getZ() + facing.getFrontOffsetZ());
        if (worldIn.isAirBlock(placePos)) {
            if (!worldIn.isRemote) {
                worldIn.setBlockState(placePos, BlockInit.livingSlime.getDefaultState());
            }
            if (!playerIn.isCreative()) {

            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }

    /*@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        //return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
        boolean canPlace;
        if ()
        if (playerIn.isCreative()) {

        }

        return EnumActionResult.
    }*/
}
