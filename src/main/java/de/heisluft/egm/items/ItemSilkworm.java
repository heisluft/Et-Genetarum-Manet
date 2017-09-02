package de.heisluft.egm.items;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSilkworm extends Item {
	public ItemSilkworm() {
		setUnlocalizedName("silkworm");
		setRegistryName("silkworm");
		setMaxStackSize(64);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer p, World w, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		final IBlockState blockState = w.getBlockState(pos);
		if (blockState.getBlock() instanceof BlockLeaves) {
			p.getHeldItem(hand).setCount(p.getHeldItem(hand).getCount());
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}
}
