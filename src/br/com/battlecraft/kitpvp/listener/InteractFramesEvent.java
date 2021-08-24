package br.com.battlecraft.kitpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.command.essentials.BuildCommand;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;
import br.com.battlecraft.kitpvp.warps.Spawn.MenusWarpSpawn;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnItens;

public final class InteractFramesEvent implements Listener {

	public static final void InventorySoup(final Player bp) {
		Inventory menu = Bukkit.createInventory(bp, 54, "§b§lSopas");
		for (int i = 0; i < 54; i++) {
			menu.addItem(SpawnItens.newItem(Material.MUSHROOM_SOUP, "", 1, (byte) 0));
		}
		bp.openInventory(menu);
	}

	@SuppressWarnings("deprecation")
	public static final void InventoryCRed(final Player bp) {
		Inventory menu = Bukkit.createInventory(bp, 54,
				(MenusWarpSpawn.cocoabean.contains(bp.getName()) ? "§c§lCocoabean" : "§c§lCogumelo Vermelho"));
		for (int i = 0; i < 54; i++) {
			menu.setItem(i,
					(MenusWarpSpawn.cocoabean.contains(bp.getName())
							? new ItemStack(Material.getMaterial(351), 64, (byte) 3)
							: SpawnItens.newItem(Material.RED_MUSHROOM, "", 64, (byte) 0)));
		}
		bp.openInventory(menu);
	}

	@SuppressWarnings("deprecation")
	public static final void InventoryCBrow(final Player bp) {
		Inventory menu = Bukkit.createInventory(bp, 54,
				(MenusWarpSpawn.cocoabean.contains(bp.getName()) ? "§e§lCocoabean" : "§e§lCogumelo Marrom"));
		for (int i = 0; i < 54; i++) {
			menu.setItem(i,
					(MenusWarpSpawn.cocoabean.contains(bp.getName())
							? new ItemStack(Material.getMaterial(351), 64, (byte) 3)
							: SpawnItens.newItem(Material.BROWN_MUSHROOM, "", 64, (byte) 0)));
		}
		bp.openInventory(menu);
	}

	public static final void InventoryCBowl(final Player bp) {
		Inventory menu = Bukkit.createInventory(bp, 54, "§3§lPotes");
		for (int i = 0; i < 54; i++) {
			menu.setItem(i, SpawnItens.newItem(Material.BOWL, "", 64, (byte) 0));
		}
		bp.openInventory(menu);
	}

	@EventHandler
	public final void onInteract(final PlayerInteractEntityEvent e) {
		final Player bp = e.getPlayer();
		if (e.getRightClicked() instanceof ItemFrame) {
			ItemFrame frame = (ItemFrame) e.getRightClicked();
			if (frame.getItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				InventorySoup(bp);
			}
			if (frame.getItem().getType() == Material.RED_MUSHROOM) {
				e.setCancelled(true);
				InventoryCRed(bp);
			}
			if (frame.getItem().getType() == Material.BROWN_MUSHROOM) {
				e.setCancelled(true);
				InventoryCBrow(bp);
			}
			if (frame.getItem().getType() == Material.BOWL) {
				e.setCancelled(true);
				InventoryCBowl(bp);
			}
			if (frame.getItem().getType() == Material.DIAMOND_SWORD) {
				ItemStack i = bp.getItemInHand();
				if (i.getType() == Material.DIAMOND_SWORD && !i.getEnchantments().containsKey(Enchantment.DAMAGE_ALL)) {
					e.setCancelled(true);
					if (AccountAPI.getBattlePlayerMoney(bp) < 50) {
						bp.sendMessage("§3§lSHARP§f Voce precisa de §6§l50 MOEDAS§f para encantar §3§lSHARPNESS§f na sua espada!");
						return;
					}
					i.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					AccountAPI.removeBattlePlayerMoney(bp, 50);
					bp.sendMessage("§3§lSHARP§f Voce usou §6§l50 MOEDAS§f para encantar sua espada com §3§lSHARPNESS§f!");
				} else {
					e.setCancelled(true);
					bp.sendMessage("§3§lSHARP§f Voce so pode §c§lencantar§f uma espada sem §3§lSHARP§f!");
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {
		if ((event.getRemover() instanceof Player)) {
			Player p = (Player) event.getRemover();
			if ((event.getEntity().getType() == EntityType.ITEM_FRAME)) {
				if (!BuildCommand.hasBuild(p)) {
					event.setCancelled(true);
					return;
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
		if ((e.getDamager() instanceof Player)) {
			Player p = (Player) e.getDamager();
			if ((e.getEntity().getType() == EntityType.ITEM_FRAME)) {
				if (!BuildCommand.hasBuild(p)) {
					e.setCancelled(true);
				}
			}
			if (WarpsAPI.battlePlayerWarp.get(p) == WarpsAPI.Warps.ONEVSONE
					&& !X1WarpListener.playerfigh.containsKey(p)) {
				e.setCancelled(true);
			}
		}
		if ((e.getDamager() instanceof Projectile) && (e.getEntity().getType() == EntityType.ITEM_FRAME)) {
			e.setCancelled(true);
		}
	}
}
