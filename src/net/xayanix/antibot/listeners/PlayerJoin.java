package net.xayanix.antibot.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.xayanix.antibot.basic.Main;
import net.xayanix.antibot.utils.BarUtils;
import net.xayanix.antibot.utils.RandomUtils;

public class PlayerJoin implements Listener{

	public static List<String> bossverified = new ArrayList<String>();
	public static List<String> underverify = new ArrayList<String>();
	public static List<String> correctcodes = new ArrayList<String>();

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		final Player player = event.getPlayer();
		if(bossverified.contains(player.getName())) return;

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			public void run() {
				String code = RandomUtils.randomCode();

				underverify.add(player.getName());
				correctcodes.add(code);

				BarUtils.set(player, Main.bossbarMessage.replace("{CODE}", code), 1, 20 * 120);

			}}, 30);
	}

}
