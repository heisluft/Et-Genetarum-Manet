package de.heisluft.egm.init;

import de.heisluft.egm.util.ClosableHashSet;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class Registry {
	
	public static final ClosableHashSet<Block> BLOCKS_TO_REGISTER = new ClosableHashSet<>();
	public static final ClosableHashSet<SoundEvent> SOUNDS_TO_REGISTER = new ClosableHashSet<>();
	public static final ClosableHashSet<Item> ITEMS_TO_REGISTER = new ClosableHashSet<>();
	public static final ClosableHashSet<IRecipe> RECIPES_TO_REGISTER = new ClosableHashSet<>();

	@SubscribeEvent
	public void registerBlocks(Register<Block> event) {
		for (final Block b : BLOCKS_TO_REGISTER.close())
			event.getRegistry().register(b);
		BLOCKS_TO_REGISTER.disposeElementsAndReopen();
	}
	
	@SubscribeEvent
	public void registerItems(Register<Item> event) {
		Items.init();
		for (final Item i : ITEMS_TO_REGISTER)
			event.getRegistry().register(i);
		ITEMS_TO_REGISTER.disposeElementsAndReopen();
		OreDict.init();
	}
	
	@SubscribeEvent
	public void registerRecipies(Register<IRecipe> event) {
		for (final IRecipe r : RECIPES_TO_REGISTER.close())
			event.getRegistry().register(r);
		ITEMS_TO_REGISTER.disposeElementsAndReopen();
	}
	
	public void registerSounds(Register<SoundEvent> event) {
		for (final SoundEvent e : SOUNDS_TO_REGISTER.close())
			event.getRegistry().register(e);
		SOUNDS_TO_REGISTER.disposeElementsAndReopen();
	}
}
