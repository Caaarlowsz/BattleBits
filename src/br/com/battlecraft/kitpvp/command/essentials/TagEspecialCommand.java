package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.nametags.BattleNametagAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class TagEspecialCommand extends Command {

	public TagEspecialCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length == 0) {
			bp.sendMessage("§3§lTAGS ESPECIAIS§f Lista de §9§lTAGS§f:");
			bp.sendMessage(" ");
			bp.sendMessage("§7- §a§lGAMER");
			bp.sendMessage("§7- §7§lNUMB");
			bp.sendMessage(" ");
			bp.sendMessage("§fPara selecionar uma tag utilize: /tagespecial <tag>");
			return true;			
		}
		if (args.length == 1) {
			final String tag = args[0];
			if (tag.equalsIgnoreCase("gamer")) {
				if (!bp.hasPermission("pvp.tagespecial.gamer")) {
					bp.sendMessage("§3§lTAGS ESPECIAIS§f Voce nao tem a tag §a§lGAMER§f.");
					return true;
				}
				BattleNametagAPI.setNametag(bp, "§a§lGAMER §a", " " + Leagues.getBattlePlayerLeagueInChat(bp));
				bp.sendMessage("§3§lTAGS ESPECIAIS§f Voce Selecionou a tag §a§lGAMER§f.");
				return true;
			} else if (tag.equalsIgnoreCase("numb")) {
				if (!bp.hasPermission("pvp.tagespecial.numb")) {
					bp.sendMessage("§3§lTAGS ESPECIAIS§f Voce nao tem a tag §7§lNUMB§f.");
					return true;
				}
				BattleNametagAPI.setNametag(bp, "§7§lNUMB §7", " " + Leagues.getBattlePlayerLeagueInChat(bp));
				bp.sendMessage("§3§lTAGS ESPECIAIS§f Voce Selecionou a tag §7§lNUMB§f.");
				return true;
			} else {
				bp.sendMessage("§3§lTAGS ESPECIAIS§f Tag nao encontrada.");
				return true;
			}
		}
		if (args.length > 1) {
			bp.sendMessage("§3§lTAGS ESPECIAIS§f Lista de §9§lTAGS§f:");
			bp.sendMessage(" ");
			bp.sendMessage("§7- §a§lGAMER");
			bp.sendMessage("§7- §7§lNUMB");
			bp.sendMessage(" ");
			bp.sendMessage("§fPara selecionar uma tag utilize: /tagespecial <tag>");
			return true;			
		}
		return false;
	}
}
