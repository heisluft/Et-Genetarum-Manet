package de.heisluft.egm.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDust extends BlockFalling {
	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

	public BlockDust() {
		setDefaultState(blockState.getBaseState().withProperty(VARIANT, EnumType.DUST));
	}

	public int damageDropped(IBlockState state) {
		return (state.getValue(VARIANT)).getMetadata();
	}

	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (EnumType enumType : EnumType.values())
			items.add(new ItemStack(this, 1, enumType.getMetadata()));
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.getValue(VARIANT).getMapColor();
	}

	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT);
	}

	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState state) {
		return state.getValue(VARIANT).getDustColor();
	}

	public enum EnumType implements IStringSerializable
	{
		DUST(0, "dust", "default", MapColor.SAND, -2370656),
		RED_DUST(1, "red_dust", "red", MapColor.ADOBE, -5679071);

		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
		private final String name;
		private final MapColor mapColor;
		private final String unlocalizedName;
		private final int dustColor;

		EnumType(int meta, String name, String unlocalizedName, MapColor mapColor, int dustColor)
		{
			this.meta = meta;
			this.name = name;
			this.mapColor = mapColor;
			this.unlocalizedName = unlocalizedName;
			this.dustColor = dustColor;
		}

		@SideOnly(Side.CLIENT)
		public int getDustColor() {
			return dustColor;
		}

		public int getMetadata() {
			return meta;
		}

		public String toString() {
			return name;
		}

		public MapColor getMapColor() {
			return mapColor;
		}

		public static EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length)
				meta = 0;
			return META_LOOKUP[meta];
		}

		public String getName() {
			return name;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}

		static {
			for (EnumType enumType : values())
				META_LOOKUP[enumType.getMetadata()] = enumType;
		}
	}
}
