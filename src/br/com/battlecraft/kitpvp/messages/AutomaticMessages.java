package br.com.battlecraft.kitpvp.messages;

import org.bukkit.Bukkit;

import br.com.battlecraft.kitpvp.BukkitMain;

public class AutomaticMessages {

	private static final String prefix = "§6§lBattleBits§8§l>> ";

	private static final boolean onAutoMessages = true;

	private static final int ticks = 60;

	private static int messages = 1;

	public static void runAutoMessages() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				AutoMessages();
			}
		}, 0, ticks * 20);
	}

	public static void AutoMessages() {
		if (!onAutoMessages) {
			return;
		}
		if (messages == 1) {
			Bukkit.getServer().broadcastMessage(
					prefix + "§eSiga @BattleBitsMC no Twitter para ter suporte e mais informaçoes sobre nossa rede");
		}
		if (messages == 2) {
			Bukkit.getServer().broadcastMessage(prefix + "§cPara reportar um HACKER, utilize o comando /report");
		}
		if (messages == 3) {
			Bukkit.getServer()
					.broadcastMessage(prefix + "§bAplique-se para um CARGO DE STAFFER utilizando o comando /aplicar");
		}
		if (messages == 4) {
			Bukkit.getServer().broadcastMessage(prefix
					+ "§aCansado de usar o mesmo kit? Compre um novo com suas MOEDAS na LOJA INTERNA do servidor!");
		}
		if (messages == 5) {
			Bukkit.getServer()
					.broadcastMessage(prefix + "§2Dificuldades para conseguir MOEDAS? Tente o Lava Challenge!");
		}
		if (messages == 6) {
			Bukkit.getServer().broadcastMessage(
					prefix + "§6Adiquira ja o seu VIP para ter acesso a beneficios no servidor! Utilize /loja");
		}
		if (messages == 7) {
			Bukkit.getServer().broadcastMessage(prefix + "§eAcesse o site OFICIAL do servidor: www.battlebits.com.br");
		}
		if (messages == 8) {
			Bukkit.getServer()
					.broadcastMessage(prefix + "§9Utilize o comando /rank para checar os detalhes de sua LIGA");
		}
		if (messages == 9) {
			Bukkit.getServer().broadcastMessage(prefix + "§3Quer retornar ao LOBBY? Utilize o comando /lobby");
			messages = 0;
		}
		messages++;
	}
}
