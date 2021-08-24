package br.com.battlecraft.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import br.com.battlecraft.kitpvp.combat.CombatSystem;
import br.com.battlecraft.kitpvp.deathevents.Status;
import br.com.battlecraft.kitpvp.kits.Gladiator;
import br.com.battlecraft.kitpvp.screenshare.ScreenshareSystem;
import br.com.battlecraft.kitpvp.vanish.VanishSystem;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Evento.EventoAPI;
import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;

public final class BattlePlayerQuitEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public final void onPlayerQuitEvent(final PlayerQuitEvent e) {
		e.setQuitMessage(null);
		final Player bp = e.getPlayer();
		WarpsAPI.resetPlayerWarps(bp);
		if (X1WarpListener.firstMatch == bp.getUniqueId()) {
			X1WarpListener.firstMatch = null;
		}
		if (EventoAPI.Players.contains(bp.getName())) {
			EventoAPI.Players.remove(bp.getName());
		}
		if (Gladiator.inFight.containsKey(bp.getName())) {
			final Player glader = Bukkit.getPlayerExact(Gladiator.inFight.get(bp.getName()));
			Gladiator.resetGladiatorByQuit(glader, bp);
			if (!CombatSystem.combat.containsKey(bp.getName())) {
				glader.sendMessage("§6§lKILL§f Você matou §e§l" + bp.getName());
				Status.addKillsToBattlePlayer(glader);
				Status.addMoneyToBattlePlayer(glader, 120);
				Status.addXpByXpToBattlePlayer(glader, bp);
				Status.addStreakToBattlePlayer(glader);

				Status.addDeathsToBattlePlayer(bp);
				Status.removeStreakFromBattlePlayer(bp, glader);
			}
		}
		if (CombatSystem.combat.containsKey(bp.getName())) {
			final Player killer = Bukkit.getPlayerExact(CombatSystem.combat.get(bp.getName()));

			killer.sendMessage("§6§lKILL§f Você matou §el" + bp.getName());
			Status.addKillsToBattlePlayer(killer);
			Status.addMoneyToBattlePlayer(killer, 120);
			Status.addXpByXpToBattlePlayer(killer, bp);
			Status.addStreakToBattlePlayer(killer);

			Status.addDeathsToBattlePlayer(bp);
			Status.removeStreakFromBattlePlayer(bp, killer);
		}
		if (ScreenshareSystem.stafferSS.containsKey(bp)) {
			final Player ss = Bukkit.getPlayer(ScreenshareSystem.stafferSS.get(bp));
			ScreenshareSystem.stafferSS.remove(bp);
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (all.hasPermission("pvp.cmd.ss")) {
					all.sendMessage("§c§lSCREENSHARE§f " + bp.getName() + " §c§lDESLOGOU§f enquanto telava o player §e"
							+ ss.getName());
				}
			}
			ss.sendMessage("§c§lSCREENSHARE§f O staffer §e§l" + bp.getName()
					+ "§f deslogou, portando voce foi liberado da §c§lscreenshare!");
			ScreenshareSystem.playerSS.remove(ss);
			new WarpsAPI(ss, "Spawn");
		}
		if (ScreenshareSystem.playerSS.containsKey(bp)) {
			final Player staffer = Bukkit.getPlayer(ScreenshareSystem.playerSS.get(bp));
			ScreenshareSystem.stafferSS.remove(staffer);
			ScreenshareSystem.playerSS.remove(bp);
			staffer.sendMessage("§c§lSCREENSHARE§f O player §e§l" + bp.getName() + "§f deslogou!");
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (all.hasPermission("pvp.cmd.ss")) {
					all.sendMessage("§c§lSCREENSHARE§f O player §e§l" + bp.getName() + "§f deslogou em §c§lscreenshare§f!");
				}
			}
			new WarpsAPI(staffer, "Spawn");
			if (!VanishSystem.isVanished(staffer)) {
				if (staffer.hasPermission("pvp.cmd.admin")) {
					staffer.chat("/admin");
				}
			}
		}
	}
}
