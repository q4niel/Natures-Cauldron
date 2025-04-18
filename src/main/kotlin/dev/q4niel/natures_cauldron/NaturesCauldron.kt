package dev.q4niel.natures_cauldron

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.server.MinecraftServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object NaturesCauldron: ModInitializer {
	val MOD_ID: String = "natures_cauldron";

	fun print(value: String): Unit = _logger.info(value);
    private val _logger: Logger = LoggerFactory.getLogger(MOD_ID);

	fun serverExec(runnable: Runnable): Unit? = _server?.execute(runnable);
	private var _server: MinecraftServer? = null;

	fun getRuntimeConfig(): RuntimeConfig? = _runtimeConfig;
	private var _runtimeConfig: RuntimeConfig? = null;

	override fun onInitialize(): Unit {
		_runtimeConfig = RuntimeConfig();

		ServerLifecycleEvents.SERVER_STARTED.register {
			server: MinecraftServer ->
			_server = server;
		};
	}
}