package br.com.battlecraft.kitpvp.listener;

import java.net.InetAddress;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.account.AccountConstructor;
import br.com.battlecraft.kitpvp.account.AccountFile;
import br.com.battlecraft.kitpvp.account.AccountManager;
import br.com.battlecraft.kitpvp.account.KillsAPI;
import br.com.battlecraft.kitpvp.account.XpAPI;
import br.com.battlecraft.kitpvp.api.KitAPI;
import br.com.battlecraft.kitpvp.api.TittleAPI;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.hologram.HalogramAPI;
import br.com.battlecraft.kitpvp.hologram.Hologram;
import br.com.battlecraft.kitpvp.nametags.BattleNametagAPI;
import br.com.battlecraft.kitpvp.scoreboard.Score;
import br.com.battlecraft.kitpvp.vanish.VanishSystem;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnWarpListener;

public final class BattlePlayerJoinServerEvents implements Listener {

	public static final HashMap<String, InetAddress> macAddress = new HashMap<>();

	public static final HashMap<String, String> NAME = new HashMap<>();

	public static boolean hasHologram = false;

	@EventHandler
	public final void onPlayerLoginEvent(final PlayerLoginEvent e) {
		final Player bp = e.getPlayer();
		KillsAPI.newKills(bp);
		XpAPI.newXp(bp);
		if (!AccountManager.hasAccount(bp.getName())) {
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".UniqueID",
					bp.getUniqueId().toString());
			AccountFile.getAccountsFile()
					.set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".OficialNickName", bp.getName());
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Kills", 0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Deaths", 0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".KillStreak",
					0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Xp", 0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".DoubleXp", 0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Money", 0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Cash", 0);
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".FirstLogin",
					AccountConstructor.BrasilHour());
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".LastLogin",
					AccountConstructor.BrasilHour());
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Type",
					"Gamer");
			AccountFile.getAccountsFile()
					.set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".YoutubeChannel", "Nenhum");
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Twitter",
					"Nenhum");
			AccountFile.getAccountsFile().set(AccountConstructor.Prefix + bp.getName().toLowerCase() + ".Email",
					"Nenhum");
			AccountFile.saveAccountsFile();
		}
	}

	@EventHandler
	public final void onPlayerJoinEvent(final PlayerJoinEvent e) {
		if (!hasHologram) {
			hasHologram = true;
			HalogramAPI.topXpHologramLoader();
		}
		final Player battleplayer = e.getPlayer();
		if (!HalogramAPI.canSee.contains(battleplayer)) {
			HalogramAPI.canSee.add(battleplayer);
		}
		for (Hologram hl : HalogramAPI.holograms) {
			if (hl != null) {
				hl.show(battleplayer);
			}
		}

		Hologram hl = HalogramAPI.holograma.get("hl");
		if (hl != null) {
			hl.show(battleplayer);
		}

		KitAPI.setKit(battleplayer, "Nenhum");
		AccountFile.getAccountsFile().set(
				AccountConstructor.Prefix + battleplayer.getName().toLowerCase() + ".LastLogin",
				AccountConstructor.BrasilHour());
		AccountFile.saveAccountsFile();
		battleplayer.setGameMode(GameMode.SURVIVAL);
		e.setJoinMessage(null);
		Score.hasScore.add(battleplayer);
		VanishSystem.runVanishSystem(battleplayer);
		LocationsConstructor.teleportToBattleWarpLocation(battleplayer, "Spawn");
		SpawnWarpListener.loadWarpSpawnMethods(battleplayer);
		AccountAPI.updateLastLogin(BattlePlayerAPI.BattlePlayer(battleplayer));
		BattleNametagAPI.loadBattlePlayerTagFromJoin(battleplayer);
		for (PotionEffect effect : battleplayer.getActivePotionEffects()) {
			battleplayer.removePotionEffect(effect.getType());
		}
		for (int i = 1; i < 50; i++) {
			battleplayer.sendMessage(" ");
		}
		battleplayer.sendMessage("   §9§lConectando§7 ao servidor §9§lKitPvP§7!");
		battleplayer.sendMessage("    ");
		battleplayer.sendMessage("    ");
		battleplayer.sendMessage("           §6§lBattleCraft - KitPvP§6              ");
		battleplayer.sendMessage("§7");
		battleplayer.sendMessage("            §7Olá, §e§l" + battleplayer.getName() + "§7!   ");
		battleplayer.sendMessage("         §7Seja §e§lbem vindo§7 ao nosso servidor!     ");
		battleplayer.sendMessage("     §7Houve uma §e§lgrande atualizaçao§7 em nossos Plugins!  ");
		battleplayer.sendMessage("               §7Garantimos sua §e§ldiversao§7 aqui!                  ");
		battleplayer.sendMessage("              §7Tenha um §e§lotimo jogo§7!                   ");
		battleplayer.sendMessage("§e");
		battleplayer.sendMessage("§7- §fCompre beneficios ou VIPs em: §6§lbattlebits.com.br");
		battleplayer.sendMessage("§7- §fMais informaçoes em: §b@BattleBitsMC");
		battleplayer.sendMessage("§e");
		TittleAPI.sendActionBar(battleplayer, "§7Conectado ao §3§la1.fulliron.battlebits.com.br");
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				TittleAPI.sendTittle(battleplayer, "§6BATTLECRAFT");
				TittleAPI.sendSubTittle(battleplayer, "§fVersão 2.0");
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				TittleAPI.sendTittle(battleplayer, "§6BATTLECRAFT");
				TittleAPI.sendSubTittle(battleplayer, "§fGrande atualização");
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				TittleAPI.sendTittle(battleplayer, "§6BATTLECRAFT");
				TittleAPI.sendSubTittle(battleplayer, "§fNovo mapa");
			}
		}, 70L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				TittleAPI.sendTittle(battleplayer, "§6BATTLECRAFT");
				TittleAPI.sendSubTittle(battleplayer, "§fNovos plugins");
			}
		}, 90L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				TittleAPI.sendTittle(battleplayer, "§6BATTLECRAFT");
				TittleAPI.sendSubTittle(battleplayer, "§fSeja bem vindo");
			}
		}, 110L);
	}
}