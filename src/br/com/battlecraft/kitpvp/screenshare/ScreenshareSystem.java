package br.com.battlecraft.kitpvp.screenshare;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.kits.Gladiator;
import br.com.battlecraft.kitpvp.scoreboard.Score;
import br.com.battlecraft.kitpvp.vanish.VanishSystem;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;

public final class ScreenshareSystem {

	public static final HashMap<Player, String> stafferSS = new HashMap<>();
	public static final HashMap<Player, String> playerSS = new HashMap<>();

	@SuppressWarnings("deprecation")
	public static final void runScreenshareSystem(final Player staffer, final Player ss) {
		if (stafferSS.containsKey(staffer)) {
			if (stafferSS.get(staffer) != ss.getName()) {
				staffer.sendMessage("§c§lSCREENSHARE§f Você não está telando este player.");
				return;
			}
			staffer.sendMessage("§c§lSCREENSHARE§f Liberando o jogador...");
			ss.sendMessage("§c§lSCREENSHARE§f Você está sendo liberado...");
			if (stafferSS.containsKey(staffer)) {
				stafferSS.remove(staffer);
			}
			if (playerSS.containsKey(ss)) {
				playerSS.remove(ss);
			}
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (all.hasPermission("pvp.cmd.ss")) {
					all.sendMessage("§c§lSCREENSHARE§f " + staffer.getName() + " §a§lLIBEROU§f o player §e"
							+ ss.getName() + "§f da §c§lscreenshare§f!");
				}
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
				@Override
				public void run() {
					new WarpsAPI(staffer, "Spawn");
					if (!VanishSystem.isVanished(staffer)) {
						if (staffer.hasPermission("pvp.cmd.admin")) {
							staffer.chat("/admin");
						}
					}
					new WarpsAPI(ss, "Spawn");
				}
			}, 40L);
			return;
		}
		if (playerSS.containsKey(ss)) {
			staffer.sendMessage("§c§lSCREENSHARE§f Este player já esta sendo telado.");
			return;
		}
		if (!LocationsConstructor.checkBattleWarpNotNull("Screenshare")) {
			staffer.sendMessage("§c§lSCREENSHARE§f O local para §c§lscreenshare§f ainda nao foi setado!");
			return;
		}
		if (VanishSystem.isVanished(staffer)) {
			VanishSystem.unsetVanished(staffer);
		}
		if (VanishSystem.isVanished(ss)) {
			VanishSystem.unsetVanished(ss);
		}
		if (!Score.hasScore.contains(ss)) {
			Score.hasScore.add(ss);
		}
		if (!Score.hasScore.contains(staffer)) {
			Score.hasScore.add(staffer);
		}
		if (X1WarpListener.firstMatch == ss.getUniqueId()) {
			X1WarpListener.firstMatch = null;
		}
		if (X1WarpListener.firstMatch == staffer.getUniqueId()) {
			X1WarpListener.firstMatch = null;
		}
		if (WarpsAPI.battlePlayerWarp.get(ss) == WarpsAPI.Warps.ONEVSONE && X1WarpListener.playerfigh.containsKey(ss)) {
			Player k = Bukkit.getPlayerExact(X1WarpListener.playerfigh.get(ss));
			X1WarpListener.fighting.remove(k);
			X1WarpListener.fighting.remove(ss);
			X1WarpListener.playerfigh.remove(ss);
			X1WarpListener.playerfigh.remove(k);
			X1WarpListener.defaultItens(k);
			LocationsConstructor.teleportToBattleWarpLocation(k, "1v1");
			for (int i = 6; i > 0; i--) {
				VanishSystem.playerHideShowMethod(ss);
				VanishSystem.playerHideShowMethod(k);
			}

			if (X1WarpListener.batalhando.containsKey(ss)) {
				X1WarpListener.batalhando.remove(ss);
			}
			if (X1WarpListener.batalhando.containsKey(k)) {
				X1WarpListener.batalhando.remove(k);
			}

			k.sendMessage("§c" + ss.getName() + " foi puxado para screenshare.");

			k.setHealth(20);
		}
		if (Gladiator.inFight.containsKey(ss.getName())) {
			final Player winner = Bukkit.getPlayerExact(Gladiator.inFight.get(ss.getName()));
			Gladiator.resetGladiatorByScreenshare(winner, ss);
		}
		WarpsAPI.battlePlayerWarp.put(staffer, WarpsAPI.Warps.SS);
		WarpsAPI.battlePlayerWarp.put(ss, WarpsAPI.Warps.SS);
		staffer.setHealth(20);
		ss.setHealth(20);
		Score.createScoreScreensharePlayer(ss);
		Score.createScoreScreenshareStaffer(staffer);
		VanishSystem.runVanishSystem(staffer);
		VanishSystem.runVanishSystem(ss);
		stafferSS.put(staffer, ss.getName());
		playerSS.put(ss, staffer.getName());
		WarpsAPI.resetPlayerWarps(staffer);
		WarpsAPI.resetPlayerWarps(ss);
		LocationsConstructor.teleportToBattleWarpLocation(staffer, "Screenshare");
		LocationsConstructor.teleportToBattleWarpLocation(ss, "Screenshare");
		ss.getInventory().clear();
		ss.getInventory().setArmorContents(null);
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (all.hasPermission("pvp.cmd.ss")) {
				all.sendMessage("§c§lSCREENSHARE§f " + staffer.getName() + " §c§lPUXOU§f o player §e" + ss.getName()
						+ "§f para §c§lscreenshare§f!");
			}
		}
		ss.sendMessage("§c§lSCREENSHARE§f Você foi puxado para §c§lscreenshare§f!");
		ss.sendMessage("§c§lSCREENSHARE§f Siga os passos do staffer §e§l" + staffer.getName()
				+ "§f para nao ter §c§lproblemas§f!");
		staffer.sendMessage("§c§lSCREENSHARE§f Você puxou o jogador §e§l" + ss.getName());
		Bukkit.broadcast("§c§lSCREENSHARE§f " + staffer.getName() + " puxou o player §e§l" + ss.getName()
				+ "§f para §c§lscreenshare§f!", "pvp.cmd.ss");
	}
}
