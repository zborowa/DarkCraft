/**
 * 
 */
package fromproject.org.darkcraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * @author AdrianZ
 *
 */
public class DarkCraftCommandExecutor implements CommandExecutor {

	@SuppressWarnings("unused")
	private Plugin instance = DarkCraft.getInstance();
	
	/* (non-Javadoc)
	 * @see org.bukkit.command.CommandExecutor#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		switch(label){
		case "helloworld":
			sayHelloWorld(sender);
			return true;
		}
		
		return false;
	}
	
	private boolean sayHelloWorld(CommandSender sender){
		
		sender.sendMessage("Hello World!");
		
		return true;
	}

}
