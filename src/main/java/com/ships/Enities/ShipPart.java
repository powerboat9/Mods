package com.ships.Enities;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

/**
 * Created by owen on 6/23/16.
 */
public class ShipPart extends Entity {
    private UUID shipUUID;
    private UUID partUUID;
    private Ship ship;
    private IBlockState blockState;
    private Block block;
    private TileEntity tile;
    private int heat;

    public UUID getPartUUID() {
        return partUUID;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heatIn) {
        heat = heatIn;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship shipIn) {
        if (ship != null) {
            ship.
        } shipIn.getID();
        ship = shipIn;
    }

    public IBlockState getBlockState() {
        return blockState;
    }

    public void setBlockState(IBlockState stateIn) {
        blockState = stateIn;
        block = stateIn.getBlock();
    }

    public int getShipID() {
        return shipID;
    }

    private void initProperties() {
        this.setSize(1, 1);
    }

    public ShipPart(World worldIn, Ship shipIn) {
        super(worldIn);
        setShip(shipIn);
        initProperties();
    }

    public ShipPart(World worldIn) {
        super(worldIn);
        setShip(FindTrueShipPartLove.);
    }

    public ShipPart(World worldIn, Ship shipIn, BlockPos pos) {
        super(worldIn);
        setShip(shipIn);
        initProperties();
        blockState = worldIn.getBlockState(pos);
        block = blockState.getBlock();
        TileEntity tileIn = worldIn.getTileEntity(pos);
        if (tileIn != null) {
            NBTTagCompound tileNBT = tileIn.serializeNBT();
            worldIn.removeTileEntity(pos);
            tile = TileEntity.createTileEntity(Minecraft.getMinecraft().getIntegratedServer(), tileNBT);
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.isProjectile() && (source.getSourceOfDamage().getClass() == SpecialArrowEntity.class) {
            super.attackEntityFrom(source, amount);
            return true;
        }
        return false;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {
        shipID = tagCompound.getInteger("shipID");
        int blockID = tagCompound.getInteger("blockID");
        int blockMeta = (int)tagCompound.getByte("blockMeta");
        block = Block.getBlockById(blockID);
        blockState = block.getStateFromMeta(blockMeta);
        heat = tagCompound.getInteger("heat");
        partID = tagCompound.getInteger("partID");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setInteger("shipID", shipID);
        tagCompound.setInteger("blockID", Block.getIdFromBlock(block));
        tagCompound.setByte("blockMeta", (byte) block.getMetaFromState(blockState));
        tagCompound.setInteger("heat", heat);
        tagCompound.setInteger("partID", partID);
    }
}
