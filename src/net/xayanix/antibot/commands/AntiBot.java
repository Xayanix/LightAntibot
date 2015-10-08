package net.xayanix.antibot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.xayanix.antibot.basic.Main;
import net.xayanix.antibot.utils.ConfigurationUtils;

public class AntiBot implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg3.length < 1){
			arg0.sendMessage("§aLightAntibot " + Main.version + "§7 by §aXayanix (UnixejPL).");
		}
		else if(arg0.hasPermission("lightantibot.admin")){
			String argument1 = arg3[0].toLowerCase();
			if(argument1.equals("reload")){
				ConfigurationUtils.loadConfiguration();
				arg0.sendMessage("§aKonfiguracja zostala przeladowana.");
				arg0.sendMessage("§aDla niektórych zmian wymagany jest restart serwera.");
				arg0.sendMessage(" ");
				arg0.sendMessage("§aConfiguration reloaded successfully.");
				arg0.sendMessage("§aFor some modifications You need fully restart server.");
			}
		}
		else arg0.sendMessage("§aLightAntibot " + Main.version + "§7 by §aXayanix (UnixejPL).");
		
		return true;
	}

}
