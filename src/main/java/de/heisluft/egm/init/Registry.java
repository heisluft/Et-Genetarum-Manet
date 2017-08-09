package de.heisluft.egm.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Registry {
	@SubscribeEvent
	public void registerItems(Register<Item> event) {
		event.getRegistry().register(Items.WOODEN_CROOK);
	}
}
