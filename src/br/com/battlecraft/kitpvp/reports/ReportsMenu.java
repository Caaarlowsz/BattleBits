package br.com.battlecraft.kitpvp.reports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class ReportsMenu implements Listener {

	public static final HashMap<ItemStack, Integer> reportID = new HashMap<>();

	public static final ItemStack newReportPaper(final Player bp, final int id) {
		ItemStack r = new ItemStack(Material.PAPER);
		ItemMeta rk = r.getItemMeta();
		rk.setDisplayName("§3§lReport - " + id);
		rk.setLore(Arrays.asList(""));
		ArrayList<String> list = (ArrayList<String>) rk.getLore();
		for (String msg : ReportsAPI.reportMessage.get(bp.getName() + id)) {
			if (!list.contains(msg)) {
				list.add(msg);
			}
		}
		rk.setLore(list);
		reportID.put(r, id);
		r.setItemMeta(rk);

		return r;
	}

	public static final ItemStack otherItem() {
		@SuppressWarnings("deprecation")
		ItemStack i = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§7➳ §a§lProxima Pagina");
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack otherItem2() {
		@SuppressWarnings("deprecation")
		ItemStack i = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§7➳ §c§lProxima Pagina");
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack otherItem3() {
		@SuppressWarnings("deprecation")
		ItemStack i = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§7➳ §6§lProxima Pagina");
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack otherItem4() {
		@SuppressWarnings("deprecation")
		ItemStack i = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§7➳ §5§lProxima Pagina");
		i.setItemMeta(ik);
		return i;
	}

	public static final void openReportsMenu(final Player bp) {
		Inventory reports = Bukkit.createInventory(bp, 54,
				"§b§lSeus Reports (pag.1) - " + ReportsAPI.totalReports.get(bp.getName()));
		if (ReportsAPI.totalReports.get(bp.getName()) >= 44) {
			for (int rp = 1; rp <= 44; rp++) {
				reports.addItem(newReportPaper(bp, rp));
			}
			reports.setItem(44, otherItem());
			bp.openInventory(reports);
			return;
		}
		for (int rp = 1; rp <= ReportsAPI.totalReports.get(bp.getName()); rp++) {
			reports.addItem(newReportPaper(bp, rp));
		}
		bp.openInventory(reports);
	}

	public static final void openReportsMenu2(final Player bp) {
		Inventory reports = Bukkit.createInventory(bp, 54,
				"§b§lSeus Reports (pag.2) - " + ReportsAPI.totalReports.get(bp.getName()));
		if (ReportsAPI.totalReports.get(bp.getName()) > 89) {
			for (int rp = 45; rp <= 88; rp++) {
				reports.addItem(newReportPaper(bp, rp));
			}
			reports.setItem(44, otherItem2());
			bp.openInventory(reports);
			return;
		}
		for (int rp = 45; rp <= ReportsAPI.totalReports.get(bp.getName()); rp++) {
			reports.addItem(newReportPaper(bp, rp));
		}
		bp.openInventory(reports);
	}

	public static final void openReportsMenu3(final Player bp) {
		Inventory reports = Bukkit.createInventory(bp, 54,
				"§b§lSeus Reports (pag.3) - " + ReportsAPI.totalReports.get(bp.getName()));
		if (ReportsAPI.totalReports.get(bp.getName()) > 134) {
			for (int rp = 90; rp <= 133; rp++) {
				reports.addItem(newReportPaper(bp, rp));
			}
			reports.setItem(44, otherItem3());
			bp.openInventory(reports);
			return;
		}
		for (int rp = 90; rp <= ReportsAPI.totalReports.get(bp.getName()); rp++) {
			reports.addItem(newReportPaper(bp, rp));
		}
		bp.openInventory(reports);
	}

	public static final void openReportsMenu4(final Player bp) {
		Inventory reports = Bukkit.createInventory(bp, 54,
				"§b§lSeus Reports (pag.4) - " + ReportsAPI.totalReports.get(bp.getName()));
		if (ReportsAPI.totalReports.get(bp.getName()) > 179) {
			for (int rp = 135; rp <= 178; rp++) {
				reports.addItem(newReportPaper(bp, rp));
			}
			reports.setItem(44, otherItem4());
			bp.openInventory(reports);
			return;
		}
		for (int rp = 135; rp <= ReportsAPI.totalReports.get(bp.getName()); rp++) {
			reports.addItem(newReportPaper(bp, rp));
		}
		bp.openInventory(reports);
	}

	public static final void openReportsMenu5(final Player bp) {
		Inventory reports = Bukkit.createInventory(bp, 54,
				"§b§lSeus Reports (pag.5) - " + ReportsAPI.totalReports.get(bp.getName()));
		for (int rp = 180; rp <= ReportsAPI.totalReports.get(bp.getName()); rp++) {
			reports.addItem(newReportPaper(bp, rp));
		}
		bp.openInventory(reports);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public final void onReportsClick(final InventoryClickEvent e) {
		final Player bp = (Player) e.getWhoClicked();
		if (e.getInventory().getName()
				.equalsIgnoreCase("§b§lSeus Reports (pag.1) - " + ReportsAPI.totalReports.get(bp.getName()))
				|| e.getInventory().getName()
						.equalsIgnoreCase("§b§lSeus Reports (pag.2) - " + ReportsAPI.totalReports.get(bp.getName()))
				|| e.getInventory().getName()
						.equalsIgnoreCase("§b§lSeus Reports (pag.3) - " + ReportsAPI.totalReports.get(bp.getName()))
				|| e.getInventory().getName()
						.equalsIgnoreCase("§b§lSeus Reports (pag.4) - " + ReportsAPI.totalReports.get(bp.getName()))
				|| e.getInventory().getName()
						.equalsIgnoreCase("§b§lSeus Reports (pag.5) - " + ReportsAPI.totalReports.get(bp.getName()))
						&& e.getCurrentItem() != null) {
			try {
				if (e.getCurrentItem().getType() == Material.getMaterial(351)) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7➳ §a§lProxima Pagina")) {
						e.setCancelled(true);
						openReportsMenu2(bp);
						return;
					} else if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase("§7➳ §c§lProxima Pagina")) {
						e.setCancelled(true);
						openReportsMenu3(bp);
						return;
					} else if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase("§7➳ §6§lProxima Pagina")) {
						e.setCancelled(true);
						openReportsMenu4(bp);
						return;
					} else if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase("§7➳ §5§lProxima Pagina")) {
						e.setCancelled(true);
						openReportsMenu5(bp);
						return;
					}
				}
				for (int i = 1; i <= ReportsAPI.totalReports.get(bp.getName()); i++) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lReport - " + i)) {
						ReportsAPI.removeReportToBattleStaff(bp, i);
					}
				}
				e.setCancelled(true);
				bp.closeInventory();
				bp.sendMessage("§3§lREPORT§f Report §b§lVISUALIZADO§f!");
			} catch (NullPointerException ex) {
			}
		}
	}
}
