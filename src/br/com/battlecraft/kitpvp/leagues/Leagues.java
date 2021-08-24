package br.com.battlecraft.kitpvp.leagues;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.account.AccountAPI;

public final class Leagues {

	public static final String UNRANKED_SYMBOL = "§f" + "-";
	public static final String PRIMARY_SYMBOL = "§a" + "☰";
	public static final String ADVANCED_SYMBOL = "§e" + "☲";
	public static final String EXPERT_SYMBOL = "§1" + "☷";
	public static final String SILVER_SYMBOL = "§7" + "✶";
	public static final String GOLD_SYMBOL = "§6" + "✷";
	public static final String DIAMOND_SYMBOL = "§b" + "✦";
	public static final String ELITE_SYMBOL = "§5" + "✹";
	public static final String MASTER_SYMBOL = "§c" + "✫";
	public static final String LEGENDARY_SYMBOL = "§4" + "✪";
	public static final String CHALLENGER_SYMBOL = "§3" + "☯";

	public static final String UNRANKED_NAME = "§f" + "UNRANKED";
	public static final String PRIMARY_NAME = "§a" + "PRIMARY";
	public static final String ADVANCED_NAME = "§e" + "ADVANCED";
	public static final String EXPERT_NAME = "§1" + "EXPERT";
	public static final String SILVER_NAME = "§7" + "SILVER";
	public static final String GOLD_NAME = "§6" + "GOLD";
	public static final String DIAMOND_NAME = "§b" + "DIAMOND";
	public static final String ELITE_NAME = "§5" + "ELITE";
	public static final String MASTER_NAME = "§c" + "MASTER";
	public static final String LEGENDARY_NAME = "§4" + "LEGENDARY";
	public static final String CHALLENGER_NAME = "§3" + "CHALLENGER";

	public static final String space = " ";

	public static final String getBattlePlayerLeagueInChat(final Player bp) {
		final int XP = AccountAPI.getBattlePlayerXp(bp);
		if (XP <= 2999) {
			return "§7(" + UNRANKED_SYMBOL + "§7)";
		} else if (XP >= 3000 && XP <= 6999) {
			return "§7(" + PRIMARY_SYMBOL + "§7)";
		} else if (XP >= 7000 && XP <= 11999) {
			return "§7(" + ADVANCED_SYMBOL + "§7)";
		} else if (XP >= 12000 && XP <= 17999) {
			return "§7(" + EXPERT_SYMBOL + "§7)";
		} else if (XP >= 18000 && XP <= 24999) {
			return "§7(" + SILVER_SYMBOL + "§7)";
		} else if (XP >= 25000 && XP <= 29999) {
			return "§7(" + GOLD_SYMBOL + "§7)";
		} else if (XP >= 30000 && XP <= 39999) {
			return "§7(" + DIAMOND_SYMBOL + "§7)";
		} else if (XP >= 40000 && XP <= 49999) {
			return "§7(" + ELITE_SYMBOL + "§7)";
		} else if (XP >= 50000 && XP <= 69999) {
			return "§7(" + MASTER_SYMBOL + "§7)";
		} else if (XP >= 70000 && XP <= 99999) {
			return "§7(" + LEGENDARY_SYMBOL + "§7)";
		} else if (XP >= 100000) {
			return "§7(" + CHALLENGER_SYMBOL + "§7)";
		}
		return getBattlePlayerLeagueInChat(bp);
	}

	public static final String getBattlePlayerLeagueInScore(final Player bp) {
		final int XP = AccountAPI.getBattlePlayerXp(bp);
		if (XP <= 2999) {
			return UNRANKED_SYMBOL + space + UNRANKED_NAME;
		} else if (XP >= 3000 && XP <= 6999) {
			return PRIMARY_SYMBOL + space + PRIMARY_NAME;
		} else if (XP >= 7000 && XP <= 11999) {
			return ADVANCED_SYMBOL + space + ADVANCED_NAME;
		} else if (XP >= 12000 && XP <= 17999) {
			return ADVANCED_SYMBOL + space + ADVANCED_NAME;
		} else if (XP >= 18000 && XP <= 24999) {
			return SILVER_SYMBOL + space + SILVER_NAME;
		} else if (XP >= 25000 && XP <= 29999) {
			return GOLD_SYMBOL + space + GOLD_NAME;
		} else if (XP >= 30000 && XP <= 39999) {
			return DIAMOND_SYMBOL + space + DIAMOND_NAME;
		} else if (XP >= 40000 && XP <= 49999) {
			return ELITE_SYMBOL + space + ELITE_NAME;
		} else if (XP >= 50000 && XP <= 69999) {
			return MASTER_SYMBOL + space + MASTER_NAME;
		} else if (XP >= 70000 && XP <= 99999) {
			return LEGENDARY_SYMBOL + space + LEGENDARY_NAME;
		} else if (XP >= 100000) {
			return CHALLENGER_SYMBOL + space + CHALLENGER_NAME;
		}
		return getBattlePlayerLeagueInScore(bp);
	}

	public static final String getBattlePlayerLeagueInScore(final OfflinePlayer bp) {
		final int XP = AccountAPI.getBattlePlayerXp(bp);
		if (XP <= 2999) {
			return UNRANKED_SYMBOL + space + UNRANKED_NAME;
		} else if (XP >= 3000 && XP <= 6999) {
			return PRIMARY_SYMBOL + space + PRIMARY_NAME;
		} else if (XP >= 7000 && XP <= 11999) {
			return ADVANCED_SYMBOL + space + ADVANCED_NAME;
		} else if (XP >= 12000 && XP <= 17999) {
			return ADVANCED_SYMBOL + space + ADVANCED_NAME;
		} else if (XP >= 18000 && XP <= 24999) {
			return SILVER_SYMBOL + space + SILVER_NAME;
		} else if (XP >= 25000 && XP <= 29999) {
			return GOLD_SYMBOL + space + GOLD_NAME;
		} else if (XP >= 30000 && XP <= 39999) {
			return DIAMOND_SYMBOL + space + DIAMOND_NAME;
		} else if (XP >= 40000 && XP <= 49999) {
			return ELITE_SYMBOL + space + ELITE_NAME;
		} else if (XP >= 50000 && XP <= 69999) {
			return MASTER_SYMBOL + space + MASTER_NAME;
		} else if (XP >= 70000 && XP <= 99999) {
			return LEGENDARY_SYMBOL + space + LEGENDARY_NAME;
		} else if (XP >= 100000) {
			return CHALLENGER_SYMBOL + space + CHALLENGER_NAME;
		}
		return getBattlePlayerLeagueInScore(bp);
	}

	public static final String getBattlePlayerLeagueInCommand(final Player bp) {
		final int XP = AccountAPI.getBattlePlayerXp(bp);
		if (XP <= 2999) {
			return "§f§l" + "-" + space + "UNRANKED";
		} else if (XP >= 3000 && XP <= 6999) {
			return "§a§l" + "☰" + space + "PRIMARY";
		} else if (XP >= 7000 && XP <= 11999) {
			return "§e§l" + "☲" + space + "ADVANCED";
		} else if (XP >= 12000 && XP <= 17999) {
			return "§1§l" + "☷" + space + "EXPERT";
		} else if (XP >= 18000 && XP <= 24999) {
			return "§7§l" + "✶" + space + "SILVER";
		} else if (XP >= 25000 && XP <= 29999) {
			return "§6§l" + "✷" + space + "GOLD";
		} else if (XP >= 30000 && XP <= 39999) {
			return "§b§l" + "✦" + space + "DIAMOND";
		} else if (XP >= 40000 && XP <= 49999) {
			return "§5§l" + "✹" + space + "ELITE";
		} else if (XP >= 50000 && XP <= 69999) {
			return "§c§l" + "✫" + space + "MASTER";
		} else if (XP >= 70000 && XP <= 99999) {
			return "§4§l" + "✪" + space + "LEGENDARY";
		} else if (XP >= 100000) {
			return "§3§l" + "☯" + space + "CHALLENGER";
		}
		return getBattlePlayerLeagueInCommand(bp);
	}

	public static final String getBattlePlayerLeagueByXp(final int XP) {
		if (XP <= 2999) {
			return "§f" + "-" + space + "UNRANKED";
		} else if (XP >= 3000 && XP <= 6999) {
			return "§a" + "☰" + space + "PRIMARY";
		} else if (XP >= 7000 && XP <= 11999) {
			return "§e" + "☲" + space + "ADVANCED";
		} else if (XP >= 12000 && XP <= 17999) {
			return "§1" + "☷" + space + "EXPERT";
		} else if (XP >= 18000 && XP <= 24999) {
			return "§7" + "✶" + space + "SILVER";
		} else if (XP >= 25000 && XP <= 29999) {
			return "§6" + "✷" + space + "GOLD";
		} else if (XP >= 30000 && XP <= 39999) {
			return "§b" + "✦" + space + "DIAMOND";
		} else if (XP >= 40000 && XP <= 49999) {
			return "§5" + "✹" + space + "ELITE";
		} else if (XP >= 50000 && XP <= 69999) {
			return "§c" + "✫" + space + "MASTER";
		} else if (XP >= 70000 && XP <= 99999) {
			return "§4" + "✪" + space + "LEGENDARY";
		} else if (XP >= 100000) {
			return "§3" + "☯" + space + "CHALLENGER";
		}
		return getBattlePlayerLeagueByXp(XP);
	}

	public static final String getBattlePlayerNextLeague(final Player bp) {
		final int XP = AccountAPI.getBattlePlayerXp(bp);
		if (XP <= 2999) {
			return "§a§l" + "☰" + space + "PRIMARY";
		} else if (XP >= 3000 && XP <= 6999) {
			return "§e§l" + "☲" + space + "ADVANCED";
		} else if (XP >= 7000 && XP <= 11999) {
			return "§1§l" + "☷" + space + "EXPERT";
		} else if (XP >= 12000 && XP <= 17999) {
			return "§7§l" + "✶" + space + "SILVER";
		} else if (XP >= 18000 && XP <= 24999) {
			return "§6§l" + "✷" + space + "GOLD";
		} else if (XP >= 25000 && XP <= 29999) {
			return "§b§l" + "✦" + space + "DIAMOND";
		} else if (XP >= 30000 && XP <= 39999) {
			return "§5§l" + "✹" + space + "ELITE";
		} else if (XP >= 40000 && XP <= 49999) {
			return "§c§l" + "✫" + space + "MASTER";
		} else if (XP >= 50000 && XP <= 69999) {
			return "§4§l" + "✪" + space + "LEGENDARY";
		} else if (XP >= 70000 && XP <= 99999) {
			return "§3§l" + "☯" + space + "CHALLENGER";
		} else if (XP >= 100000) {
			return "§fVocê §c§lZEROU§f as §6§lLIGAS§f do servidor!";
		}
		return getBattlePlayerNextLeague(bp);
	}

	public static final int getBattlePlayerLeagueXpLeft(final Player bp) {
		final int XP = AccountAPI.getBattlePlayerXp(bp);
		if (XP < 3000) {
			return 3000 - XP;
		} else if (XP >= 3000 && XP < 7000) {
			return 7000 - XP;
		} else if (XP >= 7000 && XP < 12000) {
			return 12000 - XP;
		} else if (XP >= 12000 && XP < 18000) {
			return 18000 - XP;
		} else if (XP >= 18000 && XP < 25000) {
			return 25000 - XP;
		} else if (XP >= 25000 && XP < 30000) {
			return 30000 - XP;
		} else if (XP >= 30000 && XP < 40000) {
			return 40000 - XP;
		} else if (XP >= 40000 && XP < 50000) {
			return 50000 - XP;
		} else if (XP >= 50000 && XP < 70000) {
			return 70000 - XP;
		} else if (XP >= 70000 && XP < 100000) {
			return 100000 - XP;
		} else if (XP >= 100000) {
			return 0;
		}
		return getBattlePlayerLeagueXpLeft(bp);
	}
}
