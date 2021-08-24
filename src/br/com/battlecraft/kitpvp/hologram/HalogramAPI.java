package br.com.battlecraft.kitpvp.hologram;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.XpAPI;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.leagues.Leagues;

public final class HalogramAPI {

	public static final String getColorTopPlayer(final int i) {
		if (i == 1) {
			return "§a";
		} else if (i == 2) {
			return "§e";
		} else if (i == 3) {
			return "§c";
		} else {
			return "§f";
		}
	}

	public static final ArrayList<String> HologramMsg() {
		final ArrayList<String> hl = new ArrayList<String>();
		hl.add("§8§m--§b§m]---§f §6§lBattle§f§lBits | §dMinecraft KitPvP §b§m---[§8§m--§f");
		hl.add("");
		hl.add("§fSeja §a§lbem-vindo§f a nossa rede de §6§lPVP§f!");
		hl.add("§fOferecemos muita §d§lDIVERSAO§f, §b§lQUALIDADE§f e §a§lDEDICAMENTO§f á você.");
		hl.add("§fVocê pode adiquirir §a§lbeneficios§f com §e§lPAY TO WIN§f ou §6§lPLAY TO WIN§f,");
		hl.add("§fIsso é, adiquirindo §6§lVIP§f ou apenas §e§ljogando§f no servidor!");
		hl.add("");
		hl.add("§fConheça nossas §e§lWARPS§f, §3§lKITS§f, §6§lMENUS§f,");
		hl.add("§3§lTAGS ESPECIAIS§f e mais no §3§lSPAWN§f!");
		hl.add("");
		hl.add("§fMais informações em §b@BattleBitsMC");
		return hl;
	}

	public static final ArrayList<String> TopXP() {
		HashMap<String, Integer> players = new HashMap<String, Integer>();
		final ArrayList<String> top = new ArrayList<String>();
		top.add("§b§lTOP 10 RANK");
		top.add("§fO rank é ordenado de acordo");
		top.add("§fcom o player com mais XP");
		top.add("");
		for (String playerName : XpAPI.Xp.getKeys(false)) {
			players.put(playerName, XpAPI.Xp.getInt(playerName));
		}

		String nextTop = "None";
		Integer nextTopKills = 0;

		for (int i = 1; i < 11; i++) {
			for (String playerName : players.keySet()) {
				if (players.get(playerName) > nextTopKills) {
					nextTop = playerName;
					nextTopKills = players.get(playerName);
				}
			}
			top.add(getColorTopPlayer(i) + i + ". " + nextTop + " §7| "
					+ Leagues.getBattlePlayerLeagueByXp(nextTopKills) + " §7| §b" + nextTopKills + " XP");
			players.remove(nextTop);
			nextTop = "None";
			nextTopKills = 0;
		}
		return top;
	}

	public static final HashMap<String, Hologram> holograma = new HashMap<>();

	public static void addHalogram(final Location loc, final String text[]) {
		Hologram hologram = new Hologram(text[0], getFrontLocation(loc), false);
		for (int i = 1; i < text.length; i++) {
			hologram.addLine(text[i]);
		}
		holograma.put("hl", hologram);
	}

	public static final ArrayList<Hologram> holograms = new ArrayList<>();

	@SuppressWarnings("deprecation")
	public static void simpleHologram(final Location loc, final String text[]) {
		Hologram hologram = new Hologram(text[0], getFrontLocation(loc), false);
		for (int i = 1; i < text.length; i++) {
			hologram.addLine(text[i]);
		}
		for (Player all : Bukkit.getOnlinePlayers()) {
			hologram.show(all);
		}
		holograms.add(hologram);
	}

	public static final void spawnHologram(final Player p) {
		final ArrayList<String> hl = HologramMsg();
		final Location spawn = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 1,
				p.getLocation().getBlockZ());
		simpleHologram(spawn, hl.toArray(new String[] {}));
	}

	public static final ArrayList<Player> canSee = new ArrayList<>();

	public static boolean hasHologramTopXp = false;

	public static int tasked;

	@SuppressWarnings("deprecation")
	public static final void removeoldXpHologramLocation() {
		Bukkit.getScheduler().cancelTask(tasked);
		Hologram hl = holograma.get("hl");
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (canSee.contains(all)) {
				hl.hide(all);
			}
		}
		hl.remove();
		topXpHologramLoader();
	}

	@SuppressWarnings("deprecation")
	public static final void topXpHologramLoader() {
		if (!LocationsConstructor.checkBattleWarpNotNull("Hologram")) {
			Bukkit.getConsoleSender()
					.sendMessage("§a§lHOLOGRAM TOP XP§f Você precisa setar o local §a§lhologram§f com /set hl");
			return;
		}
		addHalogram(LocationsConstructor.getBattleWarpLocation("Hologram"), TopXP().toArray(new String[] {}));
		Hologram hl = holograma.get("hl");
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (canSee.contains(all)) {
				hl.show(all);
			}
		}
		tasked = Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				Hologram hl = holograma.get("hl");
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (canSee.contains(all)) {
						hl.hide(all);
					}
				}
				hl.remove();
				topXpHologramLoader();
			}
		}, 1200L);
	}

	private static final Location getFrontLocation(Location loc) {
		return loc.toVector().add(loc.getDirection().multiply(1).subtract(new Vector(0, 1, 0)))
				.toLocation(loc.getWorld());
	}
}
