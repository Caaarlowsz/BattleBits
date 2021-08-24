package br.com.battlecraft.kitpvp.account;

import java.io.File;
import java.io.IOException;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;

public class XpAPI {

	/**
	 * API old (remade v1)
	 */

	public static File Xps;
	public static FileConfiguration Xp;

	public static void createFile() {
		Xps = new File("plugins/" + BukkitMain.getPlugin().getDataFolder().getName() + "/Status/Xps.yml");
		Xp = YamlConfiguration.loadConfiguration(Xps);
		saveXp();

	}

	public static void saveXp() {
		try {
			Xp.save(Xps);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void newXp(Player p) {
		if (!Xp.contains(p.getName())) {
			Xp.set(p.getName(), 0);
			saveXp();
		}
	}

	public static int getXp(Player p) {
		return (int) Xp.getInt(p.getName());
	}

	public static void addXp(Player p, int Qntd) {
		Xp.set(p.getName(), getXp(p) + Qntd);
		saveXp();
	}

	public static void removeXp(Player p, int Qntd) {
		Xp.set(p.getName(), getXp(p) - Qntd);
		saveXp();
	}

	public static int getXp(OfflinePlayer p) {
		return (int) Xp.getInt(p.getName());
	}

	public static void addXp(OfflinePlayer p, int Qntd) {
		Xp.set(p.getName(), getXp(p) + Qntd);
		saveXp();
	}

	public static void removeXp(OfflinePlayer p, int Qntd) {
		Xp.set(p.getName(), getXp(p) - Qntd);
		saveXp();
	}
}