package de.heisluft.egm.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.heisluft.egm.items.ItemHammer;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Registry {

	private static final Logger eventlog = LogManager.getLogger("Et Generatum Manet] [Events");
	
	@SubscribeEvent
	public void registerItems(Register<Item> event) {
		eventlog.info(Items.WOODEN_CROOK.getUnlocalizedName());
		event.getRegistry().registerAll(Items.WOODEN_CROOK, Items.DIAMOND_HAMMER, Items.GOLDEN_HAMMER,
				Items.IRON_HAMMER, Items.STONE_HAMMER, Items.WOODEN_HAMMER, Items.BONE_CROOK);
	}

	@SubscribeEvent
	public void s(HarvestDropsEvent event) {
		if (event.getHarvester() != null
				&& event.getHarvester().getHeldItemMainhand().getItem() instanceof ItemHammer) {
			final Block b = event.getState().getBlock();
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
