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
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.chunk.storage.ChunkLoader;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.UUID;

/**
 * Created by owen on 6/23/16.
 */
public class ShipPart extends Entity {
    private UUID partUUID;
    private Ship ship;
    private IBlockState blockState;
    private Block block;
    private TileEntity tile;
    private double heat;

    public UUID getPartUUID() {
        return partUUID;
    }

    public double getHeat() {
        return heat;
    }

    public void setHeat(double heatIn) {
        heat = heatIn;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship shipIn) {
        if (ship != null) {
            ship.removePart(this);
        }
        shipIn.addPart(this);
        ship = shipIn;
    }

    public IBlockState getBlockState() {
        return blockState;
    }

    public void setBlockState(IBlockState stateIn) {
        blockState = stateIn;
        block = stateIn.getBlock();
    }

    public UUID getShipUUID() {
        return ship.getShipUUID();
    }

    public ShipPart(World worldIn, IBlockState blockStateIn) {
        super(worldIn);
        blockState = blockStateIn;
        block = blockStateIn.getBlock();

    }

    public ShipPart(World worldIn) {
        super(worldIn);
    }

    public ShipPart(World worldIn, Ship shipIn, BlockPos pos) {
        super(worldIn);
        setShip(shipIn);
        blockState = worldIn.getBlockState(pos);
        block = blockState.getBlock();
        TileEntity tileIn = worldIn.getTileEntity(pos);
        if (tileIn != null) {
            NBTTagCompound tileNBT = tileIn.serializeNBT();
            worldIn.removeTileEntity(pos);
            tile = TileEntity.createTileEntity(Minecraft.getMinecraft().getIntegratedServer(), tileNBT);
        }
        heat = (worldIn.getBiomeGenForCoords(pos).getTemperature() - 0.5) + 293.15;
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
        if (source.isProjectile() && (source.getSourceOfDamage().getClass() == SpecialArrowEntity.class)) {
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
        UUID shipUUID = tagCompound.getUniqueId("shipUUID");
        ship = FindTrueShipPartLove.get(worldObj).getShip(shipUUID);
        int blockID = tagCompound.getInteger("blockID");
        int blockMeta = (int) tagCompound.getByte("blockMeta");
        block = Block.getBlockById(blockID);
        blockState = block.getStateFromMeta(blockMeta);
        heat = tagCompound.getDouble("heat");
        partUUID = tagCompound.getUniqueId("partUUID");
        tile = TileEntity.createTileEntity(Minecraft.getMinecraft().getIntegratedServer(), tagCompound.getCompoundTag("tileData"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setUniqueId("shipUUID", ship.getShipUUID());
        tagCompound.setInteger("blockID", Block.getIdFromBlock(block));
        tagCompound.setByte("blockMeta", (byte) block.getMetaFromState(blockState));
        tagCompound.setDouble("heat", heat);
        tagCompound.setUniqueId("partUUID", partUUID);
        tile.writeToNBT(tagCompound.getCompoundTag("tileData"));
    }
}
