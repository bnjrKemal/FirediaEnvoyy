package firediaenvoy.firediaenvoy;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FEListener implements Listener {

    @EventHandler
    public void onCustomEvent(CalendarEvent event){
        if(!event.getLabels().contains(uniqueEventLabel)){
            // not our event!
            return;
        }
        // it is our event!
        Bukkit.getServer().getLogger().info(" Example event was fired! Server time: " + event.getTime());
    }
}
