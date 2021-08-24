package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class GameModeCommand extends Command {

	public GameModeCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}
	
	public static final void setGamemode(final Player p, final String args) {
		if (args.equalsIgnoreCase("0") || args.equalsIgnoreCase("survival")) {
			if (p.getGameMode() == GameMode.SURVIVAL) {
				p.sendMessage("§3§lGAMEMODE§f Você ja §c§lesta neste gamemode§f!");
				return;
			}
			p.setGameMode( GameMode.SURVIVAL);
			p.sendMessage("§3§lGAMEMODE§f Seu gamemode foi ALTERADO para §b§lsurvival§f.");
			return;
		} else if (args.equalsIgnoreCase("1") || args.equalsIgnoreCase("creative")) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				p.sendMessage("§3§lGAMEMODE§f Você ja §c§lesta neste gamemode§f!");
				return;
			}
			p.setGameMode( GameMode.CREATIVE);
			p.sendMessage("§3§lGAMEMODE§f Seu gamemode foi ALTERADO para §b§lcreative§f.");
			return;
		} else if (args.equalsIgnoreCase("2") || args.equalsIgnoreCase("adventure")) {
			if (p.getGameMode() == GameMode.ADVENTURE) {
				p.sendMessage("§3§lGAMEMODE§f Você ja §c§lesta neste gamemode§f!");
				return;
			}
			p.setGameMode( GameMode.ADVENTURE);
			p.sendMessage("§3§lGAMEMODE§f Seu gamemode foi ALTERADO para §b§ladventure§f.");
			return;
		} else {
			p.sendMessage("§3§lGAMEMODE§f Gamemode não econtrado.");
			return;
		}
	}

	public static final void setGamemode(final Player p, final Player toGm, final String args) {
		if (args.equalsIgnoreCase("0") || args.equalsIgnoreCase("survival")) {
			if (toGm.getGameMode() == GameMode.SURVIVAL) {
				p.sendMessage(
						"§3§lGAMEMODE§f O gamemode do player  " + toGm.getName() + " já §c§lesta no survival§f.");
				return;
			}
			toGm.setGameMode(GameMode.SURVIVAL);
			toGm.sendMessage(
					"§3§lGAMEMODE§f O player " + p.getName() + " ALTEROU seu gamemode para §b§lsurvival§f.");
			p.sendMessage(
					"§3§lGAMEMODE§f Você ALTEROU o gamemode do player " + toGm.getName() + " para §b§lsurvival§f!");
			return;
		} else if (args.equalsIgnoreCase("1") || args.equalsIgnoreCase("creative")) {
			if (toGm.getGameMode() == GameMode.CREATIVE) {
				p.sendMessage(
						"§3§lGAMEMODE§f O gamemode do player  " + toGm.getName() + " já §c§lesta no creative§f.");
				return;
			}
			toGm.setGameMode(GameMode.CREATIVE);
			toGm.sendMessage(
					"§3§lGAMEMODE§f O player " + p.getName() + " ALTEROU seu gamemode para §b§lcreative§f.");
			p.sendMessage(
					"§3§lGAMEMODE§f Você ALTEROU o gamemode do player " + toGm.getName() + " para §b§lcreative§f!");
			return;
		} else if (args.equalsIgnoreCase("2") || args.equalsIgnoreCase("adventure")) {
			if (toGm.getGameMode() == GameMode.ADVENTURE) {
				p.sendMessage(
						"§3§lGAMEMODE§f O gamemode do player  " + toGm.getName() + " já §c§lesta no adventure§f.");
				return;
			}
			toGm.setGameMode(GameMode.ADVENTURE);
			toGm.sendMessage(
					"§3§lGAMEMODE§f O player " + p.getName() + " ALTEROU seu gamemode para §b§ladventure§f.");
			p.sendMessage(
					"§3§lGAMEMODE§f Você ALTEROU o gamemode do player " + toGm.getName() + " para §b§ladventure§f!");
			return;
		} else {
			p.sendMessage("§3§lGAMEMODE§f Gamemode não econtrado.");
			return;
		}
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player p = (Player) sender;
		if (!p.hasPermission("commons.command.gamemode")) {
			p.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§3§lGAMEMODE§f Utilize: /gamemode <mode> ou/e [player]");
			return true;
		} else if (args.length == 1) {
			setGamemode(p, args[0]);
			return true;
		} else if (args.length == 2) {
			final Player toGm = BattlePlayerAPI.BattlePlayer(args[1]);
			if (toGm == null) {
				p.sendMessage("§4§lERRO§f O player " + args[1] + " não está §c§lonline§f.");
				return true;
			} else if (toGm == p) {
				setGamemode(p, args[0]);
				return true;
			}
			setGamemode(p, toGm, args[0]);
			return true;
		} else if (args.length > 2) {
			p.sendMessage("§3§lGAMEMODE§f Utilize: /gamemode <mode> ou/e [player]");
			return true;
		}
		return false;
	}
}

