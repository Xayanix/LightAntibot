package net.xayanix.antibot.utils;

import net.xayanix.antibot.basic.Main;

public class ConfigurationUtils {

	public static void defaultConfiguration(){
		Main.getInstance().getConfig().addDefault("messages.pingMessage", "&cAby wejsc na ten serwer musisz zostac zweryfikowanym.(N)&cDodaj serwer na liste i odswiez ja, aby wejsc.");
		Main.getInstance().getConfig().addDefault("options.limitJoinsPerSeconds", 5);
		Main.getInstance().getConfig().addDefault("messages.throttleMessage", "&cZbyt wiele osob loguje sie w jednej chwili.");
		Main.getInstance().getConfig().addDefault("options.bossbarCaptcha", false);
		Main.getInstance().getConfig().addDefault("options.serverPing", true);
		Main.getInstance().getConfig().addDefault("messages.bossbarMessage", "&7Napisz na czacie &a{CODE}&7, aby go odblokowac.");
		Main.getInstance().getConfig().addDefault("messages.chatBlockedMessage", "&cCzat jest zablokowany. Przepisz poprawnie kod z paska smoka aby go odblokowac.");
		Main.getInstance().getConfig().addDefault("messages.bossSuccess", "&aUdalo Ci sie poprawnie przepisac kod.");
		Main.getInstance().getConfig().addDefault("options.proxyCheck", false);
		Main.getInstance().getConfig().addDefault("messages.proxyMessage", "&cNie mozesz uzywac serwerow proxy aby wejsc na ten serwer.");
		Main.getInstance().getConfig().options().copyDefaults(true);
		Main.getInstance().saveConfig();

		Main.message = "&cAby wejsc na ten serwer musisz zostac zweryfikowanym.(N)&cDodaj serwer na liste i odswiez ja, aby wejsc.".replace("&", "§").replace("(N)", "\n");
		Main.limitPerSecond = 5;
		Main.throttleMessage = "&cZbyt wiele osob loguje sie w jednej chwili.".replace("&", "§").replace("(N)", "\n");
		Main.bossbarCaptcha = false;
		Main.proxyCheck = false;
		Main.bossbarMessage = "&7Napisz na czacie &a{CODE}&7, aby go odblokowac.".replace("&", "§").replace("(N)", "\n");
		Main.chatBlockedMessage = "&cCzat jest zablokowany. Przepisz poprawnie kod z paska smoka aby go odblokowac.".replace("&", "§").replace("(N)", "\n");
		Main.bossSuccess = "&aUdalo Ci sie poprawnie przepisac kod.".replace("&", "§").replace("(N)", "\n");
		Main.proxyMessage = "&cNie mozesz uzywac serwerow proxy aby wejsc na ten serwer.".replace("&", "§").replace("(N)", "\n");
		Main.serverPing = true;
	}

	public static void loadConfiguration(){
		Main.message = Main.getInstance().getConfig().getString("messages.pingMessage").replace("&", "§").replace("(N)", "\n");
		Main.throttleMessage = Main.getInstance().getConfig().getString("messages.throttleMessage").replace("&", "§").replace("(N)", "\n");
		Main.limitPerSecond = Main.getInstance().getConfig().getInt("options.limitJoinsPerSeconds");
		Main.bossbarCaptcha =  Main.getInstance().getConfig().getBoolean("options.bossbarCaptcha");
		Main.proxyCheck =  Main.getInstance().getConfig().getBoolean("options.proxyCheck");
		Main.bossbarMessage = Main.getInstance().getConfig().getString("messages.bossbarMessage").replace("&", "§").replace("(N)", "\n");
		Main.chatBlockedMessage = Main.getInstance().getConfig().getString("messages.chatBlockedMessage").replace("&", "§").replace("(N)", "\n");
		Main.bossSuccess = Main.getInstance().getConfig().getString("messages.bossSuccess").replace("&", "§").replace("(N)", "\n");
		Main.proxyMessage = Main.getInstance().getConfig().getString("messages.proxyMessage").replace("&", "§").replace("(N)", "\n");
		Main.serverPing = Main.getInstance().getConfig().getBoolean("options.serverPing");
		
		Main.info("Configuration loaded.");
	}

}
