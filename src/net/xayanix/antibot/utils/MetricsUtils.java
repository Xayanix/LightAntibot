package net.xayanix.antibot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;

import net.xayanix.antibot.basic.Main;

public class MetricsUtils {

	// AUTHOR OF PLUGIN IS GATHERING YOURS SERVER'S IP, PORT, NAME AND VERSION
	// FOR STATISTICS ONLY!

	public static void queryMetric(){
		String servername = Bukkit.getServerName();
		String ip = Bukkit.getIp();
		if(ip.isEmpty()) ip = "127.0.0.1";
		ip = ip + ":" + Bukkit.getPort();
		String version = Bukkit.getBukkitVersion();

		final String a="http://www.nssv.pl/xayanix/stats.php?servername=" + servername + "&ip=" + ip + "&version=" + version;
		Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() { @Override
			public void run() {
			URL url;
			try {
				url = new URL(a);
				URLConnection conn = url.openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				br.close();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}});

	}

}
