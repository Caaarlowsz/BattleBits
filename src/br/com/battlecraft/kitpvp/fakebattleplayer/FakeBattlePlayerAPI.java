package br.com.battlecraft.kitpvp.fakebattleplayer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.google.common.base.Preconditions;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountManager;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.nametags.BattleNametagAPI;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutNamedEntitySpawn;
import net.minecraft.util.com.mojang.authlib.GameProfile;

public final class FakeBattlePlayerAPI {

	public static final ArrayList<Player> hasFakeName = new ArrayList<>();
	public static final HashMap<Player, String> fakeName = new HashMap<>();
	public static final HashMap<Player, String> realName = new HashMap<>();

	public static final void changeBattlePlayerName(final Player bp, final String fakeName) {
		EntityPlayer ep = ((CraftPlayer) bp).getHandle();
		PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn(ep);
		try {
			Field field = packet.getClass().getDeclaredField("b");
			field.setAccessible(true);
			GameProfile gameProfile = (GameProfile) field.get(packet);
			Field name = gameProfile.getClass().getDeclaredField("name");
			name.setAccessible(true);
			name.set(gameProfile, fakeName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Player[] arrayOfPlayer;
		@SuppressWarnings("deprecation")
		int name2 = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int gameProfile2 = 0; gameProfile2 < name2; gameProfile2++) {
			Player p2 = arrayOfPlayer[gameProfile2];
			if (p2 != bp) {
				((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet);
			}
		}
	}

	public static final void hidePlayer(final Player player, final Player forWhom) {
		Preconditions.checkState(true, "Not Enabled!");
		Preconditions.checkNotNull(player, "player");
		Preconditions.checkNotNull(forWhom, "forWhom");
		if ((player != forWhom) && (player.getWorld() == forWhom.getWorld()) && (forWhom.canSee(player))) {
			forWhom.hidePlayer(player);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(BukkitMain.getPlugin(), new Runnable() {
				public void run() {
					forWhom.showPlayer(player);
				}
			}, 1L);
		}
	}

	public static final void hidePlayer(Player player, Set<Player> forWhom) {
		Preconditions.checkState(true, "Not Enabled!");
		Preconditions.checkNotNull(player, "player");
		Preconditions.checkNotNull(forWhom, "forWhom");
		for (Player playerFor : forWhom) {
			hidePlayer(player, playerFor);
		}
	}

	public static final void hidePlayer(Player player) {
		Preconditions.checkState(true, "Not Enabled!");
		Preconditions.checkNotNull(player, "player");
		for (Player playerFor : player.getWorld().getPlayers()) {
			hidePlayer(player, playerFor);
		}
	}

	public static final void setBattlePlayerNewName(final Player bp, final String newName) {
		bp.setDisplayName(newName);
		bp.setPlayerListName(newName);
		bp.setCustomName(newName);
	}

	public static final void resetBattlePlayerFakeName(final Player bp) {
		if (!hasFakeName.contains(bp)) {
			return;
		}
		final String trueName = realName.get(bp);
		hidePlayer(bp);
		changeBattlePlayerName(bp, trueName);
		setBattlePlayerNewName(bp, trueName);
		BattleNametagAPI.setNametag(bp, "§7", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		hidePlayer(bp);
		hasFakeName.remove(bp);
		realName.remove(bp);
		fakeName.remove(bp);
	}

	@SuppressWarnings("deprecation")
	public static final void setBattlePlayerFakeName(final Player bp, final String fakeBattlePlayerName) {
		if (AccountManager.hasAccount(fakeBattlePlayerName)) {
			bp.sendMessage("§1§lFAKE§f Algum jogador possui este nick registrado no §6§lSERVIDOR§f.");
			return;
		}
		for (final Player all : Bukkit.getOnlinePlayers()) {
			if (fakeBattlePlayerName.equalsIgnoreCase(all.getName()) || fakeBattlePlayerName.contains(all.getName())
					|| fakeBattlePlayerName.contains(all.getName())) {
				bp.sendMessage("§1§lFAKE§f Algum jogador ja esta §3§lUTILIZANDO§f este nick!");
				return;
			}
		}
		if (fakeBattlePlayerName.length() < 3) {
			bp.sendMessage("§1§lFAKE§f O nick fake nao pode ter §c§lMENOS§f de §9§l3 CARATERES§f!");
			return;
		}
		if (fakeBattlePlayerName.length() > 16) {
			bp.sendMessage("§1§lFAKE§f O nick fake nao pode ter §c§lMAIS§f de §9§l16 CARATERES§f!");
			return;
		}
		if (!BattlePlayerAPI.validate(fakeBattlePlayerName)) {
			bp.sendMessage("§1§lFAKE§f Este nick nao e §c§lvalido§f!");
			return;
		}
		if (hasFakeName.contains(bp)) {
			resetBattlePlayerFakeName(bp);
		}
		hasFakeName.add(bp);
		realName.put(bp, BattlePlayerAPI.getBattlePlayerName(bp));
		fakeName.put(bp, fakeBattlePlayerName);
		hidePlayer(bp);
		changeBattlePlayerName(bp, fakeBattlePlayerName);
		setBattlePlayerNewName(bp, fakeBattlePlayerName);
		BattleNametagAPI.setNametag(bp, "§7", " " + Leagues.getBattlePlayerLeagueInChat(bp));
		hidePlayer(bp);
		bp.sendMessage("§1§lFAKE§f Seu nick foi alterado com §a§lSUCESSO§f.");
		bp.sendMessage("§fUtilize §e§l'/fakeremove'§f para voltar ao normal");
	}
}
