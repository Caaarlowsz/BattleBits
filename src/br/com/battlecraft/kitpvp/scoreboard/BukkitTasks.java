package br.com.battlecraft.kitpvp.scoreboard;

import org.bukkit.Bukkit;

import br.com.battlecraft.kitpvp.BukkitMain;

public final class BukkitTasks {

	public static int SPAWN = 1;
	public static int FPS = 1;
	public static int CHALLENGE = 1;
	public static int ONEVSONE = 1;
	public static int CAPIROTO = 1;
	public static int TAB = 1;
	public static int EVENTO = 1;

	public static String TittleSpawn = "BattleCraf";
	public static String TittleFps = "BattleCraf";
	public static String TittleChallenge = "BattleCraf";
	public static String TittleOneVsOne = "BattleCraf";
	public static String TittleCapiroto = "BattleCraf";
	public static String TittleTab = "BattleCraf";
	public static String TittleEvento = "BattleCraf";
	
	public static final void updateAllAnimations() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitMain.getPlugin(), new Runnable() {
			@Override
			public void run() {
				run_Spawn();
				run_Fps();
				run_1v1();
				run_Challenge();
				run_Capiroto();
				run_Evento();
			}			
		}, 0, 9L);
	}
	
	public static final void run_Evento() {
		if (EVENTO == 1) {
			TittleEvento = "BattleCraf";
		}
		if (EVENTO == 2) {
			TittleEvento = "attleCraft";
		}
		if (EVENTO == 3) {
			TittleEvento = "ttleCraft ";
		}
		if (EVENTO == 4) {
			TittleEvento = "tleCraft -";
		}
		if (EVENTO == 5) {
			TittleEvento = "leCraft - ";
		}
		if (EVENTO == 6) {
			TittleEvento = "eCraft - E";
		}
		if (EVENTO == 7) {
			TittleEvento = "Craft - Ev";
		}
		if (EVENTO == 8) {
			TittleEvento = "raft - Eve";
		}
		if (EVENTO == 9) {
			TittleEvento = "aft - Even";
		}
		if (EVENTO == 10) {
			TittleEvento = "ft - Event";
		}
		if (EVENTO == 11) {
			TittleEvento = "t - Evento";
		}
		if (EVENTO == 12) {
			TittleEvento = "- Evento -";
		}
		if (EVENTO == 13) {
			TittleEvento = " Evento - ";
		}
		if (EVENTO == 14) {
			TittleEvento = "Evento - B";
		}
		if (EVENTO == 15) {
			TittleEvento = "vento - Ba";
		}
		if (EVENTO == 16) {
			TittleEvento = "ento - Bat";
		}
		if (EVENTO == 17) {
			TittleEvento = "nto - Batt";
		}
		if (EVENTO == 18) {
			TittleEvento = "to - Battl";
		}
		if (EVENTO == 19) {
			TittleEvento = "o - Battle";
		}
		if (EVENTO == 20) {
			TittleEvento = " - BattleC";
		}
		if (EVENTO == 21) {
			TittleEvento = "- BattleCr";
		}
		if (EVENTO == 21) {
			TittleEvento = " BattleCra";
			EVENTO = 0;
		}
		EVENTO++;
	}
	
	public static final void run_Spawn() {
		if (SPAWN == 1) {
			TittleSpawn = "BattleCraf";
		}
		if (SPAWN == 2) {
			TittleSpawn = "attleCraft";
		}
		if (SPAWN == 3) {
			TittleSpawn = "ttleCraft ";
		}
		if (SPAWN == 4) {
			TittleSpawn = "tleCraft -";
		}
		if (SPAWN == 5) {
			TittleSpawn = "leCraft - ";
		}
		if (SPAWN == 6) {
			TittleSpawn = "eCraft - S";
		}
		if (SPAWN == 7) {
			TittleSpawn = "Craft - Sp";
		}
		if (SPAWN == 8) {
			TittleSpawn = "raft - Spa";
		}
		if (SPAWN == 9) {
			TittleSpawn = "aft - Spaw";
		}
		if (SPAWN == 10) {
			TittleSpawn = "ft - Spawn";
		}
		if (SPAWN == 11) {
			TittleSpawn = "t - Spawn ";
		}
		if (SPAWN == 12) {
			TittleSpawn = " - Spawn -";
		}
		if (SPAWN == 13) {
			TittleSpawn = "- Spawn - ";
		}
		if (SPAWN == 14) {
			TittleSpawn = " Spawn - B";
		}
		if (SPAWN == 15) {
			TittleSpawn = "Spawn - Ba";
		}
		if (SPAWN == 16) {
			TittleSpawn = "pawn - Bat";
		}
		if (SPAWN == 17) {
			TittleSpawn = "awn - Batt";
		}
		if (SPAWN == 18) {
			TittleSpawn = "wn - Battl";
		}
		if (SPAWN == 19) {
			TittleSpawn = "n - Battle";
		}
		if (SPAWN == 20) {
			TittleSpawn = " - BattleC";
		}
		if (SPAWN == 21) {
			TittleSpawn = "- BattleCr";
		}
		if (SPAWN == 21) {
			TittleSpawn = " BattleCra";
			SPAWN = 0;
		}
		SPAWN++;
	}
	
	public static final void run_Fps() {
		if (FPS == 1) {
			TittleFps = "BattleCraf";
		}
		if (FPS == 2) {
			TittleFps = "attleCraft";
		}
		if (FPS == 3) {
			TittleFps = "ttleCraft ";
		}
		if (FPS == 4) {
			TittleFps = "tleCraft -";
		}
		if (FPS == 5) {
			TittleFps = "leCraft - ";
		}
		if (FPS == 6) {
			TittleFps = "eCraft - F";
		}
		if (FPS == 7) {
			TittleFps = "Craft - FP";
		}
		if (FPS == 8) {
			TittleFps = "raft - FPS";
		}
		if (FPS == 9) {
			TittleFps = "aft - FPS ";
		}
		if (FPS == 10) {
			TittleFps = "ft - FPS -";
		}
		if (FPS == 11) {
			TittleFps = "t - FPS - ";
		}
		if (FPS == 12) {
			TittleFps = " - FPS - B";
		}
		if (FPS == 13) {
			TittleFps = "- FPS - Ba";
		}
		if (FPS == 14) {
			TittleFps = " FPS - Bat";
		}
		if (FPS == 15) {
			TittleFps = "FPS - Batt";
		}
		if (FPS == 16) {
			TittleFps = "PS - Battl";
		}
		if (FPS == 17) {
			TittleFps = "S - Battle";
		}
		if (FPS == 18) {
			TittleFps = " - BattleC";
		}
		if (FPS == 19) {
			TittleFps = "- BattleCr";
		}
		if (FPS == 20) {
			TittleFps = " BattleCra";
			FPS = 0;
		}
		FPS++;
	}
	
	public static final void run_1v1() {
		if (ONEVSONE == 1) {
			TittleOneVsOne = "BattleCraf";
		}
		if (ONEVSONE == 2) {
			TittleOneVsOne = "attleCraft";
		}
		if (ONEVSONE == 3) {
			TittleOneVsOne = "ttleCraft ";
		}
		if (ONEVSONE == 4) {
			TittleOneVsOne = "tleCraft -";
		}
		if (ONEVSONE == 5) {
			TittleOneVsOne = "leCraft - ";
		}
		if (ONEVSONE == 6) {
			TittleOneVsOne = "eCraft - 1";
		}
		if (ONEVSONE == 7) {
			TittleOneVsOne = "Craft - 1v";
		}
		if (ONEVSONE == 8) {
			TittleOneVsOne = "raft - 1v1";
		}
		if (ONEVSONE == 9) {
			TittleOneVsOne = "aft - 1v1 ";
		}
		if (ONEVSONE == 10) {
			TittleOneVsOne = "ft - 1v1 -";
		}
		if (ONEVSONE == 11) {
			TittleOneVsOne = "t - 1v1 - ";
		}
		if (ONEVSONE == 12) {
			TittleOneVsOne = " - 1v1 - B";
		}
		if (ONEVSONE == 13) {
			TittleOneVsOne = "- 1v1 - Ba";
		}
		if (ONEVSONE == 14) {
			TittleOneVsOne = " 1v1 - Bat";
		}
		if (ONEVSONE == 15) {
			TittleOneVsOne = "1v1 - Batt";
		}
		if (ONEVSONE == 16) {
			TittleOneVsOne = "v1 - Battl";
		}
		if (ONEVSONE == 17) {
			TittleOneVsOne = "1 - Battle";
		}
		if (ONEVSONE == 18) {
			TittleOneVsOne = " - BattleC";
		}
		if (ONEVSONE == 19) {
			TittleOneVsOne = "- BattleCr";
		}
		if (ONEVSONE == 20) {
			TittleOneVsOne = " BattleCra";
			ONEVSONE = 0;
		}
		ONEVSONE++;
	}
	
	public static final void run_Challenge() {
		if (CHALLENGE == 1) {
			TittleChallenge = "BattleCraf";
		}
		if (CHALLENGE == 2) {
			TittleChallenge = "attleCraft";
		}
		if (CHALLENGE == 3) {
			TittleChallenge = "ttleCraft ";
		}
		if (CHALLENGE == 4) {
			TittleChallenge = "tleCraft -";
		}
		if (CHALLENGE == 5) {
			TittleChallenge = "leCraft - ";
		}
		if (CHALLENGE == 6) {
			TittleChallenge = "eCraft - L";
		}
		if (CHALLENGE == 7) {
			TittleChallenge = "Craft - La";
		}
		if (CHALLENGE == 8) {
			TittleChallenge = "raft - Lav";
		}
		if (CHALLENGE == 9) {
			TittleChallenge = "aft - Lava";
		}
		if (CHALLENGE == 10) {
			TittleChallenge = "ft - Lava ";
		}
		if (CHALLENGE == 11) {
			TittleChallenge = "t - Lava C";
		}
		if (CHALLENGE == 12) {
			TittleChallenge = " - Lava Ch";
		}
		if (CHALLENGE == 13) {
			TittleChallenge = "- Lava Cha";
		}
		if (CHALLENGE == 14) {
			TittleChallenge = " Lava Chal";
		}
		if (CHALLENGE == 15) {
			TittleChallenge = "Lava Chall";
		}
		if (CHALLENGE == 16) {
			TittleChallenge = "ava Challe";
		}
		if (CHALLENGE == 17) {
			TittleChallenge = "va Challen";
		}
		if (CHALLENGE == 18) {
			TittleChallenge = "a Challeng";
		}
		if (CHALLENGE == 19) {
			TittleChallenge = " Challenge";
		}
		if (CHALLENGE == 20) {
			TittleChallenge = "Challenge ";
		}
		if (CHALLENGE == 21) {
			TittleChallenge = "hallenge -";
		}
		if (CHALLENGE == 22) {
			TittleChallenge = "allenge - ";
		}
		if (CHALLENGE == 23) {
			TittleChallenge = "llenge - B";
		}
		if (CHALLENGE == 24) {
			TittleChallenge = "lenge - Ba";
		}
		if (CHALLENGE == 25) {
			TittleChallenge = "enge - Bat";
		}
		if (CHALLENGE == 26) {
			TittleChallenge = "nge - Batt";
		}
		if (CHALLENGE == 27) {
			TittleChallenge = "ge - Battl";
		}
		if (CHALLENGE == 28) {
			TittleChallenge = "e - Battle";
		}
		if (CHALLENGE == 29) {
			TittleChallenge = " - BattleC";
		}
		if (CHALLENGE == 30) {
			TittleChallenge = "- BattleCr";
		}
		if (CHALLENGE == 31) {
			TittleChallenge = " BattleCra";
			CHALLENGE = 0;
		}
		CHALLENGE++;
	}
	
	public static final void run_Capiroto() {
		if (CAPIROTO == 1) {
			TittleCapiroto = "BattleCraf";
		}
		if (CAPIROTO == 2) {
			TittleCapiroto = "attleCraft";
		}
		if (CAPIROTO == 3) {
			TittleCapiroto = "ttleCraft ";
		}
		if (CAPIROTO == 4) {
			TittleCapiroto = "tleCraft -";
		}
		if (CAPIROTO == 5) {
			TittleCapiroto = "leCraft - ";
		}
		if (CAPIROTO == 6) {
			TittleCapiroto = "eCraft - C";
		}
		if (CAPIROTO == 7) {
			TittleCapiroto = "Craft - Ca";
		}
		if (CAPIROTO == 8) {
			TittleCapiroto = "raft - Cap";
		}
		if (CAPIROTO == 9) {
			TittleCapiroto = "aft - Capi";
		}
		if (CAPIROTO == 10) {
			TittleCapiroto = "ft - Capir";
		}
		if (CAPIROTO == 11) {
			TittleCapiroto = "t - Capiro";
		}
		if (CAPIROTO == 12) {
			TittleCapiroto = " - Capirot";
		}
		if (CAPIROTO == 13) {
			TittleCapiroto = "- Capiroto";
		}
		if (CAPIROTO == 14) {
			TittleCapiroto = " Capiroto ";
		}
		if (CAPIROTO == 15) {
			TittleCapiroto = "Capiroto -";
		}
		if (CAPIROTO == 16) {
			TittleCapiroto = "apiroto - ";
		}
		if (CAPIROTO == 17) {
			TittleCapiroto = "piroto - B";
		}
		if (CAPIROTO == 18) {
			TittleCapiroto = "iroto - Ba";
		}
		if (CAPIROTO == 19) {
			TittleCapiroto = "roto - Bat";
		}
		if (CAPIROTO == 20) {
			TittleCapiroto = "oto - Batt";
		}
		if (CAPIROTO == 21) {
			TittleCapiroto = "to - Battl";
		}
		if (CAPIROTO == 22) {
			TittleCapiroto = "o - Battle";
		}
		if (CAPIROTO == 23) {
			TittleCapiroto = " - BattleC";
		}
		if (CAPIROTO == 24) {
			TittleCapiroto = "- BattleCr";
		}
		if (CAPIROTO == 25) {
			TittleCapiroto = " BattleCra";
			CAPIROTO = 0;
		}
		CAPIROTO++;
	}
	
	public static final void run_Tab() {
		if (TAB == 1) {
			TittleTab = "BattleCraft";
		}
		if (TAB == 2) {
			TittleTab = "attleCraft";
		}
		if (TAB == 3) {
			TittleTab = "ttleCraft ";
		}
		if (TAB == 4) {
			TittleTab = "tleCraft -";
		}
		if (TAB == 5) {
			TittleTab = "leCraft - ";
		}
		if (TAB == 6) {
			TittleTab = "eCraft - K";
		}
		if (TAB == 7) {
			TittleTab = "Craft - Ki";
		}
		if (TAB == 8) {
			TittleTab = "raft - Kit";
		}
		if (TAB == 9) {
			TittleTab = "aft - KitP";
		}
		if (TAB == 10) {
			TittleTab = "ft - KitPv";
		}
		if (TAB == 11) {
			TittleTab = "t - KitPvP";
		}
		if (TAB == 12) {
			TittleTab = " - KitPvP ";
		}
		if (TAB == 13) {
			TittleTab = "- KitPvP -";
		}
		if (TAB == 14) {
			TittleTab = " KitPvP - ";
		}
		if (TAB == 15) {
			TittleTab = "KitPvP - B";
		}
		if (TAB == 16) {
			TittleTab = "itPvP - Ba";
		}
		if (TAB == 17) {
			TittleTab = "tPvP - Bat";
		}
		if (TAB == 18) {
			TittleTab = "PvP - Batt";
		}
		if (TAB == 19) {
			TittleTab = "vP - Battl";
		}
		if (TAB == 20) {
			TittleTab = "P - Battle";
		}
		if (TAB == 21) {
			TittleTab = " - BattleC";
		}
		if (TAB == 22) {
			TittleTab = "- BattleCr";
		}
		if (TAB == 23) {
			TittleTab = " BattleCra";
			TAB = 0;
		}
		TAB++;
	}
}
