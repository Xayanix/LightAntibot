package net.xayanix.antibot.task;

import org.bukkit.Bukkit;

import net.xayanix.antibot.basic.Main;

public class ThrottleTask implements Runnable{

	@Override
	public void run() {
		Main.count = 0;
	}

	public void start(){
		Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), this, 20, 20);
	}

}
