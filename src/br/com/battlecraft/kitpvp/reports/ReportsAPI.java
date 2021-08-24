package br.com.battlecraft.kitpvp.reports;

import java.util.HashMap;

import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.account.AccountConstructor;

public final class ReportsAPI {
	
	/**
	 * Simple Report Manager
	 */

	public static final HashMap<String, String[]> reportMessage = new HashMap<>();

	public static final HashMap<String, Integer> totalReports = new HashMap<>();

	public static final void addReportToBattleStaff(final Player staff, final String reporter, final String reported,
			final String reportMotive) {
		if (totalReports.containsKey(staff.getName()) && totalReports.get(staff.getName()) >= 224) {
			staff.sendMessage("§3§lREPORT§f Você possui um §c§lMAXIMO DE " + totalReports.get(staff.getName()) + " REPORTS§f!");
			return;
		} else if (totalReports.containsKey(staff.getName()) && totalReports.get(staff.getName()) < 224) {
			final int total = totalReports.get(staff.getName());
			totalReports.put(staff.getName(), Integer.valueOf(total + 1));
			reportMessage.put(staff.getName() + totalReports.get(staff.getName()),
					new String[] { "§fPlayer: §b" + reported, "§f§m-----------§f", "§fMotivo: §b" + reportMotive,
							"§b§m-----------§f", "§fReporter: §b" + reporter, "§3§m-----------§f",
							"§fHorario do Report: §b" + AccountConstructor.BrasilTime() });
			staff.sendMessage("§3§lREPORT§f Você tem §3§l" + ReportsAPI.totalReports.get(staff.getName()) + " REPORTs§f no momento!");
			return;
		} else {
			totalReports.put(staff.getName(), 1);
			reportMessage.put(staff.getName() + 1,
					new String[] { "§fPlayer: §b" + reported, "§f§m-----------§f", "§fMotivo: §b" + reportMotive,
							"§b§m-----------§f", "§fReporter: §b" + reporter, "§3§m-----------§f",
							"§fHorario do Report: §b" + AccountConstructor.BrasilTime() });
			staff.sendMessage("§3§lREPORT§f Você tem §3§l" + ReportsAPI.totalReports.get(staff.getName()) + " REPORT§f no momento! Utilize: /report list");
		}
	}

	public static final void removeReportToBattleStaff(final Player staff, final int reportID) {
		final int total = totalReports.get(staff.getName());
		if (reportID == total) {
			reportMessage.remove(staff.getName() + reportID);
			totalReports.put(staff.getName(), Integer.valueOf(total - 1));
			return;
		}
		final int total2 = totalReports.get(staff.getName());
		reportMessage.remove(staff.getName() + reportID);
		for (int i = reportID + 1; i <= total2; i++) {
			final String[] msg = reportMessage.get(staff.getName() + i);
			final int t = i - 1;
			reportMessage.put(staff.getName() + t, msg);
		}
		totalReports.put(staff.getName(), Integer.valueOf(total2 - 1));
	}
}