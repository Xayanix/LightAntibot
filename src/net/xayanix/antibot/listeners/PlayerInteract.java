package net.xayanix.antibot.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.xayanix.antibot.basic.Main;

public class PlayerInteract implements Listener{

	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		String ip = player.getAddress().getAddress().getHostAddress();

		if(!Main.verified.contains(ip)){
			Main.verified.add(ip);
		}

	}

}
