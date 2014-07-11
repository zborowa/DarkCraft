/**
 * 
 */
package fromproject.org.darkcraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author AdrianZ
 *
 */
public class DarkCraftJson {

	private static String path = "plugins/" + DarkCraft.class.getPackage().getImplementationTitle()
			+ DarkCraft.class.getPackage().getImplementationVersion() + "/UserData";

	/**
	 * 
	 * @param player
	 */
	@SuppressWarnings("unchecked")
	public static void createUserData(Player player) {

		File fileCheck = new File(path + "/" + player.getPlayerListName() + ".json");

		if (!fileCheck.exists()) {
			JSONObject obj = new JSONObject();
			obj.put(new String("name"), new String(player.getPlayerListName()));
			obj.put(new String("deathTotal"), new Integer(0));
			obj.put(new String("killTotal"), new Integer(0));
			obj.put(new String("innocentKillTotal"), new Integer(0));
			obj.put(new String("guiltyKillTotal"), new Integer(0));
			obj.put(new String("maxHealth"), new Double(20.0));

			try {
				FileWriter file = new FileWriter(path + "/" + player.getPlayerListName() + ".json");
				file.write(obj.toJSONString());
				file.flush();
				file.close();
				obj.clear();
				obj = null;
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		fileCheck = null;
	}

	@SuppressWarnings("unchecked")
	public static void addUserDataDeathTotal(Player player){
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(path + "/" + player.getPlayerListName() + ".json"));
			JSONObject jsonObject = (JSONObject) obj;

			Long deathTotal = (Long) jsonObject.get("deathTotal");
			jsonObject.remove("deathTotal");
			jsonObject.put("deathTotal", ++deathTotal);
			
			FileWriter file = new FileWriter(path + "/" + player.getPlayerListName() + ".json");
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
			jsonObject.clear();
			jsonObject = null;
			obj = null;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void readUserData(Player player) {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(path + "/" + player.getPlayerListName() + ".json"));
			JSONObject jsonObject = (JSONObject) obj;

			String name = (String) jsonObject.get("name");
			Integer deathTotal = (Integer) jsonObject.get("deathTotal");
			Integer killTotal = (Integer) jsonObject.get("killTotal");
			Integer innocentKillTotal = (Integer) jsonObject.get("innocentKillTotal");
			Integer guiltyKillTotal = (Integer) jsonObject.get("guiltyKillTotal");
			Double maxHealth = (Double) jsonObject.get("maxHealth");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
