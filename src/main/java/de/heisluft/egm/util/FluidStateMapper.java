package de.heisluft.egm.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {
	private final Fluid fluid;
	public final ModelResourceLocation location;

	public FluidStateMapper(Fluid fluid) {
		this.fluid = fluid;

		location = new ModelResourceLocation(new ResourceLocation(Constants.MOD_ID, "fluids"), fluid.getName());
	}

	public Fluid getFluid() {
		return fluid;
	}

	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		return location;
	}

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		return location;
	}
}
