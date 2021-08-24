package br.com.battlecraft.kitpvp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import br.com.battlecraft.kitpvp.api.WarpAPI;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.vanish.VanishSystem;

public final class CompassSystemListener implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(final PlayerInteractEvent e) {
		boolean nullpointer = false;
		if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
			e.setCancelled(true);
			if (WarpAPI.getWarp(e.getPlayer()) == "PVP") {
				for (Entity players : e.getPlayer().getNearbyEntities(100, 150, 100)) {
					if ((players instanceof Player) && e.getPlayer().getLocation().distance(players.getLocation()) >= 10
							&& !VanishSystem.isVanished((Player) players)) {
						if (players.getLocation().getY() > 170) {
							return;
						}
						nullpointer = true;
						e.getPlayer().setCompassTarget(players.getLocation());
						e.getPlayer().sendMessage("§3§lBUSSOLA§f Apontando para §b§l" + ((Player) players).getName());
						return;
					}
				}
				if (!nullpointer) {
					e.getPlayer().sendMessage("§3§lBUSSOLA§e Nenhum jogador localizado! Apontando para o spawn.");
					e.getPlayer().setCompassTarget(LocationsConstructor.getWarpLocation(e.getPlayer(), "Spawn"));
					return;
				}
			}
		}
	}
}