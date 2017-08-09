package de.heisluft.egm.items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class ItemCrook extends ItemTool {
	public static enum Variation {
		WOOD("wooden_crook", ToolMaterial.WOOD), BONE("bone_crook", ToolMaterial.STONE);

		private final String name;
		private final ToolMaterial material;

		private Variation(String name, ToolMaterial material) {
			this.material = material;
			this.name = name;
		}

		public ToolMaterial getMaterial() {
			return material;
		}

		public String getName() {
			return name;
		}
	}

	private static final Set<Block> effectiveBlocks = Sets.<Block>newHashSet();

	{
		effectiveBlocks.add(Blocks.LEAVES);
		effectiveBlocks.add(Blocks.LEAVES2);
	}

	public ItemCrook(Variation var) {
		super(var.getMaterial(), effectiveBlocks);
		setUnlocalizedName("item." + var.getName());
	}
}
