/**
 * 
 */
package fromproject.org.darkcraft;

import java.io.File;

/**
 * @author AdrianZ
 *
 */
public class DarkCraftDirectory {

	private static final String pluginDir = "plugins/";
	private static final String pluginName = DarkCraft.class.getPackage().getImplementationTitle();
	private static final String pluginVersion = DarkCraft.class.getPackage().getImplementationVersion();

	public static void makeDarkCraftFolderStructure() {
		makeDarkCraftFolder();
		makeDarkCraftUserDataFolder();
	}

	/**
	 * 
	 */
	private static void makeDarkCraftFolder() {

		File dir = new File(pluginDir + pluginName + pluginVersion);

		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	private static void makeDarkCraftUserDataFolder() {

		String userDataPath = pluginDir + pluginName + pluginVersion + "/UserData";

		File dir = new File(userDataPath);

		if (!dir.exists()) {
			dir.mkdir();
		}
	}

}
