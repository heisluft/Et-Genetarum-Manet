package de.heisluft.egm.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.heisluft.egm.block.ISpecialSnowflake;
import de.heisluft.egm.util.FluidStateMapper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientRegistry {

	public static final Map<ItemStack, ModelResourceLocation> MODELS_TO_REGISTER = new HashMap<>();

	private static void registerCustomFluidBlockRenderer(Fluid fluid) {
		final Block block = fluid.getBlock();
		final Item item = Item.getItemFromBlock(block);
		final FluidStateMapper mapper = new FluidStateMapper(fluid);
		ModelLoader.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, mapper);
		ModelLoader.setCustomStateMapper(block, mapper);
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event) {
		for (final Block b : Registry.BLOCKS_TO_REGISTER)
			if (b instanceof ISpecialSnowflake)
				((ISpecialSnowflake) b).registerRendering();
		for (final Entry<ItemStack, ModelResourceLocation> entry : MODELS_TO_REGISTER.entrySet())
			ModelLoader.setCustomModelResourceLocation(entry.getKey().getItem(), entry.getKey().getItemDamage(),
					entry.getValue());
	}
}
