package de.heisluft.egm.items;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class ItemCrook extends ItemTool {
	public static enum Variant {
		WOOD("wooden_crook", ToolMaterial.WOOD), BONE("bone_crook", ToolMaterial.STONE);

		private final String name;
		private final ToolMaterial material;

		private Variant(String name, ToolMaterial material) {
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

	private static final Set<Block> effectiveBlocks = ImmutableSet.<Block>of(Blocks.LEAVES, Blocks.LEAVES2);

	public ItemCrook(Variant var) {
		super(var.getMaterial(), effectiveBlocks);
		setUnlocalizedName(var.getName());
		setRegistryName(var.getName());
		setCreativeTab(null);
	}
}
