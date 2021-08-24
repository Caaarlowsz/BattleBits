package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.fakebattleplayer.FakeBattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class FakeRemoveCommand extends Command {

	public FakeRemoveCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.CommandOnlyInGame);
			return true;
		}
		final Player battleplayer = (Player) sender;
		if (!battleplayer.hasPermission("pvp.cmd.fake")) {
			battleplayer.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0 || args.length > 0) {
			if (!FakeBattlePlayerAPI.hasFakeName.contains(battleplayer)) {
				battleplayer.sendMessage("§c§lFAKEREMOVE§f Voce nao esta §3§lUTILIZANDO§f um fake.");
				return true;
			} else {
				FakeBattlePlayerAPI.resetBattlePlayerFakeName(battleplayer);
				battleplayer.sendMessage("§c§lFAKEREMOVE§f Seu nick voltou ao normal!");
				return true;
			}
		}
		return false;
	}
}