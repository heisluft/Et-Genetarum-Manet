package de.heisluft.egm.items;

import de.heisluft.egm.EtGeneratumManet;
import de.heisluft.egm.util.ClosableHashSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;

public class ItemCrook extends ItemTool {
	public static enum Variant {
		WOOD("wooden_crook", ToolMaterial.WOOD), BONE("bone_crook", ToolMaterial.IRON);
		
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
	
	private static final ClosableHashSet<Block> effectiveBlocks = ClosableHashSet
			.<Block>of(new Block[] { Blocks.LEAVES, Blocks.LEAVES2 }).close();
	
	public static void updateMinableBlocks() {
		effectiveBlocks.disposeElementsAndReopen();
		for (final ResourceLocation l : Block.REGISTRY.getKeys())
			if (Block.REGISTRY.getObject(l) instanceof BlockLeaves)
				effectiveBlocks.add(Block.REGISTRY.getObject(l));
		effectiveBlocks.close();
		EtGeneratumManet.MAIN_LOG.info("Loading Compatibility for " + effectiveBlocks.size() + " types of Leaves!");
	}
	
	public ItemCrook(Variant var) {
		super(var.getMaterial(), effectiveBlocks);
		setUnlocalizedName(var.getName());
		setRegistryName(var.getName());
	}
}
