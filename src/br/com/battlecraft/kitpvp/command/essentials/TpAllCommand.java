package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.kits.Gladiator;
import br.com.battlecraft.kitpvp.screenshare.ScreenshareSystem;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.vanish.VanishSystem;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;

public final class TpAllCommand extends Command {

	public TpAllCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.tpall")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (!ScreenshareSystem.playerSS.containsKey(all) && !ScreenshareSystem.stafferSS.containsKey(all)) {
					Gladiator.resetGladiatorByTpAll(all, all);
					if (WarpsAPI.battlePlayerWarp.get(all) == WarpsAPI.Warps.ONEVSONE
							&& X1WarpListener.playerfigh.containsKey(all)) {
						Player on1v1 = Bukkit.getPlayerExact(X1WarpListener.playerfigh.get(all));
						X1WarpListener.fighting.remove(on1v1);
						X1WarpListener.fighting.remove(all);
						X1WarpListener.playerfigh.remove(on1v1);
						X1WarpListener.playerfigh.remove(all);
						for (int i = 6; i > 0; i--) {
							VanishSystem.playerHideShowMethod(all);
							VanishSystem.playerHideShowMethod(on1v1);
						}

						if (X1WarpListener.batalhando.containsKey(on1v1)) {
							X1WarpListener.batalhando.remove(on1v1);
						}
						if (X1WarpListener.batalhando.containsKey(all)) {
							X1WarpListener.batalhando.remove(all);
						}
					}
				}
				all.setHealth(20);
				all.teleport(bp);			
			}
			bp.sendMessage("§6§lTPALL§f Voce §e§lTELEPORTOU§f todos os jogadores para voce!");
			Bukkit.getServer().broadcastMessage("§6§lTPALL§f Todos os jogadores foram §e§lTELEPORTADOS§f para " + bp.getName());
			return true;
		}
		return false;
	}
}
