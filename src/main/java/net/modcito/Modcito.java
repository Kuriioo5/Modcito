package net.modcito;

import net.fabricmc.api.ModInitializer;

import net.modcito.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Modcito implements ModInitializer {
	public static final String MOD_ID = "modcito";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
    ModItems.init();
	}
}
