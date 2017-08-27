package de.heisluft.egm.init;

import de.heisluft.egm.items.ItemCrook;
import de.heisluft.egm.items.ItemCrook.Variant;
import de.heisluft.egm.items.ItemHammer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;

public class Items {
	
	public static final ItemCrook BONE_CROOK = new ItemCrook(Variant.BONE);
	public static final ItemCrook WOODEN_CROOK = new ItemCrook(Variant.WOOD);
	public static final ItemHammer WOODEN_HAMMER = new ItemHammer(ToolMaterial.WOOD);
	public static final ItemHammer STONE_HAMMER = new ItemHammer(ToolMaterial.STONE);
	public static final ItemHammer IRON_HAMMER = new ItemHammer(ToolMaterial.IRON);
	public static final ItemHammer GOLDEN_HAMMER = new ItemHammer(ToolMaterial.GOLD);
	public static final ItemHammer DIAMOND_HAMMER = new ItemHammer(ToolMaterial.DIAMOND);

	private static void meshModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	public static void registerTextures() {
		meshModel(BONE_CROOK, 0);
		meshModel(DIAMOND_HAMMER, 0);
		meshModel(GOLDEN_HAMMER, 0);
		meshModel(IRON_HAMMER, 0);
		meshModel(WOODEN_HAMMER, 0);
		meshModel(WOODEN_CROOK, 0);
		meshModel(STONE_HAMMER, 0);
	}
}
