package net.xayanix.antibot.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import net.xayanix.antibot.basic.Main;
import net.xayanix.antibot.utils.ProxyUtils;

public class PlayerLogin implements Listener{

	private List<String> notproxy = new ArrayList<String>();

	@EventHandler
	public void onLogin(AsyncPlayerPreLoginEvent event) throws Exception{
		String ip = event.getAddress().getHostAddress();
		
		if(Main.proxyCheck && !notproxy.contains(ip)){
			if (!ProxyUtils.ProxyCheck(ip, "http://www.stopforumspam.com/api?ip=", "yes").booleanValue()) notproxy.add(ip);
			else{
				event.disallow(Result.KICK_OTHER, Main.proxyMessage);
				return;
			}
		}

		if(Main.count > Main.limitPerSecond && Main.limitPerSecond != -1){
			event.disallow(Result.KICK_OTHER, Main.throttleMessage);
			return;
		}

		if(Main.serverPing){
			if(Main.join.containsKey(ip)){
				Long time = Main.join.get(ip);
				if(time > System.currentTimeMillis()){
					Main.count++;
					return;
				}
			}
			event.disallow(Result.KICK_OTHER, Main.message);
		}
	}
}
