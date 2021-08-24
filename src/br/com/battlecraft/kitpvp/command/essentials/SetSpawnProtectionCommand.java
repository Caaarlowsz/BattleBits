package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class SetSpawnProtectionCommand extends Command {

	public SetSpawnProtectionCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.setspawnprotection")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage(" ");
			sender.sendMessage("�8�lPROTE�AO�f Utilize: /setspawnprotection <spawn/fps> (distancia)");
			sender.sendMessage(
					"�e�lEXEMPLO�f /setspawnprotection spawn 15 �e�l(setei a prote��o da warp spawn para 15 blocos de distancia)");
			sender.sendMessage(" ");
			return true;
		}
		if (args.length == 1) {
			if (!args[0].equalsIgnoreCase("spawn") && !args[0].equalsIgnoreCase("fps")) {
				sender.sendMessage(" ");
				sender.sendMessage("�8�lPROTE�AO�f Utilize: /setspawnprotection <spawn/fps> (distancia)");
				sender.sendMessage(
						"�e�lEXEMPLO�f /setspawnprotection spawn 15 �e�l(setei a prote��o da warp spawn para 15 blocos de distancia)");
				sender.sendMessage(" ");
				return true;
			} else {
				sender.sendMessage("�8�lPROTE�AO�f Utilize: /setspawnprotection " + args[0] + " (distancia)");
				return true;
			}
		}
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("spawn")) {
				try {
					LocationsConstructor.setBattleWarpSpawnDistanceProtection(Integer.valueOf(args[1]));
					sender.sendMessage("�8�lPROTE�AO�f Voce setou a prote�ao do SPAWN para �8�l" + args[1] + " BLOCOS");
					return true;
				} catch (Exception ex) {
					sender.sendMessage("�8�lPROTE�AO�f Utilize apenas �9�lnumeros�f para indicar a distancia!");
					return true;
				}
			} else if (args[0].equalsIgnoreCase("fps")) {
				try {
					LocationsConstructor.setBattleWarpFpsDistanceProtection(Integer.valueOf(args[1]));
					sender.sendMessage("�8�lPROTE�AO�f Voce setou a prote�ao da FPS para �8�l" + args[1] + " BLOCOS");
					return true;
				} catch (Exception ex) {
					sender.sendMessage("�8�lPROTE�AO�f Utilize apenas �9�lnumeros�f para indicar a distancia!");
					return true;
				}
			} else {
				sender.sendMessage(" ");
				sender.sendMessage("�8�lPROTE�AO�f Utilize: /setspawnprotection <spawn/fps> (distancia)");
				sender.sendMessage(
						"�e�lEXEMPLO�f /setspawnprotection spawn 15 �e�l(setei a prote��o da warp spawn para 15 blocos de distancia)");
				sender.sendMessage(" ");
				return true;
			}
		}
		if (args.length > 2) {
			sender.sendMessage(" ");
			sender.sendMessage("�8�lPROTE�AO�f Utilize: /setspawnprotection <spawn/fps> (distancia)");
			sender.sendMessage(
					"�e�lEXEMPLO�f /setspawnprotection spawn 15 �e�l(setei a prote��o da warp spawn para 15 blocos de distancia)");
			sender.sendMessage(" ");
			return true;
		}
		return false;
	}
}
