package de.heisluft.egm.init;

import de.heisluft.egm.EtGeneratumManet;
import de.heisluft.egm.items.ItemCrook;
import de.heisluft.egm.items.ItemCrook.Variant;
import de.heisluft.egm.items.ItemHammer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

public class Items {
	
	public static final ItemCrook BONE_CROOK = new ItemCrook(Variant.BONE);
	public static final ItemCrook WOODEN_CROOK = new ItemCrook(Variant.WOOD);
	public static final ItemHammer WOODEN_HAMMER = new ItemHammer(ToolMaterial.WOOD);
	public static final ItemHammer STONE_HAMMER = new ItemHammer(ToolMaterial.STONE);
	public static final ItemHammer IRON_HAMMER = new ItemHammer(ToolMaterial.IRON);
	public static final ItemHammer GOLDEN_HAMMER = new ItemHammer(ToolMaterial.GOLD);
	public static final ItemHammer DIAMOND_HAMMER = new ItemHammer(ToolMaterial.DIAMOND);
	
	private static void addAndRegisterRender(Item item) {
		Registry.ITEMS_TO_REGISTER.add(item);
		if (item instanceof ICanHasSpecial)
			((ICanHasSpecial) item).doSpecialStuff();
		else
			EtGeneratumManet.proxy.addRenderRegister(new ItemStack(item), item.getRegistryName(), "inventory");
	}

	public static void init() {
		addAndRegisterRender(BONE_CROOK);
		addAndRegisterRender(WOODEN_CROOK);
		addAndRegisterRender(WOODEN_HAMMER);
		addAndRegisterRender(STONE_HAMMER);
		addAndRegisterRender(IRON_HAMMER);
		addAndRegisterRender(GOLDEN_HAMMER);
		addAndRegisterRender(DIAMOND_HAMMER);
	}

}
