package firediaenvoy.firediaenvoy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FECommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            FirediaEnvoy.main.reloadConfig();
            sender.sendMessage(FirediaEnvoy.main.getConfig().getString("reload").replace("{prefix}", FirediaEnvoy.main.getPrefix()));
            return false;
        }

        Player player = (Player) sender;

        int i = 0;
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if(itemStack == null) continue;
            FirediaEnvoy.main.getConfig().set("items." + (++i), itemStack);
        }

        FirediaEnvoy.main.saveConfig();
        player.sendMessage(FirediaEnvoy.main.getConfig().getString("reload-rewards").replace("{prefix}", FirediaEnvoy.main.getPrefix()));

        return false;
    }
}
