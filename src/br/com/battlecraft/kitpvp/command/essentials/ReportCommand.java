package br.com.battlecraft.kitpvp.command.essentials;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.reports.ReportsAPI;
import br.com.battlecraft.kitpvp.reports.ReportsMenu;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.utils.TimeConverter;

public final class ReportCommand extends Command {

	public ReportCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}
	
	public static final HashMap<String, Integer> reportCooldown = new HashMap<>();
	private static int Task;
	public static final void runCooldown(final Player bp) {
		if (reportCooldown.containsKey(bp.getName())) {
			Task = Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitMain.getPlugin(), new Runnable() {
				@Override
				public void run() {
					reportCooldown.put(bp.getName(), Integer.valueOf(reportCooldown.get(bp.getName()) - 1));
					if (reportCooldown.get(bp.getName()) <= 0) {
						reportCooldown.remove(bp.getName());
						Bukkit.getScheduler().cancelTask(Task);
					}
				}			
			}, 0, 20L);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player battleplayer = (Player) sender;
		if (args.length == 0) {
			if (battleplayer.hasPermission("pvp.cmd.report")) {
				battleplayer.sendMessage("§3§lREPORT§f Utilize: /report <list/check/clear> ou /report <player> (motivo)");
				return true;
			} else {
				battleplayer.sendMessage("§3§lREPORT§f Utilize: /report <player> (motivo)");
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("clear") && args.length == 1) {
			if (!battleplayer.hasPermission("pvp.cmd.report")) {
				battleplayer.sendMessage("§3§lREPORT§f Voce precisa colocar um §c§lmotivo§f!");
				return true;
			}
			if (!ReportsAPI.totalReports.containsKey(battleplayer.getName()) || ReportsAPI.totalReports.get(battleplayer.getName()) <= 0) {
				battleplayer.sendMessage("§3§lREPORT§f Voce nao §c§lPOSSUI NENHUM§3§l REPORT§f!");
				return true;
			}
			for (int i = 1; i <= ReportsAPI.totalReports.get(battleplayer.getName()); i++) {
				ReportsAPI.reportMessage.remove(battleplayer.getName() + i);
			}
			ReportsAPI.totalReports.put(battleplayer.getName(), 0);
			battleplayer.sendMessage("§3§lREPORT§f Voce §c§lLIMPOU§f todos os seus reports!");
			return true;
		}
		if (args[0].equalsIgnoreCase("check") && args.length == 1) {
			if (!battleplayer.hasPermission("pvp.cmd.report")) {
				battleplayer.sendMessage("§3§lREPORT§f Voce precisa colocar um §c§lmotivo§f!");
				return true;
			}
			if (!ReportsAPI.totalReports.containsKey(battleplayer.getName()) || ReportsAPI.totalReports.get(battleplayer.getName()) <= 0) {
				battleplayer.sendMessage("§3§lREPORT§f Voce nao §c§lPOSSUI NENHUM§3§l REPORT§f!");
				return true;
			}
			battleplayer.sendMessage("§3§lREPORT§f Você tem §3§l" + ReportsAPI.totalReports.get(battleplayer.getName()) + " REPORTs§f no momento!");
			return true;
		}
		if (args[0].equalsIgnoreCase("list") && args.length == 1) {
			if (!battleplayer.hasPermission("pvp.cmd.report")) {
				battleplayer.sendMessage("§3§lREPORT§f Voce precisa colocar um §c§lmotivo§f!");
				return true;
			}
			if (!ReportsAPI.totalReports.containsKey(battleplayer.getName()) || ReportsAPI.totalReports.get(battleplayer.getName()) <= 0) {
				battleplayer.sendMessage("§3§lREPORT§f Voce nao §c§lPOSSUI NENHUM§3§l REPORT§f!");
				return true;
			}
			ReportsMenu.openReportsMenu(battleplayer);
			return true;
		}
		final Player reported = BattlePlayerAPI.BattlePlayer(args[0]);
		if (reported == null) {
			battleplayer.sendMessage("§3§lREPORT§f O player " + args[0] + " nao esta §c§lonline§f!");
			return true;
		}
		String motive = "";
		for (int i = 1; i < args.length; i++) {
			motive = motive + args[i] + " ";
		}
		if (motive == "" || motive == null) {
			battleplayer.sendMessage("§3§lREPORT§f Voce precisa colocar um §c§lmotivo§f!");
			return true;
		}
		if (reportCooldown.containsKey(battleplayer.getName())) {
			battleplayer.sendMessage("§3§lREPORT§f Aguarde §c§l" + TimeConverter.ConvertTime(reportCooldown.get(battleplayer.getName())) + " §f para reportar novamente!");
			return true;
		}
		if (!battleplayer.hasPermission("pvp.cmd.report")) {
			reportCooldown.put(battleplayer.getName(), 30);
			runCooldown(battleplayer);
		}
		for (final Player staff : Bukkit.getOnlinePlayers()) {
			if (staff.hasPermission("pvp.cmd.report")) {
				ReportsAPI.addReportToBattleStaff(staff, battleplayer.getName(), reported.getName(), motive);
			}
		}
		battleplayer.sendMessage("§3§lREPORT§f Seu §b§lREPORT§f foi §a§lenviado com sucesso§f!");
		return true;
	}	
}