package br.com.battlecraft.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import br.com.battlecraft.kitpvp.command.essentials.ChatCommand;
import br.com.battlecraft.kitpvp.command.essentials.StaffChatCommand;

public final class BattlePlayersChatFormatEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public final void onAnsyncPlayerChatEvent(final AsyncPlayerChatEvent e) {
		final Player gp = e.getPlayer();
		if (StaffChatCommand.onStaffChat(gp)) {
			e.setCancelled(true);
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (all.hasPermission("pvp.cmd.sc")) {
					all.sendMessage("§e§l(STAFF) " + gp.getDisplayName() + "§f: "
							+ e.getMessage().replace("%", "%%").replace("&", "§"));
				}
			}
		}
		if (!ChatCommand.chatMode) {
			if (!gp.hasPermission("pvp.beneficios.falarchat")) {
				e.setCancelled(true);
				gp.sendMessage("§4§lCHAT§f O chat está §c§ldesabilitado§f!");
				return;
			}
		}
		if (gp.hasPermission("pvp.beneficies.chatcolor")) {
			e.setFormat(gp.getDisplayName() + "§f: " + e.getMessage().replace("%", "%%").replace("&", "§"));
		} else {
			e.setFormat(gp.getDisplayName() + "§f: " + e.getMessage().replace("%", "%%"));
		}
	}
}