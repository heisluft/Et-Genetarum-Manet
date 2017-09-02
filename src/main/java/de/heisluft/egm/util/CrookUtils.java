package de.heisluft.egm.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrookUtils {
	public static boolean doCrooking(ItemStack item, BlockPos pos, EntityPlayer player) {
		final World world = player.getEntityWorld();
		final IBlockState block = world.getBlockState(pos);
		boolean validTarget = false;
		
		if (block.getBlock().isLeaves(block, world, pos)) {
			if (!world.isRemote) {
				block.getBlock().dropBlockAsItem(world, pos, block, 0);
				block.getBlock().dropBlockAsItem(world, pos, block, 0);
				if (world.rand.nextInt(100) == 0)
					world.spawnEntity(new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
							new ItemStack(Items.STICK, 1, 0)));
			}
			validTarget = true;
		}
		if (block.getBlock() == Blocks.ANVIL) {
			if (!world.isRemote)
				if (world.rand.nextInt(15) == 0)
					world.spawnEntity(new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
							new ItemStack(Items.STICK, 1, 0)));
			validTarget = true;
		}
		return validTarget;
	}
}
