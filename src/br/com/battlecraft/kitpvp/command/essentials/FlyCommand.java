package br.com.battlecraft.kitpvp.command.essentials;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.api.CooldownAPI;
import br.com.battlecraft.kitpvp.api.KitAPI;
import br.com.battlecraft.kitpvp.api.TittleAPI;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.kits.KitResetor;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnWarpListener;

public final class FlyCommand extends Command {

	public FlyCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final ArrayList<Player> hasFly = new ArrayList<>();

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.fly")) {
			bp.sendMessage("                                                 ");
			bp.sendMessage("   §7O modo §e§lvoar§7 so pode ser usado por um  ");
			bp.sendMessage("  §7jogador com o grupo §a§lLIGHT§7 ou superior! ");
			bp.sendMessage("                                                 ");
			TittleAPI.sendTittle(bp, "§fAdiquira ja seu §6§lVIP");
			return true;
		}
		if (args.length >= 0) {
			if (hasFly.contains(bp)) {
				hasFly.remove(bp);
				bp.setAllowFlight(false);
				bp.setFlying(false);
				WarpsAPI.addPlayerInWarpByArgs(bp, "Spawn");
				KitResetor.resetPlayerKit(bp);
				KitAPI.setKit(bp, "Nenhum");
				CooldownAPI.removeCooldown(bp);
				LocationsConstructor.teleportToBattleWarpLocation(bp, "Spawn");
				WarpsAPI.loadWarpItensFromArgs(bp, "Spawn");
				TittleAPI.sendTittle(bp, "§7Modo §e§lvôo");
				TittleAPI.sendSubTittle(bp, "§f[OFF]");
				return true;
			} else if (!SpawnWarpListener.onWarpSpawnProtection.contains(bp)) {
				bp.sendMessage("§7Voce so pode usar o modo §e§lvoar§7 com proteçao de spawn.");
				return true;
			} else if (KitAPI.getKit(bp) != "Nenhum") {
				bp.sendMessage("§7Voce so pode usar o modo §e§lvoar§7 sem nenhum kit.");
				return true;
			} else {
				hasFly.add(bp);
				bp.getInventory().clear();
				bp.getInventory().setArmorContents(null);
				bp.setAllowFlight(true);
				bp.setFlying(true);
				bp.sendMessage("§7Voce agora esta no modo §e§lvôo§7!");
				TittleAPI.sendTittle(bp, "§7Modo §e§lvôo");
				TittleAPI.sendSubTittle(bp, "§f[ON]");
				return true;
			}
		}
		return false;
	}
}
