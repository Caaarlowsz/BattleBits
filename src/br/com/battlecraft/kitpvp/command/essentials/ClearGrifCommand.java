package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class ClearGrifCommand extends Command {

	public ClearGrifCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final void clearLava(final Location location, final int radius) {
		for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
			for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
				for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
					if (location.getWorld().getBlockAt(x, y, z).getType() == Material.STATIONARY_LAVA
							|| location.getWorld().getBlockAt(x, y, z).getType() == Material.LAVA) {
						location.getWorld().getBlockAt(x, y, z).setType(Material.AIR);
					}
				}
			}
		}
	}

	public static final void clearWater(final Location location, final int radius) {
		for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
			for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
				for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
					if (location.getWorld().getBlockAt(x, y, z).getType() == Material.STATIONARY_WATER
							|| location.getWorld().getBlockAt(x, y, z).getType() == Material.WATER) {
						location.getWorld().getBlockAt(x, y, z).setType(Material.AIR);
					}
				}
			}
		}
	}
	
	public static final int MAX_DISTANCE = 200;

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.clearlava")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length <= 1) {
			bp.sendMessage("§c§lCLEAR GRIF§f Utilize: /cleargrif <agua/lava> <distancia>");
			return true;
		}
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("water") || args[0].equalsIgnoreCase("agua")) {
				try {
					if (Integer.valueOf(args[1]) > MAX_DISTANCE) {
						bp.sendMessage("§4§lERRO§f A distancia maxima para raios permitidas é de §c§l" + MAX_DISTANCE + " BLOCOS§f!");
						return true;
					}
					if (Integer.valueOf(args[1]) <= 0) {
						bp.sendMessage("§c§lCLEAR GRIF§f O raio precisa ser maior que 0.");
						return true;
					}
					clearWater(bp.getLocation(), Integer.valueOf(args[1]));
					bp.sendMessage("§c§lCLEAR GRIF§f Voce limpou qualquer tipo de §b§lAGUA§f em um raio de §e§l"
							+ args[1] + " blocos§f.");
					return true;
				} catch (Exception e) {
					bp.sendMessage("§4§lERRO§f Utilize apenas §9§lNUMEROS§f para indicar os raios de distancia.");
					return true;
				}
			} else if (args[0].equalsIgnoreCase("lava")) {
				try {
					if (Integer.valueOf(args[1]) > MAX_DISTANCE) {
						bp.sendMessage("§4§lERRO§f A distancia maxima para raios permitidas é de §c§l" + MAX_DISTANCE + " BLOCOS§f!");
						return true;
					}
					if (Integer.valueOf(args[1]) <= 0) {
						bp.sendMessage("§c§lCLEAR GRIF§f O raio precisa ser maior que 0.");
						return true;
					}
					clearLava(bp.getLocation(), Integer.valueOf(args[1]));
					bp.sendMessage("§c§lCLEAR GRIF§f Voce limpou qualquer tipo de §c§lLAVA§f em um raio de §e§l"
							+ args[1] + " blocos§f.");
					return true;
				} catch (Exception e) {
					bp.sendMessage("§4§lERRO§f Utilize apenas §9§lNUMEROS§f para indicar os raios de distancia.");
					return true;
				}
			} else {
				bp.sendMessage("§c§lCLEAR GRIF§f Utilize: /cleargrif §b<agua> §fou §c<lava> e §e(distancia)");
				return true;
			}
		}
		if (args.length > 1) {
			bp.sendMessage("§c§lCLEAR GRIF§f Utilize: /cleargrif <agua/lava> <distancia>");
			return true;
		}
		return false;
	}
}
