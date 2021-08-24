package br.com.battlecraft.kitpvp.nametags;

import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.leagues.Leagues;

public final class BattleNametagAPI {

	public static final String DONO = "§4§l" + "DONO" + "§f, ";
	public static final String DIRETOR = "§4§l" + "DIRETOR" + "§f, ";
	public static final String GERENTE = "§c§l" + "GERENTE" + "§f, ";
	public static final String ADMIN = "§c§l" + "ADMIN" + "§f, ";
	public static final String MODPLUS = "§5§l" + "MOD+" + "§f, ";
	public static final String MODGC = "§5§l" + "MODGC" + "§f, ";
	public static final String MOD = "§5§l" + "MOD" + "§f, ";
	public static final String TRIAL = "§d§l" + "TRIAL" + "§f, ";
	public static final String BUILDER = "§e§l" + "BUILDER" + "§f, ";
	public static final String AJUDANTE = "§9§l" + "AJUDANTE" + "§f, ";
	public static final String YTPLUS = "§3§l" + "YT+" + "§f, ";
	public static final String YT = "§b§l" + "YT" + "§f, ";
	public static final String MINIYT = "§c§l" + "MINIYT" + "§f, ";
	public static final String ULTIMATE = "§d§l" + "ULTIMATE" + "§f, ";
	public static final String BETA = "§1§l" + "BETA" + "§f, ";
	public static final String PREMIUM = "§6§l" + "PREMIUM" + "§f, ";
	public static final String LIGHT = "§a§l" + "LIGHT" + "§f, ";
	public static final String DESIGNER = "§2§l" + "DESIGNER" + "§f, ";
	public static final String NORMAL = "§7§l" + "NORMAL";

	public static final String nullTag = "";

	public static final String getTagDONO(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.dono")) {
			return DONO;
		} else {
			return nullTag;
		}
	}

	public static final String getTagDIRETOR(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.diretor")) {
			return DIRETOR;
		} else {
			return nullTag;
		}
	}

	public static final String getTagGERENTE(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.gerente")) {
			return GERENTE;
		} else {
			return nullTag;
		}
	}

	public static final String getTagADMIN(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.admin")) {
			return ADMIN;
		} else {
			return nullTag;
		}
	}

	public static final String getTagMODPLUS(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.modplus")) {
			return MODPLUS;
		} else {
			return nullTag;
		}
	}

	public static final String getTagMODGC(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.modgc")) {
			return MODGC;
		} else {
			return nullTag;
		}
	}

	public static final String getTagMOD(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.mod")) {
			return MOD;
		} else {
			return nullTag;
		}
	}

	public static final String getTagTRIAL(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.trial")) {
			return TRIAL;
		} else {
			return nullTag;
		}
	}

	public static final String getTagBUILDER(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.builder")) {
			return BUILDER;
		} else {
			return nullTag;
		}
	}

	public static final String getTagAJUDANTE(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.ajudante")) {
			return AJUDANTE;
		} else {
			return nullTag;
		}
	}

	public static final String getTagYTPLUS(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.ytplus")) {
			return YTPLUS;
		} else {
			return nullTag;
		}
	}

	public static final String getTagYT(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.yt")) {
			return YT;
		} else {
			return nullTag;
		}
	}

	public static final String getTagMINIYT(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.miniyt")) {
			return MINIYT;
		} else {
			return nullTag;
		}
	}

	public static final String getTagULTIMATE(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.ultimate")) {
			return ULTIMATE;
		} else {
			return nullTag;
		}
	}

	public static final String getTagBETA(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.beta")) {
			return BETA;
		} else {
			return nullTag;
		}
	}

	public static final String getTagPREMIUM(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.premium")) {
			return PREMIUM;
		} else {
			return nullTag;
		}
	}

	public static final String getTagLIGHT(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.light")) {
			return LIGHT;
		} else {
			return nullTag;
		}
	}

	public static final String getTagDESIGNER(final Player bp) {
		if (BattlePlayerAPI.BattlePlayer(bp).hasPermission("pvp.tag.designer")) {
			return DESIGNER;
		} else {
			return nullTag;
		}
	}

	public static final String getTagNORMAL(final Player bp) {
		return NORMAL;
	}

	public static final void setTagFromCommand(final Player bp, final String args) {
		if (args.equalsIgnoreCase("dono") || args.equalsIgnoreCase("owner")) {
			setDONO(bp);
		} else if (args.equalsIgnoreCase("diretor")) {
			setDIRETOR(bp);
		} else if (args.equalsIgnoreCase("gerente")) {
			setGERENTE(bp);
		} else if (args.equalsIgnoreCase("admin") || args.equalsIgnoreCase("administrador")) {
			setADMIN(bp);
		} else if (args.equalsIgnoreCase("mod+") || args.equalsIgnoreCase("mod+")
				|| args.equalsIgnoreCase("moderadorplus") || args.equalsIgnoreCase("moderador+")) {
			setMODPLUS(bp);
		} else if (args.equalsIgnoreCase("modgc") || args.equalsIgnoreCase("moderadorgc")
				|| args.equalsIgnoreCase("gcdetector")) {
			setMODGC(bp);
		} else if (args.equalsIgnoreCase("mod") || args.equalsIgnoreCase("moderador")) {
			setMOD(bp);
		} else if (args.equalsIgnoreCase("trial") || args.equalsIgnoreCase("trialmod")) {
			setTRIAL(bp);
		} else if (args.equalsIgnoreCase("builder") || args.equalsIgnoreCase("construtor")) {
			setBUILDER(bp);
		} else if (args.equalsIgnoreCase("ajudante") || args.equalsIgnoreCase("helper")) {
			setAJUDANTE(bp);
		} else if (args.equalsIgnoreCase("ytplus") || args.equalsIgnoreCase("yt+")
				|| args.equalsIgnoreCase("youtuberplus") || args.equalsIgnoreCase("youtuber+")) {
			setYTPLUS(bp);
		} else if (args.equalsIgnoreCase("yt") || args.equalsIgnoreCase("youtuber")) {
			setYT(bp);
		} else if (args.equalsIgnoreCase("miniyt") || args.equalsIgnoreCase("semiyt")
				|| args.equalsIgnoreCase("semiyoutuber")) {
			setMINIYT(bp);
		} else if (args.equalsIgnoreCase("ultimate")) {
			setULTIMATE(bp);
		} else if (args.equalsIgnoreCase("beta")) {
			setBETA(bp);
		} else if (args.equalsIgnoreCase("premium")) {
			setPREMIUM(bp);
		} else if (args.equalsIgnoreCase("light")) {
			setLIGHT(bp);
		} else if (args.equalsIgnoreCase("designer")) {
			setDESIGNER(bp);
		} else if (args.equalsIgnoreCase("membro") || args.equalsIgnoreCase("normal")
				|| args.equalsIgnoreCase("default")) {
			setNORMAL(bp);
		} else {
			bp.sendMessage("§3§lTAGS§f Esta §9§lTAG§f não foi encontrada!");
		}
	}

	public static final void checkBattlePlayerTags(final Player bp) {
		BattlePlayerAPI.BattlePlayer(bp).sendMessage("§3§lTAGS§f Selecione uma das §9§lTAGS§f Listadas abaixo:");
		BattlePlayerAPI.BattlePlayer(bp)
				.sendMessage(getTagDONO(bp) + getTagDIRETOR(bp) + getTagGERENTE(bp) + getTagADMIN(bp)
						+ getTagMODPLUS(bp) + getTagMODGC(bp) + getTagMOD(bp) + getTagTRIAL(bp) + getTagBUILDER(bp)
						+ getTagAJUDANTE(bp) + getTagYTPLUS(bp) + getTagYT(bp) + getTagMINIYT(bp) + getTagULTIMATE(bp)
						+ getTagBETA(bp) + getTagPREMIUM(bp) + getTagLIGHT(bp) + getTagDESIGNER(bp) + getTagNORMAL(bp));
	}

	public static final void loadBattlePlayerTagFromJoin(final Player bp) {
		if (bp.hasPermission("pvp.tag.dono")) {
			setNametag(bp, "§4§lDONO §4", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.diretor")) {
			setNametag(bp, "§4§lDIRETOR §4", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.gerente")) {
			setNametag(bp, "§c§lGERENTE §c", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.admin")) {
			setNametag(bp, "§c§lADMIN §c", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.modplus")) {
			setNametag(bp, "§5§lMOD+ §5", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.modgc")) {
			setNametag(bp, "§5§lMODGC §5", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.mod")) {
			setNametag(bp, "§5§lMOD §5", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.trial")) {
			setNametag(bp, "§d§lTRIAL §d", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.builder")) {
			setNametag(bp, "§e§lBUILDER §e", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.ajudante")) {
			setNametag(bp, "§9§lAJUDANTE §9", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.ytplus")) {
			setNametag(bp, "§3§lYOUTUBER+ §3", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.yt")) {
			setNametag(bp, "§b§lYOUTUBER §b", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.miniyt")) {
			setNametag(bp, "§c§lMINIYT §c", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.ultimate")) {
			setNametag(bp, "§d§lULTIMATE §d", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.beta")) {
			setNametag(bp, "§1§lBETA §1", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.premium")) {
			setNametag(bp, "§6§lPREMIUM §6", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.light")) {
			setNametag(bp, "§a§lLIGHT §a", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else if (bp.hasPermission("pvp.tag.designer")) {
			setNametag(bp, "§2§lDESIGNER §2", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		} else {
			setNametag(bp, "§7", " " + Leagues.getBattlePlayerLeagueInChat(bp));
			return;
		}
	}

	public static final String getPlayerGroup(final Player bp) {
		if (bp.hasPermission("pvp.tag.dono")) {
			return "§4§lDONO §4";
		} else if (bp.hasPermission("pvp.tag.diretor")) {
			return "§4§lDIRETOR §4";
		} else if (bp.hasPermission("pvp.tag.gerente")) {
			return "§c§lGERENTE §c";
		} else if (bp.hasPermission("pvp.tag.admin")) {
			return "§c§lADMIN §c";
		} else if (bp.hasPermission("pvp.tag.modplus")) {
			return "§5§lMOD+ §5";
		} else if (bp.hasPermission("pvp.tag.modgc")) {
			return "§5§lMODGC §5";
		} else if (bp.hasPermission("pvp.tag.mod")) {
			return "§5§lMOD §5";
		} else if (bp.hasPermission("pvp.tag.trial")) {
			return "§d§lTRIAL §d";
		} else if (bp.hasPermission("pvp.tag.builder")) {
			return "§e§lBUILDER §e";
		} else if (bp.hasPermission("pvp.tag.ajudante")) {
			return "§9§lAJUDANTE §9";
		} else if (bp.hasPermission("pvp.tag.ytplus")) {
			return "§3§lYOUTUBER+ §3";
		} else if (bp.hasPermission("pvp.tag.yt")) {
			return "§b§lYOUTUBER §b";
		} else if (bp.hasPermission("pvp.tag.miniyt")) {
			return "§c§lMINIYT §c";
		} else if (bp.hasPermission("pvp.tag.ultimate")) {
			return "§d§lULTIMATE §d";
		} else if (bp.hasPermission("pvp.tag.beta")) {
			return "§1§lBETA §1";
		} else if (bp.hasPermission("pvp.tag.premium")) {
			return "§6§lPREMIUM §6";
		} else if (bp.hasPermission("pvp.tag.light")) {
			return "§a§lLIGHT §a";
		} else if (bp.hasPermission("pvp.tag.designer")) {
			return "§2§lDESIGNER §2";
		} else {
			return "§7§lMEMBRO";
		}
	}

	public static final void setNametag(final Player bp, String tagPrefix, String tagSuffix) {
		bp.setDisplayName(tagPrefix + bp.getName() + tagSuffix);
		NametagAPI.setBattlePlayerNametag(bp.getName(), tagPrefix, tagSuffix);
	}

	public static final void setDONO(final Player bp) {
		if (!bp.hasPermission("pvp.tag.dono")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §4§lDONO§f.");
			return;
		}
		setNametag(bp, "§4§lDONO §4", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §4§lDONO§f.");
	}

	public static final void setDIRETOR(final Player bp) {
		if (!bp.hasPermission("pvp.tag.diretor")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §4§lDIRETOR§f.");
			return;
		}
		setNametag(bp, "§4§lDIRETOR §4", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §4§lDIRETOR§f.");
	}

	public static final void setGERENTE(final Player bp) {
		if (!bp.hasPermission("pvp.tag.gerente")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §c§lGERENTE§f.");
			return;
		}
		setNametag(bp, "§c§lGERENTE §c", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §c§lGERENTE§f.");
	}

	public static final void setADMIN(final Player bp) {
		if (!bp.hasPermission("pvp.tag.admin")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §c§lADMIN§f.");
			return;
		}
		setNametag(bp, "§c§lADMIN §c", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §c§lADMIN§f.");
	}

	public static final void setMODPLUS(final Player bp) {
		if (!bp.hasPermission("pvp.tag.modplus")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §5§lMOD+§f.");
			return;
		}
		setNametag(bp, "§5§lMOD+ §5", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §5§lMOD+§f.");
	}

	public static final void setMODGC(final Player bp) {
		if (!bp.hasPermission("pvp.tag.modgc")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §5§lMODGC§f.");
			return;
		}
		setNametag(bp, "§5§lMODGC §5", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §5§lMODGC§f.");
	}

	public static final void setMOD(final Player bp) {
		if (!bp.hasPermission("pvp.tag.mod")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §5§lMOD§f.");
			return;
		}
		setNametag(bp, "§5§lMOD §5", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §5§lMOD§f.");
	}

	public static final void setTRIAL(final Player bp) {
		if (!bp.hasPermission("pvp.tag.trial")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §d§lTRIAL§f.");
			return;
		}
		setNametag(bp, "§d§lTRIAL §d", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §d§lTRIAL§f.");
	}

	public static final void setBUILDER(final Player bp) {
		if (!bp.hasPermission("pvp.tag.builder")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §e§lBUILDER§f.");
			return;
		}
		setNametag(bp, "§e§lBUILDER §e", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §e§lBUILDER§f.");
	}

	public static final void setAJUDANTE(final Player bp) {
		if (!bp.hasPermission("pvp.tag.ajudante")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §9§lAJUDANTE§f.");
			return;
		}
		setNametag(bp, "§9§lAJUDANTE §9", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §9§lAJUDANTE§f.");
	}

	public static final void setYTPLUS(final Player bp) {
		if (!bp.hasPermission("pvp.tag.ytplus")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §3§lYOUTUBER+§f.");
			return;
		}
		setNametag(bp, "§3§lYOUTUBER+ §3", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §3§lYOUTUBER+§f.");
	}

	public static final void setYT(final Player bp) {
		if (!bp.hasPermission("pvp.tag.yt")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §b§lYOUTUBER§f.");
			return;
		}
		setNametag(bp, "§b§lYOUTUBER §b", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §b§lYOUTUBER§f.");
	}

	public static final void setMINIYT(final Player bp) {
		if (!bp.hasPermission("pvp.tag.miniyt")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §c§lMINIYT§f.");
			return;
		}
		setNametag(bp, "§c§lMINIYT §c", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §c§lMINIYT§f.");
	}

	public static final void setULTIMATE(final Player bp) {
		if (!bp.hasPermission("pvp.tag.ultimate")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §d§lULTIMATE§f.");
			return;
		}
		setNametag(bp, "§d§lULTIMATE §d", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §d§lULTIMATE§f.");
	}

	public static final void setBETA(final Player bp) {
		if (!bp.hasPermission("pvp.tag.beta")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §1§lBETA§f.");
			return;
		}
		setNametag(bp, "§1§lBETA §1", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §1§lBETA§f.");
	}

	public static final void setPREMIUM(final Player bp) {
		if (!bp.hasPermission("pvp.tag.premium")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §6§lPREMIUM§f.");
			return;
		}
		setNametag(bp, "§6§lPREMIUM §6", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §6§lPREMIUM§f.");
	}

	public static final void setLIGHT(final Player bp) {
		if (!bp.hasPermission("pvp.tag.light")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §a§lLIGHT§f.");
			return;
		}
		setNametag(bp, "§a§lLIGHT §a", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §a§lLIGHT§f.");
	}

	public static final void setDESIGNER(final Player bp) {
		if (!bp.hasPermission("pvp.tag.designer")) {
			bp.sendMessage("§3§lTAGS§f Você não possui a §9§lTAG §2§lDESIGNER§f.");
			return;
		}
		setNametag(bp, "§2§lDESIGNER §2", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §2§lDESIGNER§f.");
	}

	public static final void setNORMAL(final Player bp) {
		setNametag(bp, "§7", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		bp.sendMessage("§9§lTAGS§f Voce agora esta §3§lUTILIZANDO§f a tag §7§lNORMAL§f.");
	}
}
