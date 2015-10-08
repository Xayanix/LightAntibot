package net.xayanix.antibot.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.xayanix.antibot.commands.AntiBot;
import net.xayanix.antibot.listeners.PlayerChat;
import net.xayanix.antibot.listeners.PlayerInteract;
import net.xayanix.antibot.listeners.PlayerJoin;
import net.xayanix.antibot.listeners.PlayerLogin;
import net.xayanix.antibot.listeners.ServerPing;
import net.xayanix.antibot.task.ThrottleTask;
import net.xayanix.antibot.utils.ConfigurationUtils;
import net.xayanix.antibot.utils.MetricsUtils;
import net.xayanix.antibot.utils.UpdateUtils;

public class Main extends JavaPlugin implements Listener{

	private static Main instance;

	public static String message;
	public static String throttleMessage;
	public static String bossbarMessage;
	public static String chatBlockedMessage;
	public static String proxyMessage;
	public static String bossSuccess;
	public static String version = "1.29"; // I KNOW, I SHOULD GET THIS FROM PLUGIN.YML

	public static int count = 0;
	public static int limitPerSecond = 5;

	public static boolean bossbarCaptcha;
	public static boolean proxyCheck;
	public static boolean serverPing;

	public static HashMap<String, Long> join = new HashMap<String, Long>();
	public static List<String> verified = new ArrayList<String>();


	public void onEnable(){

		instance = this;

		if(Bukkit.getPluginManager().getPlugin("LightAntibot") == null){
			Bukkit.shutdown();
			warn("Name of plugin changed! Shutting down server...");
			return;
		}

		ConfigurationUtils.defaultConfiguration();
		ConfigurationUtils.loadConfiguration();

		Bukkit.getPluginManager().registerEvents(new PlayerChat(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
		if(bossbarCaptcha) Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLogin(), this);
		if(serverPing) Bukkit.getPluginManager().registerEvents(new ServerPing(), this);
		
		getCommand("antibot").setExecutor(new AntiBot());

		new ThrottleTask().start();
		if(UpdateUtils.needUpdate()) UpdateUtils.doUpdate();

		info("Enabled (v" + version + ").");

		MetricsUtils.queryMetric();
	}

	public void onDisable(){
		info("Disabled.");
	}


	public static Main getInstance(){
		if(instance == null) instance = new Main();
		return instance;
	}

	public static void info(String info){
		System.out.println("[LightAntibot] " + info);
	}

	public static void warn(String warn){
		System.err.println("[LightAntibot] " + warn);
	}

}
