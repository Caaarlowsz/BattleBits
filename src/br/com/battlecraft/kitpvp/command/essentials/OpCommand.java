package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class OpCommand extends Command {

	public OpCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final void setOp(final CommandSender sender, final Player bp) {
		if (BattlePlayerAPI.getBattlePlayerName(bp).length() > 16) {
			sender.sendMessage("§4§lOP§f O nick deste player é §c§linvalido§f! Possui mais de §9§l16 CARATERES§f!");
			return;
		}
		if (!BattlePlayerAPI.validate(BattlePlayerAPI.getBattlePlayerName(bp))) {
			sender.sendMessage("§4§lOP§f O nick deste player é §c§linvalido§f! Possui carateres §4§lnao permitidos§f!");
			return;
		}
		if (bp.isOp()) {
			sender.sendMessage("§4§lOP§f O player " + BattlePlayerAPI.getBattlePlayerName(bp) + " ja é um §4§lOP§f!");
			return;
		}
		bp.setOp(true);
		bp.sendMessage("§4§lOP§f Voce recebeu §c§lop§f do " + sender.getName() + ".");
		sender.sendMessage("§4§lOP§f O player " + BattlePlayerAPI.getBattlePlayerName(bp) + " agora é um §c§lop§f!");
		if (Bukkit.getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
			sender.sendMessage(" ");
			sender.sendMessage("§c-=-=-=-=-=-=-=-=-=-");
			sender.sendMessage(
					"§4§lAVISO§f O plugin §c§lPermissionsEx§f esta ativado! As permissoes do §4§lOP§f podem nao funcionar; caso nao §c§lfuncionem§f configure as permissoes pelo plugin dito.");
			sender.sendMessage("§c-=-=-=-=-=-=-=-=-=-");
			sender.sendMessage(" ");
		}
	}

	public static final void setOp(final CommandSender sender, final OfflinePlayer bp) {
		if (BattlePlayerAPI.getBattlePlayerName(bp).length() > 16) {
			sender.sendMessage("§4§lOP§f O nick deste player é §c§linvalido§f! Possui mais de §9§l16 CARATERES§f!");
			return;
		}
		if (!BattlePlayerAPI.validate(BattlePlayerAPI.getBattlePlayerName(bp))) {
			sender.sendMessage("§4§lOP§f O nick deste player é §c§linvalido§f! Possui carateres §4§lnao permitidos§f!");
			return;
		}
		if (bp.isOp()) {
			sender.sendMessage("§4§lOP§f O player " + BattlePlayerAPI.getBattlePlayerName(bp) + " ja é um §4§lOP§f!");
			return;
		}
		bp.setOp(true);
		sender.sendMessage("§4§lOP§f O player " + BattlePlayerAPI.getBattlePlayerName(bp) + " agora é um §c§lop§f!");
		if (Bukkit.getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
			sender.sendMessage(" ");
			sender.sendMessage("§c-=-=-=-=-=-=-=-=-=-");
			sender.sendMessage(
					"§4§lAVISO§f O plugin §c§lPermissionsEx§f esta ativado! As permissoes do §4§lOP§f podem nao funcionar; caso nao §c§lfuncionem§f configure as permissoes pelo plugin dito.");
			sender.sendMessage("§c-=-=-=-=-=-=-=-=-=-");
			sender.sendMessage(" ");
		}
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.op")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0 && args.length < 1) {
			sender.sendMessage("§4§lOP§f De op com: /op <playerName>");
			return true;
		} else if (args.length == 1 && args.length < 2) {
			final Player bp = BattlePlayerAPI.BattlePlayer(args[0]);
			if (bp == null) {
				final OfflinePlayer bpoff = BattlePlayerAPI.BattlePlayerOffline(args[0]);
				setOp(sender, bpoff);
				return true;
			}
			setOp(sender, bp);
			return true;
		} else if (args.length > 1) {
			sender.sendMessage("§4§lOP§f De op com: /op <playerName>");
			return true;
		}
		return false;
	}
}
