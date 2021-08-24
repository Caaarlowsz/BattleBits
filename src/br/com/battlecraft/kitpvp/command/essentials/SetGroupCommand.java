package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.api.TittleAPI;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public class SetGroupCommand extends Command {

	public SetGroupCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@SuppressWarnings("deprecation")
	public static final void setGroupFromCommand(final CommandSender sender, final Player toGroup,
			final String playerName, final String args) {
		if (!Bukkit.getPluginManager().isPluginEnabled("PermissionsEx")) {
			sender.sendMessage(
					"§4§lERRO§f O plugin §e§lPermissionsEx§f nao esta §c§lativado!§f Ele é necessario para setar um grupo.");
			return;
		} else if (args.equalsIgnoreCase("dono") || args.equalsIgnoreCase("owner")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set dono");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §4§lDONO");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §4§lDONO");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §4§lDONO");
				TittleAPI.sendTittle(toGroup, "§4§lDONO");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.dono")) {
					toGroup.chat("/tag dono");
				}
			}
		} else if (args.equalsIgnoreCase("diretor")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set diretor");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §4§lDIRETOR");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §4§lDIRETOR");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §4§lDIRETOR");
				TittleAPI.sendTittle(toGroup, "§4§lDIRETOR");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.diretor")) {
					toGroup.chat("/tag diretor");
				}
			}
		} else if (args.equalsIgnoreCase("gerente")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set gerente");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §c§lGERENTE");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §c§lGERENTE");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §c§lGERENTE");
				TittleAPI.sendTittle(toGroup, "§c§lGERENTE");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.gerente")) {
					toGroup.chat("/tag gerente");
				}
			}
		} else if (args.equalsIgnoreCase("admin") || args.equalsIgnoreCase("administrador")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set admin");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §c§lADMIN");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §c§lADMIN");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §c§lADMIN");
				TittleAPI.sendTittle(toGroup, "§c§lADMIN");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.admin")) {
					toGroup.chat("/tag admin");
				}
			}
		} else if (args.equalsIgnoreCase("mod+") || args.equalsIgnoreCase("mod+")
				|| args.equalsIgnoreCase("moderadorplus") || args.equalsIgnoreCase("moderador+")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set mod+");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §5§lMOD+");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §5§lMOD+");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §5§lMOD+");
				TittleAPI.sendTittle(toGroup, "§5§lMOD+");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.mod+")) {
					toGroup.chat("/tag mod+");
				}
			}
		} else if (args.equalsIgnoreCase("modgc") || args.equalsIgnoreCase("moderadorgc")
				|| args.equalsIgnoreCase("gcdetector")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set modgc");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §5§lMODGC");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §5§lMODGC");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §5§lMODGC");
				TittleAPI.sendTittle(toGroup, "§5§lMODGC");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.modgc")) {
					toGroup.chat("/tag modgc");
				}
			}
		} else if (args.equalsIgnoreCase("mod") || args.equalsIgnoreCase("moderador")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set mod");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §5§lMOD");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §5§lMOD");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §5§lMOD");
				TittleAPI.sendTittle(toGroup, "§5§lMOD");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.mod")) {
					toGroup.chat("/tag mod");
				}
			}
		} else if (args.equalsIgnoreCase("trial") || args.equalsIgnoreCase("trialmod")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set trial");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §d§lTRIAL");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §d§lTRIAL");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §d§lTRIAL");
				TittleAPI.sendTittle(toGroup, "§d§lTRIAL");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.trial")) {
					toGroup.chat("/tag trial");
				}
			}
		} else if (args.equalsIgnoreCase("builder") || args.equalsIgnoreCase("construtor")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set builder");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §e§lBUILDER");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §e§lBUILDER");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §e§lBUILDER");
				TittleAPI.sendTittle(toGroup, "§e§lBUILDER");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.builder")) {
					toGroup.chat("/tag builder");
				}
			}
		} else if (args.equalsIgnoreCase("ajudante") || args.equalsIgnoreCase("helper")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set ajudante");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §9§lAJUDANTE");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §9§lAJUDANTE");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §9§lAJUDANTE");
				TittleAPI.sendTittle(toGroup, "§9§lAJUDANTE");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.ajudante")) {
					toGroup.chat("/tag ajudante");
				}
			}
		} else if (args.equalsIgnoreCase("ytplus") || args.equalsIgnoreCase("yt+")
				|| args.equalsIgnoreCase("youtuberplus") || args.equalsIgnoreCase("youtuber+")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set yt+");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §3§lYOUTUBER+");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §3§lYOUTUBER+");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §3§lYOUTUBER+");
				TittleAPI.sendTittle(toGroup, "§3§lYOUTUBER+");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.yt+")) {
					toGroup.chat("/tag yt+");
				}
			}
		} else if (args.equalsIgnoreCase("yt") || args.equalsIgnoreCase("youtuber")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set yt");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §b§lYOUTUBER");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §b§lYOUTUBER");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §b§lYOUTUBER");
				TittleAPI.sendTittle(toGroup, "§b§lYOUTUBER");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.yt")) {
					toGroup.chat("/tag yt");
				}
			}
		} else if (args.equalsIgnoreCase("miniyt") || args.equalsIgnoreCase("semiyt")
				|| args.equalsIgnoreCase("semiyoutuber")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set miniyt");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §c§lMINIYT");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §c§lMINIYT");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §c§lMINIYT");
				TittleAPI.sendTittle(toGroup, "§c§lMINIYT");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.miniyt")) {
					toGroup.chat("/tag miniyt");
				}
			}
		} else if (args.equalsIgnoreCase("ultimate")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set ultimate");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §d§lULTIMATE");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §d§lULTIMATE");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §d§lULTIMATE");
				TittleAPI.sendTittle(toGroup, "§d§lULTIMATE");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.ultimate")) {
					toGroup.chat("/tag ultimate");
				}
			}
		} else if (args.equalsIgnoreCase("beta")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set beta");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §1§lBETA");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §1§lBETA");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §1§lBETA");
				TittleAPI.sendTittle(toGroup, "§1§lBETA");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.beta")) {
					toGroup.chat("/tag beta");
				}
			}
		} else if (args.equalsIgnoreCase("premium")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set premium");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §6§lPREMIUM");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §6§lPREMIUM");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §6§lPREMIUM");
				TittleAPI.sendTittle(toGroup, "§6§lPREMIUM");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.premium")) {
					toGroup.chat("/tag premium");
				}
			}
		} else if (args.equalsIgnoreCase("light")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set light");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §a§lLIGHT");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §a§lLIGHT");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §a§lLIGHT");
				TittleAPI.sendTittle(toGroup, "§a§lLIGHT");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.light")) {
					toGroup.chat("/tag light");
				}
			}
		} else if (args.equalsIgnoreCase("designer")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set designer");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §2§lDESIGNER");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §2§lDESIGNER");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §2§lDESIGNER");
				TittleAPI.sendTittle(toGroup, "§2§lDESIGNER");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				if (toGroup.hasPermission("pvp.tag.designer")) {
					toGroup.chat("/tag designer");
				}
			}
		} else if (args.equalsIgnoreCase("membro") || args.equalsIgnoreCase("normal")
				|| args.equalsIgnoreCase("default")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + playerName + " group set membro");
			sender.sendMessage(
					"§6§lSETGROUP§f O grupo do jogador §e§l" + playerName + " §ffoi §3§lALTERADO§f para §7§lMEMBRO");
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("pvp.cmd.setgroup")) {
					online.sendMessage(
							"§6§lSETGROUP§f " + sender.getName() + " §3§lALTEROU§f o grupo do §e" + playerName + "("
									+ Bukkit.getOfflinePlayer(playerName).getUniqueId() + ")§f para §7§lMEMBRO");
				}
			}
			if (toGroup != null) {
				toGroup.sendMessage("§6§lGROUP§f Seu grupo foi §3§lALTERADO§f para §7§lMEMBRO");
				TittleAPI.sendTittle(toGroup, "§7§lMEMBRO");
				TittleAPI.sendSubTittle(toGroup, "§fSeu grupo foi alterado");
				toGroup.chat("/tag membro");
			}
		} else {
			toGroup.sendMessage("§6§lSETGROUP§f Grupo não encontrado.");
		}
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.setgroup")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length <= 1) {
			sender.sendMessage("§6§lSETGROUP§f Utilize: /setgroup <player> (grupo)");
			return true;
		} else if (args.length == 2) {
			final Player toGroup = BattlePlayerAPI.BattlePlayer(args[0]);
			setGroupFromCommand(sender, toGroup, args[0], args[1]);
			return true;
		} else {
			sender.sendMessage("§6§lSETGROUP§f Utilize: /setgroup <player> (grupo)");
			return true;
		}
	}
}
