package de.heisluft.egm.items;

import net.minecraft.item.ItemFood;

public class ItemSilkwormCooked extends ItemFood {
	public ItemSilkwormCooked() {
		super(5, 4.5f, false);
		setUnlocalizedName("cooked_silkworm");
		setRegistryName("cooked_silkworm");
		setMaxStackSize(64);
	}
}
