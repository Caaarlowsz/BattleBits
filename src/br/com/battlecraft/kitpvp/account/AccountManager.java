package br.com.battlecraft.kitpvp.account;

public final class AccountManager {

	public static boolean hasAccount(final String bpName) {
		if (AccountFile.getAccountsFile().contains("BattleAccounts." + bpName.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
}