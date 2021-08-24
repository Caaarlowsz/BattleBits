package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.kits.Gladiator;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Spawn.MenusWarpSpawn;

public final class WarpCommand extends Command {

	public WarpCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final String[] warpsList = { "Spawn", "Fps", "1v1", "LavaChallenge", "Capiroto", "Evento",
			"Gladiator", "Hologram", "Halogram", "Holograma", "Hl", "Screenshare" };

	public static final boolean validWarpName(final String args) {
		for (String warps : warpsList) {
			if (args.equalsIgnoreCase(warps)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player battleplayer = (Player) sender;
		if (Gladiator.inFight.containsKey(battleplayer.getName())) {
			battleplayer.sendMessage("§3§lGLADIATOR§f Voce nao pode executar este comando em batalha!");
			return true;
		}
		if (FlyCommand.hasFly.contains(battleplayer)) {
			battleplayer
					.sendMessage("§7Voce so pode usar os comandos §c/tell, /report, /score e /fly§7 no modo §e§lvôo");
			return true;
		}
		if (args.length == 0 && args.length < 1) {
			MenusWarpSpawn.openWarpsMenuToBattlePlayer(battleplayer);
			return true;
		} else if (args.length == 1 && args.length < 2) {
			new WarpsAPI(battleplayer, WarpsAPI.convertWarpName(args[0]));
			return true;
		} else if (args.length > 1) {
			battleplayer.sendMessage("§e§lWARP§f Para escolher uma warp utilize: /warp ou /warp <warpName>");
			return true;
		}
		return false;
	}
}