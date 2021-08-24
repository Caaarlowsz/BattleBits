package br.com.battlecraft.kitpvp.command.essentials;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.vanish.VanishSystem;

public final class TellCommand extends Command {

	public TellCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final ArrayList<Player> spy = new ArrayList<>();

	public static final ArrayList<Player> tell = new ArrayList<>();

	@SuppressWarnings("deprecation")
	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length == 0) {
			bp.sendMessage("§6§lTELL§f Utilize: /tell <player/on/off> [mensagem]");
			return true;
		}
		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("on")) {
				if (!tell.contains(bp)) {
					bp.sendMessage("§6§lTELL§f Seu tell já esta §e§lhabilitado§f!");
					return true;
				}
				tell.remove(bp);
				bp.sendMessage("§6§lTELL§f Você §a§lhabilitou§f seu tell.");
				return true;
			}
			if (args[0].equalsIgnoreCase("off")) {
				if (tell.contains(bp)) {
					bp.sendMessage("§6§lTELL§f Seu tell já esta §e§ldesabilitado§f!");
					return true;
				}
				tell.add(bp);
				bp.sendMessage("§6§lTELL§f Você §c§ldesabilitou§f seu tell.");
				return true;
			}
			final Player telled = BattlePlayerAPI.BattlePlayer(args[0]);
			if (telled == null) {
				bp.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			}
			if (VanishSystem.isVanished(telled) && !VanishSystem.isVanished(bp)) {
				bp.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			} else if (telled == bp) {
				bp.sendMessage("§6§lTELL§f Você não pode se enviar uma mensagem.");
				return true;
			} else if (tell.contains(telled) && !bp.hasPermission("pvp.cmd.tell")) {
				bp.sendMessage("§6§lTELL§f Este jogador está com o tell §c§ldesabilitado§f!");
				return true;
			} else {
				String msg = "";
				for (int i = 1; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}
				if (msg == "") {
					bp.sendMessage("§6§lTELL§f Utilize: /tell " + args[0] + " <mensagem>");
					return true;
				}
				for (final Player staff : Bukkit.getOnlinePlayers()) {
					if (VanishSystem.isVanished(staff)) {
						staff.sendMessage(
								"§8[§7TELL De " + bp.getName() + " para " + telled.getName() + "§8]:§f " + msg);
					}
				}
				telled.sendMessage("§8[§7De " + bp.getName() + "§8]:§f " + msg);
				bp.sendMessage("§8[Para " + telled.getName() + "§8]:§f " + msg);
				return true;
			}
		}
		return false;
	}
}
