package de.heisluft.egm.items;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import de.heisluft.egm.EtGeneratumManet;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCrook extends ItemTool {
	public static enum Variation {
		WOOD("wooden_crook", ToolMaterial.WOOD), BONE("bone_crook", ToolMaterial.STONE);
		
		private final String name;
		private final ToolMaterial material;
		
		private Variation(String name, ToolMaterial material) {
			this.material = material;
			this.name = name;
		}
		
		public ToolMaterial getMaterial() {
			return material;
		}
		
		public String getName() {
			return name;
		}
	}
	
	private static final Set<Block> effectiveBlocks = Sets.<Block>newHashSet();
	
	{
		effectiveBlocks.add(Blocks.LEAVES);
		effectiveBlocks.add(Blocks.LEAVES2);
	}
	
	public ItemCrook(Variation var) {
		super(var.getMaterial(), effectiveBlocks);
		setUnlocalizedName(var.getName());
		setRegistryName(var.getName());
		setCreativeTab(null);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		if (effectiveBlocks.contains(state.getBlock()) && !worldIn.isRemote) {
			EtGeneratumManet.MAIN_LOG.info(state.getBlock().getMetaFromState(state));
			final EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
			final Random r = new Random();
			if (r.nextInt(20) == 2)
				worldIn.spawnEntity(item);
		}
		return true;
	}
}
