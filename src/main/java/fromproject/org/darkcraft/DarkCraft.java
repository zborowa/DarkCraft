/**
 * 
 */
package fromproject.org.darkcraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author AdrianZ
 *
 */
public class DarkCraft extends JavaPlugin {

	/**
	 * 
	 */
	private static Plugin instance;

	/**
	 * 
	 */
	@Override
	public void onEnable() {
		instance = this;
		
		// Create DarkCraft data folder if there is none
		DarkCraftDirectory.makeDarkCraftFolderStructure();
		
		// Event listeners
		getServer().getPluginManager().registerEvents(new DarkCraftListener(), this);

		// Existing players monitor
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			DarkCraftJson.createUserData(player);
		}

		/**
		 * Commands
		 */
		getCommand("helloworld").setExecutor(new DarkCraftCommandExecutor());
	}

	/**
	 * 
	 */
	@Override
	public void onDisable() {
		instance = null;
	}

	/**
	 * 
	 * @return
	 */
	public static Plugin getInstance() {
		return instance;
	}

}
