package firediaenvoy.firediaenvoy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class FirediaEnvoy extends JavaPlugin {

    static FirediaEnvoy main;

    static Object api;

    @Override
    public void onEnable() {
        //license();

        Utils.calenderEvents();

        if(!(Utils.haveSkyblockApi())){
            this.setEnabled(false);
            Bukkit.getLogger().log(Level.WARNING, "You must to have any skyblock plugin. This plugin has disabled!");
            return;
        }
        main = this;

        saveDefaultConfig();

        getCommand("firediaenvoy").setExecutor(new FECommand());

    }

    public void onDisable(){
        // You should remove your events here.
        api.removeEvent(uniqueEventLabel);
    }

}
