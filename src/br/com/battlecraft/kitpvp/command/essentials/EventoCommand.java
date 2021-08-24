package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.scoreboard.Score;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.utils.TimeConverter;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Evento.EventoAPI;

public final class EventoCommand extends Command {

	public EventoCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.evento")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			bp.sendMessage("§3§lEVENTO§f Comandos disponiveis: ");
			bp.sendMessage("§b/evento <iniciar/fechar/bloquear/desbloquear/send> ");
			bp.sendMessage("§b/evento <setslot> (slots)");
			bp.sendMessage("§b/evento <setbuild> (on/off)");
			bp.sendMessage("§b/evento <settime> (tempo)");
			bp.sendMessage(" ");
			bp.sendMessage(
					"§c§lINFO:§f Se voce nao quiser §c§lparticipar do evento§f, apenas fazer/espectar, utilize §e§l'/evento send'§f para ser enviado ao local, pois com /warp evento voce sera adicionado a lista de players.");
			bp.sendMessage(" ");
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("iniciar") || args[0].equalsIgnoreCase("start")) {
				if (EventoAPI.onEvent) {
					bp.sendMessage("§3§lEVENTO§f Já esta iniciado!");
					return true;
				}
				bp.sendMessage("§3§lEVENTO§f Voce §a§liniciou§f um evento!");
				EventoAPI.onEvent = true;
				EventoAPI.startEvent();
				return true;
			}
			if (args[0].equalsIgnoreCase("fechar") || args[0].equalsIgnoreCase("close")) {
				if (!EventoAPI.onEvent) {
					bp.sendMessage("§3§lEVENTO§f Nao esta iniciado!");
					return true;
				}
				if (EventoAPI.Players.size() > 0) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						if (EventoAPI.Players.contains(all.getName())) {
							if (BuildCommand.hasBuild.contains(all)) {
								BuildCommand.hasBuild.remove(all);
							}
							new WarpsAPI(all, "Spawn");
						}
					}
				}
				EventoAPI.mode = EventoAPI.EventMode.FECHADO;
				EventoAPI.onEvent = false;
				EventoAPI.task.cancel();
				EventoAPI.eventtime = 241;
				EventoAPI.maxEventSlots = 30;
				bp.sendMessage("§3§lEVENTO§f Voce §c§lfechou§f o evento!");
				Bukkit.getServer().broadcastMessage("§3§lEVENTO§f Foi fechado!");
				return true;
			}
			if (args[0].equalsIgnoreCase("bloquear")) {
				if (!EventoAPI.onEvent) {
					bp.sendMessage("§3§lEVENTO§f Nao esta iniciado!");
					return true;
				}
				if (EventoAPI.blocked) {
					bp.sendMessage("§3§lEVENTO§f Ja esta bloqueado!");
					return true;
				}
				EventoAPI.blocked = true;
				bp.sendMessage("§3§lEVENTO§f Voce §c§lbloqueou§f a entrada para o evento!");
				return true;
			}
			if (args[0].equalsIgnoreCase("desbloquear")) {
				if (!EventoAPI.onEvent) {
					bp.sendMessage("§3§lEVENTO§f Nao esta iniciado!");
					return true;
				}
				if (!EventoAPI.blocked) {
					bp.sendMessage("§3§lEVENTO§f Ja esta desbloqueado!");
					return true;
				}
				EventoAPI.blocked = false;
				bp.sendMessage("§3§lEVENTO§f Voce §a§ldesbloqueou§f a entrada para o evento!");
				return true;
			}
			if (args[0].equalsIgnoreCase("send")) {
				if (!LocationsConstructor.checkBattleWarpNotNull("Evento")) {
					bp.sendMessage("§3§lEVENTO§f Nao foi setado! Utilize: '/set evento' para setar!");
					return true;
				}
				LocationsConstructor.teleportToBattleWarpLocation(bp, "Evento");
				WarpsAPI.battlePlayerWarp.put(bp, WarpsAPI.Warps.EVENTO);
				Score.createScoreEvento(bp);
				bp.sendMessage("§3§lEVENTO§f Voce foi §e§lTELEPORTADO§f para o local §3§lEvento§f!");
				return true;
			} else {
				bp.sendMessage("§3§lEVENTO§f Comandos disponiveis: ");
				bp.sendMessage("§b/evento <iniciar/fechar/bloquear/desbloquear/send> ");
				bp.sendMessage("§b/evento <setslot> (slots)");
				bp.sendMessage("§b/evento <setbuild> (on/off)");
				bp.sendMessage("§b/evento <settime> (tempo)");
				bp.sendMessage(" ");
				bp.sendMessage(
						"§c§lINFO:§f Se voce nao quiser §c§lparticipar do evento§f, apenas fazer/espectar, utilize §e§l'/evento send'§f para ser enviado ao local, pois com /warp evento voce sera adicionado a lista de players.");
				bp.sendMessage(" ");
				return true;
			}
		}
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("setslot") || args[0].equalsIgnoreCase("setslots")) {
				try {
					if (Integer.valueOf(args[1]) <= 0) {
						bp.sendMessage("§3§lEVENTO§f Voce nao pode §c§lsetar slots negativos§f!");
						return true;
					}
					EventoAPI.maxEventSlots = Integer.valueOf(args[1]);
					bp.sendMessage("§3§lEVENTO§f Slots alterado para §e§l" + args[1]);
				} catch (Exception e) {
					bp.sendMessage("§3§lEVENTO§f Utilize apenas numeros para indicar os §e§lslots§f!");
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("setbuild")) {
				if (args[1].equalsIgnoreCase("on")) {
					if (EventoAPI.onBuild) {
						bp.sendMessage("§3§lEVENTO§f Build para os players ja §e§lativado§f!");
						return true;
					}
					EventoAPI.onBuild = true;
					if (EventoAPI.mode == EventoAPI.EventMode.ANDAMENTO) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							if (EventoAPI.Players.contains(all.getName())) {
								if (!BuildCommand.hasBuild.contains(all)) {
									BuildCommand.hasBuild.add(all);
								}
							}
						}
					}
					bp.sendMessage("§3§lEVENTO§f Build para os players agora §a§lativado§f!");
					return true;
				}
				if (args[1].equalsIgnoreCase("off")) {
					if (!EventoAPI.onBuild) {
						bp.sendMessage("§3§lEVENTO§f Build para os players ja §e§ldesativado§f!");
						return true;
					}
					EventoAPI.onBuild = false;
					if (EventoAPI.mode == EventoAPI.EventMode.ANDAMENTO) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							if (EventoAPI.Players.contains(all.getName())) {
								if (BuildCommand.hasBuild.contains(all)) {
									BuildCommand.hasBuild.remove(all);
								}
							}
						}
					}
					bp.sendMessage("§3§lEVENTO§f Build para os players agora §c§ldesativado§f!");
					return true;
				} else {
					bp.sendMessage("§3§lEVENTO§f Utilize: /evento " + args[0] + " <on> ou <off>");
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("settime")) {
				try {
					if (Integer.valueOf(args[1]) <= 0) {
						bp.sendMessage("§3§lEVENTO§f Voce nao pode utilizar §c§lvalores negativos§f!");
						return true;
					}
					EventoAPI.eventtime = Integer.valueOf(args[1]);
					bp.sendMessage("§3§lEVENTO§f Tempo alterado para §e§l"
							+ TimeConverter.ConvertTime(Integer.valueOf(args[1])));
				} catch (Exception e) {
					bp.sendMessage("§3§lEVENTO§f Utilize apenas numeros para indicar o §e§ltempo§f!");
					return true;
				}
			} else {
				bp.sendMessage("§3§lEVENTO§f Comandos disponiveis: ");
				bp.sendMessage("§b/evento <iniciar/fechar/bloquear/desbloquear/send> ");
				bp.sendMessage("§b/evento <setslot> (slots)");
				bp.sendMessage("§b/evento <setbuild> (on/off)");
				bp.sendMessage("§b/evento <settime> (tempo)");
				bp.sendMessage(" ");
				bp.sendMessage(
						"§c§lINFO:§f Se voce nao quiser §c§lparticipar do evento§f, apenas fazer/espectar, utilize §e§l'/evento send'§f para ser enviado ao local, pois com /warp evento voce sera adicionado a lista de players.");
				bp.sendMessage(" ");
				return true;
			}
		}
		if (args.length > 2) {
			bp.sendMessage("§3§lEVENTO§f Comandos disponiveis: ");
			bp.sendMessage("§b/evento <iniciar/fechar/bloquear/desbloquear/send> ");
			bp.sendMessage("§b/evento <setslot> (slots)");
			bp.sendMessage("§b/evento <setbuild> (on/off)");
			bp.sendMessage("§b/evento <settime> (tempo)");
			bp.sendMessage(" ");
			bp.sendMessage(
					"§c§lINFO:§f Se voce nao quiser §c§lparticipar do evento§f, apenas fazer/espectar, utilize §e§l'/evento send'§f para ser enviado ao local, pois com /warp evento voce sera adicionado a lista de players.");
			bp.sendMessage(" ");
			return true;
		}
		return false;
	}
}
