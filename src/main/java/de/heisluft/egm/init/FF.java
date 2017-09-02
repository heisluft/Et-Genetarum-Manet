package de.heisluft.egm.init;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class FF implements IConditionFactory, BooleanSupplier {
	
	@Override
	public boolean getAsBoolean() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		return this;
	}

}
