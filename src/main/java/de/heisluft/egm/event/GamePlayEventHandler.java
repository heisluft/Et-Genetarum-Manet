package de.heisluft.egm.event;

import de.heisluft.egm.items.ItemHammer;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GamePlayEventHandler {
	@SubscribeEvent
	public void addCrookAndHammerFunctionality(HarvestDropsEvent event) {
		if (event.getHarvester() != null && event.getHarvester().getHeldItemMainhand() != null) {
			final Item i = event.getHarvester().getHeldItemMainhand().getItem();
			final Block b = event.getState().getBlock();
			if (i instanceof ItemHammer)
				if (b == Blocks.COBBLESTONE) {
					event.getDrops().clear();
					event.getDrops().add(new ItemStack(Blocks.GRAVEL));
				} else if (b == Blocks.GRAVEL) {
					event.getDrops().clear();
					event.getDrops().add(new ItemStack(Blocks.SAND));
				} else if (b == Blocks.SAND)
					event.getDrops().clear();
		}
	}
}
