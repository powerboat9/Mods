package com.ships.Enities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by owen on 6/25/16.
 */
public class SpecialArrowEntity extends EntityArrow {
    public SpecialArrowEntity(World worldIn) {
        super(worldIn);
    }

    public SpecialArrowEntity(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public SpecialArrowEntity(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(new )
    }
}
