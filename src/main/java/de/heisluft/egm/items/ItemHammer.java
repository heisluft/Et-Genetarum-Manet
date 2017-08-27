package de.heisluft.egm.items;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class ItemHammer extends ItemTool {
	
	private static final Set<Block> effectiveBlocks = ImmutableSet.<Block>of(Blocks.SAND, Blocks.COBBLESTONE,
			Blocks.GRAVEL);
	
	public ItemHammer(ToolMaterial material) {
		super(material, effectiveBlocks);
		final String name = getToolMaterialName().toLowerCase()
				+ (toolMaterial == ToolMaterial.WOOD || toolMaterial == ToolMaterial.GOLD ? "en" : "") + "_hammer";
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
}
