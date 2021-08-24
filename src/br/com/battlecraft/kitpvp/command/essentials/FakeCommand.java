package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.fakebattleplayer.FakeBattlePlayerAPI;
import br.com.battlecraft.kitpvp.fakebattleplayer.FakeBattlePlayerRandomAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class FakeCommand extends Command {

	public FakeCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final boolean f = false;

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player battleplayer = (Player) sender;
		if (!battleplayer.hasPermission("pvp.cmd.fake")) {
			battleplayer.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		} else if (!f) {
			battleplayer.sendMessage("§1§lFAKE§f Comando §c§ldesabilitado§f!");
			return true;
		} else if (args.length == 0 && args.length < 1) {
			battleplayer.sendMessage("§1§lFAKE§f Falsifique seu nick com: /fake <fakeNick> ou /fake random");
			return true;
		} else if (args.length == 1 && args.length < 2) {
			if (args[0].equalsIgnoreCase("random")) {
				FakeBattlePlayerRandomAPI.setRandomFakeToBattlePlayer(battleplayer);
				return true;
			} else {
				FakeBattlePlayerAPI.setBattlePlayerFakeName(battleplayer, args[0]);
				return true;
			}
		} else if (args.length > 1) {
			battleplayer.sendMessage("§1§lFAKE§f Falsifique seu nick com: /fake <fakeNick> ou /fake random");
			return true;
		}
		return false;
	}
}
