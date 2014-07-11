/**
 * 
 */
package fromproject.org.darkcraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * @author AdrianZ
 *
 */
public class DarkCraftListener implements Listener {

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		DarkCraftJson.createUserData(event.getPlayer());
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		DarkCraftJson.addUserDataDeathTotal(event.getEntity());
	}
}
