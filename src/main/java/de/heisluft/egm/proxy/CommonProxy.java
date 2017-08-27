package de.heisluft.egm.proxy;

import de.heisluft.egm.event.GamePlayEventHandler;
import de.heisluft.egm.init.Registry;
import de.heisluft.egm.items.ItemCrook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void addRenderRegister(ItemStack itemStack, ResourceLocation registryName, String string) {}
	
	public EntityPlayer getPlayer() {
		return null;
	}
	
	public void init(FMLInitializationEvent event) {}
	
	public void postInit(FMLPostInitializationEvent event) {
		ItemCrook.updateMinableBlocks();
	}
	
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new Registry());
		MinecraftForge.EVENT_BUS.register(new GamePlayEventHandler());
	}
}
