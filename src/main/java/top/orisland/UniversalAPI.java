package top.orisland;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

public final class UniversalAPI extends JavaPlugin {
    public static final UniversalAPI INSTANCE = new UniversalAPI();

    private UniversalAPI() {
        super(new JvmPluginDescriptionBuilder("top.orisland.UniversalAPI", "0.1.0")
                .name("UniversalAPI")
                .author("Orisland")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded!");
    }
}