package net.xayanix.antibot.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.bukkit.Bukkit;

import net.minecraft.util.org.apache.commons.io.FileUtils;
import net.xayanix.antibot.basic.Main;

public class UpdateUtils {

	public static Boolean needUpdate(){
		Boolean need = false;
		try {
			URL url = new URL("http://www.nssv.pl/xayanix/update.txt");
			Scanner s = new Scanner(url.openStream());
			if(s.hasNext()){
				if(!s.next().equals(Main.version)) need = true;
			}
			s.close();
		}
		catch(IOException e) {
			Main.warn("Could not check newest version of plugin.");
			e.printStackTrace();
		}
		return need;
	}

	public static void doUpdate(){
		String path = Bukkit.getPluginManager().getPlugin("LightAntibot").getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		File file = new File(path);		
		try {
			URL url = new URL("http://www.nssv.pl/xayanix/LightAntibot.jar");
			FileUtils.copyURLToFile(url, file);
			Main.info("Plugin updated! Restart server to perform changes.");
		} catch (IOException e) {
			Main.warn("Could not update plugin! Try doing this manually.");
			e.printStackTrace();
		}
	}

}
