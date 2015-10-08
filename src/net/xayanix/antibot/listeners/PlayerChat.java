package net.xayanix.antibot.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.xayanix.antibot.basic.Main;
import net.xayanix.antibot.utils.BarUtils;

public class PlayerChat implements Listener{

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		if(event.isCancelled()) return;

		Player player = event.getPlayer();
		String message = event.getMessage();

		if(Main.bossbarCaptcha){
			if(PlayerJoin.bossverified.contains(player.getName())) return;
			if(PlayerJoin.underverify.contains(player.getName())){
				List<String> copy = new ArrayList<String>(PlayerJoin.correctcodes);
				for(String loop : copy){
					if(message.equals(loop)){
						PlayerJoin.bossverified.add(player.getName());
						PlayerJoin.correctcodes.remove(loop);
						PlayerJoin.underverify.remove(player.getName());
						BarUtils.remove(player);
						player.sendMessage(Main.bossSuccess);
						event.setCancelled(true);
						return;
					}
				}
			}
			event.setCancelled(true);
			player.sendMessage(Main.chatBlockedMessage);
		}

	}

}
