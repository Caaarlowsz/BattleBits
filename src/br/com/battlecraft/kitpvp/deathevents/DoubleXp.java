package br.com.battlecraft.kitpvp.deathevents;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;

public final class DoubleXp {

	public static final ArrayList<String> hasDoubleXp = new ArrayList<>();
	
	public static final void addPlayerDoubleXp(final Player bp) {
		if (AccountAPI.getBattlePlayerDoubleXp(bp) <= 0) {
			bp.sendMessage("§3§lDOUBLEXP§f Voce não §c§lPOSSUI NENHUM§3§l DOUBLEXP§f!");
			return;
		}
		if (hasDoubleXp.contains(bp.getName())) {
			bp.sendMessage("§3§lDOUBLEXP§f Você já está usando um §3§ldoublexp§f!");
			return;
		}
		AccountAPI.removeBattlePlayerDoubleXp(bp, 1);
		hasDoubleXp.add(bp.getName());
		bp.sendMessage("§3§lDOUBLEXP§f Você agora está usando um §3§ldoublexp§f por §c§l30 MINUTOS§f!");
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				if (hasDoubleXp.contains(bp.getName())) {
					hasDoubleXp.remove(bp.getName());
					if (bp.isOnline()) {
						bp.sendMessage("§3§lDOUBLEXP§f Seu tempo de §3§ldoublexp§f se §c§lESGOTOU§f! Use outro para ativar novamente.");
					}
				}
			}
		}, 36000L);
	}
}
