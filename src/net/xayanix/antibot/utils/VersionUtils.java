package net.xayanix.antibot.utils;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class VersionUtils {

	public static Integer getVersion(Player player){
		int ver = 0;
		CraftPlayer craftPlayer = (CraftPlayer)player;
		ver = Integer.valueOf(craftPlayer.getHandle().playerConnection.networkManager.getVersion());
		return ver;
	}

}
