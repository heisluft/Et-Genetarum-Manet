package de.heisluft.egm.items;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemHammer extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_BLOCKS = ImmutableSet.of(Blocks.SAND, Blocks.COBBLESTONE,
			Blocks.GRAVEL);
	
	public ItemHammer(ToolMaterial material) {
		super(material, EFFECTIVE_BLOCKS);
		final String name = getToolMaterialName().toLowerCase()
				+ (toolMaterial == ToolMaterial.WOOD || toolMaterial == ToolMaterial.GOLD ? "en" : "") + "_hammer";
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
		return EFFECTIVE_BLOCKS.contains(state.getBlock()) || super.canHarvestBlock(state, stack);
	}
	
	// @Override
	// public float getStrVsBlock(ItemStack stack, IBlockState state) {
	// return EFFECTIVE_BLOCKS.contains(state.getBlock()) ?
	// efficiencyOnProperMaterial : 1.0f;
	// }
	
}
