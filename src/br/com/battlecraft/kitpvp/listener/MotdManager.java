package br.com.battlecraft.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import br.com.battlecraft.kitpvp.BukkitMain;

public final class MotdManager implements Listener {

	public static final String Motd1() {
		return "            §8§m  §b§m ]   §f §6§lBattle§f§lBits§f | §dMinecraft PvP §b§m   [ §8§m  §f \n"
				+ "                  §f§lNOVIDADE - §6§lV2";
	}

	public static final String Motd2() {
		return "            §8§m  §b§m ]     §f §6§lBattle§f§lBits§f | §dMinecraft PvP §b§m     [ §8§m  §f \n"
				+ "                  §e§lSEASON 2 §6§lBATTLE§f§lBITS §4§lRANKED";
	}

	public static boolean AnimatedMotd = true;

	public static int task = 1;
	public static String motd = Motd1();

	public static final void updateMotd() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				runMotd();
			}
		}, 0, 200L);
	}

	public static final void runMotd() {
		if (task == 1) {
			motd = Motd1();
		}
		if (task == 2) {
			motd = Motd2();
			task = 0;
		}
		task++;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public final void onServerPingListEvent(final ServerListPingEvent e) {
		e.setMaxPlayers(Bukkit.getOnlinePlayers().length + 1);

		if (AnimatedMotd) {
			e.setMotd(motd);
		} else {
			e.setMotd("§8§m  §b§m ]   §f §6§lBattle§f§lBits§f | §dMinecraft PvP §b§m   [ §8§m  §f \n"
					+ "        §f§lNOVIDADE - §6§lV2");
		}
	}
}
