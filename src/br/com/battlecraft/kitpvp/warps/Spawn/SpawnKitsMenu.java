package br.com.battlecraft.kitpvp.warps.Spawn;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.kits.Ajnin;
import br.com.battlecraft.kitpvp.kits.Anchor;
import br.com.battlecraft.kitpvp.kits.AntiStomper;
import br.com.battlecraft.kitpvp.kits.Fireman;
import br.com.battlecraft.kitpvp.kits.Fisherman;
import br.com.battlecraft.kitpvp.kits.Gladiator;
import br.com.battlecraft.kitpvp.kits.Hulk;
import br.com.battlecraft.kitpvp.kits.Kangaroo;
import br.com.battlecraft.kitpvp.kits.Magma;
import br.com.battlecraft.kitpvp.kits.Minato;
import br.com.battlecraft.kitpvp.kits.Monk;
import br.com.battlecraft.kitpvp.kits.Ninja;
import br.com.battlecraft.kitpvp.kits.Phantom;
import br.com.battlecraft.kitpvp.kits.PvP;
import br.com.battlecraft.kitpvp.kits.Stomper;
import br.com.battlecraft.kitpvp.kits.Thor;
import br.com.battlecraft.kitpvp.kits.Timelord;
import br.com.battlecraft.kitpvp.kits.Viking;

public final class SpawnKitsMenu implements Listener {

	@SuppressWarnings("deprecation")
	public static final void oPenKitsMenu(final Player bp) {

		Inventory menu = Bukkit.createInventory(bp, 54, "§b§lKits");
		menu.setItem(0, SpawnItens.newItem(Material.getMaterial(351), "§8§lPagina Anterior", new String[] { null }, 1,
				(byte) 8));
		for (int i = 1; i < 2; i++) {
			menu.setItem(i, new ItemStack(Material.GLASS));
		}
		for (int i = 7; i < 8; i++) {
			menu.setItem(i, new ItemStack(Material.GLASS));
		}
		menu.setItem(2, SpawnItens.newItem(Material.WOOL, "§e§lRandom Kit",
				new String[] { "", "§7Clique aqui para Selecionar um", "§7kit aleatório escolhido pelo sistema!", "" },
				1, (byte) 4));
		menu.setItem(3,
				SpawnItens.newItem(Material.WOOL, "§a§lTodos os Kits",
						new String[] { "", "§7Clique aqui para ver a lista de", "§7todos os kits do servidor!", "" }, 1,
						(byte) 5));
		menu.setItem(4, SpawnItens.newItem(Material.DIAMOND, "§b§lLoja de Kits",
				new String[] { "", "§7Clique aqui para comprar kits na", "§7loja online ou com moedas in-game!", "" },
				1, (byte) 5));
		menu.setItem(5, SpawnItens.newItem(Material.WOOL, "§c§lMenu desativado",
				new String[] { "", "§7Esta opçao esta desativada", "" }, 1,
				(byte) 14));
		menu.setItem(6,
				SpawnItens.newItem(Material.WOOL, "§c§lMenu desativado", new String[] { "",
						"§7Esta opçao esta desativada", "" }, 1,
						(byte) 11));
		menu.setItem(8, SpawnItens.newItem(Material.getMaterial(351), "§8§lProxima pagina", new String[] { null }, 1,
				(byte) 8));
		for (int i = 9; i < 18; i++) {
			menu.setItem(i, SpawnItens.newItem(Material.STAINED_GLASS_PANE, "§e§lSeus Kits", 1, (byte) 4));
		}

menu.addItem(ItensKit.PvP());
		
		if (bp.hasPermission("pvp.kit.kangaroo")) {
			menu.addItem(ItensKit.Kangaroo());
		}
		
		if (bp.hasPermission("pvp.kit.gladiator")) {
			menu.addItem(ItensKit.Gladiator());
		}
		
		if (bp.hasPermission("pvp.kit.anchor")) {
			menu.addItem(ItensKit.Anchor());
		}
		
		if (bp.hasPermission("pvp.kit.ajnin")) {
			menu.addItem(ItensKit.Ajnin());
		}
		
		if (bp.hasPermission("pvp.kit.ninja")) {
			menu.addItem(ItensKit.Ninja());
		}
		
		if (bp.hasPermission("pvp.kit.minato")) {
			menu.addItem(ItensKit.Minato());
		}
		
		if (bp.hasPermission("pvp.kit.stomper")) {
			menu.addItem(ItensKit.Stomper());
		}
		
		if (bp.hasPermission("pvp.kit.antistomper")) {
			menu.addItem(ItensKit.AntiStomper());
		}
		
		if (bp.hasPermission("pvp.kit.fireman")) {
			menu.addItem(ItensKit.Fireman());
		}
		
		if (bp.hasPermission("pvp.kit.magma")) {
			menu.addItem(ItensKit.Magma());
		}
		
		if (bp.hasPermission("pvp.kit.hulk")) {
			menu.addItem(ItensKit.Hulk());
		}
		
		if (bp.hasPermission("pvp.kit.monk")) {
			menu.addItem(ItensKit.Monk());
		}
		
		if (bp.hasPermission("pvp.kit.switcher")) {
			menu.addItem(ItensKit.Switcher());
		}
		
		if (bp.hasPermission("pvp.kit.thor")) {
			menu.addItem(ItensKit.Thor());
		}
		
		if (bp.hasPermission("pvp.kit.timelord")) {
			menu.addItem(ItensKit.Timelord());
		}
		
		if (bp.hasPermission("pvp.kit.viking")) {
			menu.addItem(ItensKit.Viking());
		}

		for (int i = 1; i < 2; i++) {
			menu.setItem(i, new ItemStack(Material.AIR));
		}
		for (int i = 7; i < 8; i++) {
			menu.setItem(i, new ItemStack(Material.AIR));
		}
		bp.openInventory(menu);
	}
	
	public static final void oPenAllKitsMenu(final Player bp) {

		Inventory menu = Bukkit.createInventory(bp, 54, "§b§lTodos os Kits");
		for (int i = 0; i < 9; i++) {
			menu.setItem(i, SpawnItens.newItem(Material.STAINED_GLASS_PANE, "§e§lTodos os Kits", 1, (byte) 4));
		}
		
		menu.setItem(3, SpawnItens.newItem(Material.CHEST, "§b§lSeus Kits", new String[] {"§7Clique para ver os seus Kits"}));
		
		menu.setItem(5, SpawnItens.newItem(Material.DIAMOND, "§b§lLoja", new String[] {"§7Clique para abrir a loja de Kits"}));

		menu.addItem(ItensKit.PvP());
		
		menu.addItem(ItensKit.Kangaroo());
		
		menu.addItem(ItensKit.Gladiator());
		
		menu.addItem(ItensKit.Anchor());
		
		menu.addItem(ItensKit.Ajnin());
		
		menu.addItem(ItensKit.Ninja());
		
		menu.addItem(ItensKit.Minato());
		
		menu.addItem(ItensKit.Stomper());
		
		menu.addItem(ItensKit.AntiStomper());
		
		menu.addItem(ItensKit.Fireman());
		
		menu.addItem(ItensKit.Magma());
		
		menu.addItem(ItensKit.Hulk());
		
		menu.addItem(ItensKit.Monk());
		
		menu.addItem(ItensKit.Switcher());
		
		menu.addItem(ItensKit.Thor());
		
		menu.addItem(ItensKit.Timelord());
		
		menu.addItem(ItensKit.Viking());

		bp.openInventory(menu);
	}

	public static final void runRandomKit(final Player bp) {
		if (randomKit.contains(bp.getName())) {
			bp.closeInventory();
			bp.sendMessage(
					"§e§lRANDOMKIT§f Voce ja usou seu §e§lrandom kit§f! Espere §c§l10 MINUTOS§f para usar novamente!");
			return;
		}
		randomKit.add(bp.getName());
		switch (new Random().nextInt(12)) {
		case 0:
			bp.closeInventory();
			Ninja.setNinjaKit(bp);
			break;
		case 1:
			bp.closeInventory();
			Anchor.setAnchorKit(bp);
			break;
		case 2:
			bp.closeInventory();
			Ajnin.setAjninKit(bp);
			break;
		case 3:
			bp.closeInventory();
			Ninja.setNinjaKit(bp);
			break;
		case 4:
			bp.closeInventory();
			PvP.setPvPKit(bp);
			break;
		case 5:
			bp.closeInventory();
			Minato.setMinatoKit(bp);
			;
			break;
		case 6:
			bp.closeInventory();
			Stomper.setStomperKit(bp);
			;
			break;
		case 7:
			bp.closeInventory();
			AntiStomper.setAntiStomperKit(bp);
			;
			break;
		case 8:
			bp.closeInventory();
			Fireman.setFiremanKit(bp);
			break;
		case 9:
			bp.closeInventory();
			Magma.setMagmaKit(bp);
			break;
		case 10:
			bp.closeInventory();
			Fireman.setFiremanKit(bp);
			break;
		case 11:
			bp.closeInventory();
			Monk.setMonkKit(bp);
			break;
		case 12:
			bp.closeInventory();
			Kangaroo.setKangarooKit(bp);
			break;
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				if (randomKit.contains(bp.getName())) {
					randomKit.remove(bp.getName());
				}
			}
		}, 12000L);
	}

	public static final ArrayList<String> randomKit = new ArrayList<>();

	@EventHandler
	public final void onInventoryKitsClick(final InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			final Player bp = (Player) e.getWhoClicked();
			if (e.getInventory().getName().equalsIgnoreCase("§b§lKits") && e.getCurrentItem() != null) {
				try {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lRandom Kit")) {
						e.setCancelled(true);
						runRandomKit(bp);
					}
				} catch (NullPointerException ex) {
					runRandomKit(bp);
				}
				try {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lTodos os Kits")) {
						e.setCancelled(true);
						oPenAllKitsMenu(bp);
					}
				} catch (NullPointerException ex) {
					oPenAllKitsMenu(bp);
				}
				if (e.getCurrentItem().getType() == Material.DIAMOND) {
					e.setCancelled(true);
					MenusWarpSpawn.menuLojaKits(bp);
				}
				if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
					e.setCancelled(true);
					bp.closeInventory();
					PvP.setPvPKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.ANVIL) {
					e.setCancelled(true);
					bp.closeInventory();
					Anchor.setAnchorKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
					e.setCancelled(true);
					bp.closeInventory();
					Ajnin.setAjninKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.SADDLE) {
					e.setCancelled(true);
					bp.closeInventory();
					Hulk.setHulkKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.FIREWORK) {
					e.setCancelled(true);
					bp.closeInventory();
					Kangaroo.setKangarooKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.DIAMOND_HELMET) {
					e.setCancelled(true);
					bp.closeInventory();
					AntiStomper.setAntiStomperKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
					e.setCancelled(true);
					bp.closeInventory();
					Stomper.setStomperKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.FIRE) {
					e.setCancelled(true);
					bp.closeInventory();
					Fireman.setFiremanKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
					e.setCancelled(true);
					bp.closeInventory();
					Magma.setMagmaKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
					e.setCancelled(true);
					bp.closeInventory();
					Fisherman.setFishermanKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
					e.setCancelled(true);
					bp.closeInventory();
					Monk.setMonkKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.ARROW) {
					e.setCancelled(true);
					bp.closeInventory();
					Minato.setMinatoKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
					e.setCancelled(true);
					bp.closeInventory();
					Gladiator.setGladiatorKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.FEATHER) {
					e.setCancelled(true);
					bp.closeInventory();
					Phantom.setPhantomKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
					e.setCancelled(true);
					bp.closeInventory();
					Thor.setThorKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.WATCH) {
					e.setCancelled(true);
					bp.closeInventory();
					Timelord.setThorKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.DIAMOND_AXE) {
					e.setCancelled(true);
					bp.closeInventory();
					Viking.setVikingKit(bp);
				}
				if (e.getCurrentItem().getType() == Material.EMERALD) {
					e.setCancelled(true);
					bp.closeInventory();
					Ninja.setNinjaKit(bp);
				} else {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public final void onInventoryAllKitsClick(final InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			final Player bp = (Player) e.getWhoClicked();
			if (e.getInventory().getName().equalsIgnoreCase("§b§lTodos os Kits") && e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType() == Material.CHEST) {
					e.setCancelled(true);
					oPenKitsMenu(bp);
				}
				if (e.getCurrentItem().getType() == Material.DIAMOND) {
					e.setCancelled(true);
					MenusWarpSpawn.menuLojaKits(bp);
				} else {
					e.setCancelled(true);
				}
			}
		}
	}
}
