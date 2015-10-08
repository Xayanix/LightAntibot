package net.xayanix.antibot.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import net.xayanix.antibot.basic.Main;

public class ServerPing implements Listener{

	@EventHandler
	public void onPing(ServerListPingEvent event){
		String ip = event.getAddress().getHostAddress();
		if(Main.join.containsKey(ip)) Main.join.remove(ip);
		Main.join.put(ip, System.currentTimeMillis() + 5000);
	}

}
