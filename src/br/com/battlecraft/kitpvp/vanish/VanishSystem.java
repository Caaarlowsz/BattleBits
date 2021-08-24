package br.com.battlecraft.kitpvp.vanish;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnItens;

public final class VanishSystem {

	private static final ArrayList<Player> vanished = new ArrayList<>();

	private static final HashMap<Player, ItemStack[]> armorContents = new HashMap<>();
	private static final HashMap<Player, ItemStack[]> inventoryContents = new HashMap<>();

	public static final ItemStack newI(final Material mat, final String name, final byte id) {
		final ItemStack i = new ItemStack(mat, (byte) id);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName(name);
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack knock() {
		final ItemStack i = new ItemStack(Material.STICK);
		final ItemMeta ik = i.getItemMeta();
		ik.addEnchant(Enchantment.KNOCKBACK, 2, true);
		ik.setDisplayName("§5§lKnockback 2");
		i.setItemMeta(ik);
		return i;
	}

	@SuppressWarnings("deprecation")
	public static final void setVanishItemsToPlayer(final Player bp) {

		bp.getInventory().setItem(0, SpawnItens.newItem(Material.BEDROCK, "§c§lHack Cage", 1, (byte) 0));
		bp.getInventory().setItem(2, knock());
		bp.getInventory().setItem(4, SpawnItens.newItem(Material.getMaterial(351), "§a§lFast Admin", 1, (byte) 10));
		bp.getInventory().setItem(6, SpawnItens.newItem(Material.MUSHROOM_SOUP, "§b§lTestar Auto-Soup", 1, (byte) 0));
		bp.getInventory().setItem(8,
				SpawnItens.newItem(Material.IRON_FENCE, "§3§lPuxar para Screenshare", 1, (byte) 0));
		bp.updateInventory();
	}

	public static final void setVanishToPlayerFromArgs(final Player bp) {
		if (!isVanished(bp)) {
			setVanished(bp);
			armorContents.put(bp, bp.getInventory().getArmorContents());
			inventoryContents.put(bp, bp.getInventory().getContents());
			bp.getInventory().clear();
			bp.getInventory().setArmorContents(null);
			setVanishItemsToPlayer(bp);
			if (bp.getGameMode() != GameMode.CREATIVE) {
				bp.setGameMode(GameMode.CREATIVE);
			}
			runVanishSystem(bp);
			bp.sendMessage("§c§lADMIN§f Voce §e§lentrou§f no modo §c§ladmin§f!");
			bp.sendMessage("§e§lVANISH§f Voce esta §e§linvisivel§f para quem nao esta neste modo!");
			return;
		} else {
			unsetVanished(bp);
			bp.getInventory().clear();
			bp.getInventory().setArmorContents(null);
			if (bp.getGameMode() != GameMode.SURVIVAL) {
				bp.setGameMode(GameMode.SURVIVAL);
			}
			bp.getInventory().setContents(inventoryContents.get(bp));
			bp.getInventory().setArmorContents(armorContents.get(bp));
			inventoryContents.remove(bp);
			armorContents.remove(bp);
			runVanishSystem(bp);
			bp.sendMessage("§c§lADMIN§f Voce §e§lsaiu§f no modo §c§ladmin§f!");
			bp.sendMessage("§e§lVANISH§f Voce esta §e§lvisivel§f para todos os jogadores!");
		}
	}

	public static final boolean isVanished(final Player bp) {
		return vanished.contains(bp);
	}

	public static final void setVanished(final Player bp) {
		if (isVanished(bp)) {
			unsetVanished(bp);
		}
		vanished.add(bp);
	}

	public static final void unsetVanished(final Player bp) {
		if (!isVanished(bp)) {
			return;
		}
		vanished.remove(bp);
	}

	@SuppressWarnings("deprecation")
	public static final void playerHideShowMethod(final Player bp) {
		for (final Player all : Bukkit.getOnlinePlayers()) {
			if (isVanished(bp) && !isVanished(all)) {
				all.hidePlayer(bp);
				bp.showPlayer(all);
				if (X1WarpListener.fighting.contains(all)) {
					all.hidePlayer(bp);
				}
			} else if (isVanished(bp) && isVanished(all)) {
				all.showPlayer(bp);
				bp.showPlayer(all);
				if (X1WarpListener.fighting.contains(all)) {
					all.hidePlayer(bp);
				}
			} else if (!isVanished(bp) && isVanished(all)) {
				all.showPlayer(bp);
				bp.hidePlayer(all);
				if (X1WarpListener.fighting.contains(all)) {
					all.hidePlayer(bp);
				}
			} else if (!isVanished(bp) && !isVanished(all)) {
				all.showPlayer(bp);
				bp.showPlayer(all);
				if (X1WarpListener.fighting.contains(all)) {
					all.hidePlayer(bp);
				}
			}
		}
	}

	public static final void runVanishSystem(final Player bp) {
		for (int i = 5; i > 0; i--) {
			playerHideShowMethod(bp);
		}
	}
}