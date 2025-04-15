package dev.q4niel.natures_cauldron

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object NaturesCauldron: ModInitializer {
	fun print(value: String): Unit = _logger.info(value);

    private val _logger: Logger = LoggerFactory.getLogger("natures_cauldron");

	override fun onInitialize() {
		print("Hello Fabric world!");
	}
}