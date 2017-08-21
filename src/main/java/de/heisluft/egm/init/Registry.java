package de.heisluft.egm.init;

import de.heisluft.egm.EtGeneratumManet;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Registry {
	@SubscribeEvent
	public void registerItems(Register<Item> event) {
		EtGeneratumManet.MAIN_LOG.info(Items.WOODEN_CROOK.getUnlocalizedName());
		event.getRegistry().register(Items.WOODEN_CROOK);
	}
}
