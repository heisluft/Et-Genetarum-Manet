package de.heisluft.egm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.heisluft.egm.init.Registry;
import de.heisluft.egm.proxy.CommonProxy;
import de.heisluft.egm.util.Constants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, version = Constants.VERSION, name = Constants.MOD_NAME, modLanguage = "java", useMetadata = true)
public class EtGeneratumManet {
	
	public static final Logger MAIN_LOG = LogManager.getLogger("MOD] [Et Generatum Manet");

	@SidedProxy(modId = Constants.MOD_ID, clientSide = Constants.CLIENT_PROXY, serverSide = Constants.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Instance
	public static EtGeneratumManet instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {}
	
	@EventHandler
	public void onIMC(IMCEvent event) {}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new Registry());
		proxy.preInit(event);
	}
}
