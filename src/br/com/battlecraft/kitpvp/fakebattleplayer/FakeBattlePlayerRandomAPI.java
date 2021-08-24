package br.com.battlecraft.kitpvp.fakebattleplayer;

import java.util.Random;

import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;

public final class FakeBattlePlayerRandomAPI {

	public static final String ExceptionFakeRandomMessage = "§cUm erro interno ocorreu enquanto tentava setar seu fake random! Tente novamente.";

	public static final Object setRandomBattlePlayerFakeName(final Player bp, final String randomFake)
			throws IllegalArgumentException, NullPointerException {
		if (randomFake == null || randomFake == "" || randomFake.equals("")) {
			NullPointerException e = new NullPointerException(
					"O nick random nao pode ser nulo! Cheque se nenhum nick esta em branco");
			e.printStackTrace();
			bp.sendMessage(ExceptionFakeRandomMessage);
			return null;
		}
		if (randomFake.length() < 3) {
			IllegalArgumentException e = new IllegalArgumentException(
					"O nick random '" + randomFake + "' nao pode ter menos de 3 caracteres");
			e.printStackTrace();
			bp.sendMessage(ExceptionFakeRandomMessage);
			return null;
		}
		if (randomFake.length() > 16) {
			IllegalArgumentException e = new IllegalArgumentException(
					"O nick random '" + randomFake + "' nao pode ter mais que 16 caracteres");
			e.printStackTrace();
			bp.sendMessage(ExceptionFakeRandomMessage);
			return null;
		}
		if (!BattlePlayerAPI.validate(randomFake)) {
			IllegalArgumentException e = new IllegalArgumentException(
					"O formato do nick random '" + randomFake + "' e ilegal");
			e.printStackTrace();
			bp.sendMessage(ExceptionFakeRandomMessage);
			return null;
		}
		FakeBattlePlayerAPI.setBattlePlayerFakeName(bp, randomFake);
		return null;
	}

	public static final void setRandomFakeToBattlePlayer(final Player bp)
			throws IllegalArgumentException, NullPointerException {
		switch (new Random().nextInt(RandomNames.getTotalFakeRandoms())) {
		case 0:
			setRandomBattlePlayerFakeName(bp, RandomNames.f1);
			break;
		case 1:
			setRandomBattlePlayerFakeName(bp, RandomNames.f1);
			break;
		case 2:
			setRandomBattlePlayerFakeName(bp, RandomNames.f2);
			break;
		case 3:
			setRandomBattlePlayerFakeName(bp, RandomNames.f3);
			break;
		case 4:
			setRandomBattlePlayerFakeName(bp, RandomNames.f4);
			break;
		case 5:
			setRandomBattlePlayerFakeName(bp, RandomNames.f5);
			break;
		case 6:
			setRandomBattlePlayerFakeName(bp, RandomNames.f6);
			break;
		case 7:
			setRandomBattlePlayerFakeName(bp, RandomNames.f7);
			break;
		case 8:
			setRandomBattlePlayerFakeName(bp, RandomNames.f8);
			break;
		case 9:
			setRandomBattlePlayerFakeName(bp, RandomNames.f9);
			break;
		case 10:
			setRandomBattlePlayerFakeName(bp, RandomNames.f10);
			break;
		case 11:
			setRandomBattlePlayerFakeName(bp, RandomNames.f11);
			break;
		case 12:
			setRandomBattlePlayerFakeName(bp, RandomNames.f12);
			break;
		case 13:
			setRandomBattlePlayerFakeName(bp, RandomNames.f13);
			break;
		case 14:
			setRandomBattlePlayerFakeName(bp, RandomNames.f14);
			break;
		case 15:
			setRandomBattlePlayerFakeName(bp, RandomNames.f15);
			break;
		case 16:
			setRandomBattlePlayerFakeName(bp, RandomNames.f16);
			break;
		case 17:
			setRandomBattlePlayerFakeName(bp, RandomNames.f17);
			break;
		case 18:
			setRandomBattlePlayerFakeName(bp, RandomNames.f18);
			break;
		case 19:
			setRandomBattlePlayerFakeName(bp, RandomNames.f19);
			break;
		case 20:
			setRandomBattlePlayerFakeName(bp, RandomNames.f20);
			break;
		}
	}
}