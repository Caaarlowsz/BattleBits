package br.com.battlecraft.kitpvp.utils;

public final class BattleStrings {
	
	public static final String BattlePlayerIsNotOnline = "§4§lERRO§f Este player não está §c§lonline§f!";
	public static final String NoPermissionToCommand = "§c§lPERMISSAO§f Você não tem §c§lPERMISSAO§f para usar este comando!";
	public static final String CommandOnlyInGame = "§4§lERRO§f Comando disponivel apenas §c§lin-game§f!";
	public static final String NoPermissionToKit = "§3§lKIT§f Você não tem este §b§lkit§f!";
	
	public static final String getBattlePlayerIsNotOnlineMessage() {
		return BattlePlayerIsNotOnline;
	}
	public static final String getNoPermissionToCommandMessage() {
		return NoPermissionToCommand;
	}
	public static final String getCommandOnlyInGameMessage() {
		return CommandOnlyInGame;
	}
}