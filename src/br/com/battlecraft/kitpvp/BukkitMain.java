package br.com.battlecraft.kitpvp;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.account.AccountFile;
import br.com.battlecraft.kitpvp.account.KillsAPI;
import br.com.battlecraft.kitpvp.account.KsAPI;
import br.com.battlecraft.kitpvp.account.XpAPI;
import br.com.battlecraft.kitpvp.api.ConfigAPI;
import br.com.battlecraft.kitpvp.api.KitAPI;
import br.com.battlecraft.kitpvp.api.TabAPI;
import br.com.battlecraft.kitpvp.api.WarpAPI;
import br.com.battlecraft.kitpvp.combat.CombatSystem;
import br.com.battlecraft.kitpvp.command.essentials.AccountCommand;
import br.com.battlecraft.kitpvp.command.essentials.AdminCommand;
import br.com.battlecraft.kitpvp.command.essentials.AplicarCommand;
import br.com.battlecraft.kitpvp.command.essentials.BroadcastCommand;
import br.com.battlecraft.kitpvp.command.essentials.BuildCommand;
import br.com.battlecraft.kitpvp.command.essentials.CcCommand;
import br.com.battlecraft.kitpvp.command.essentials.ChatCommand;
import br.com.battlecraft.kitpvp.command.essentials.ClearDropsCommand;
import br.com.battlecraft.kitpvp.command.essentials.ClearGrifCommand;
import br.com.battlecraft.kitpvp.command.essentials.DanoCommand;
import br.com.battlecraft.kitpvp.command.essentials.DeopCommand;
import br.com.battlecraft.kitpvp.command.essentials.DoubleXpCommand;
import br.com.battlecraft.kitpvp.command.essentials.EventoCommand;
import br.com.battlecraft.kitpvp.command.essentials.FakeCommand;
import br.com.battlecraft.kitpvp.command.essentials.FakeRemoveCommand;
import br.com.battlecraft.kitpvp.command.essentials.FlyCommand;
import br.com.battlecraft.kitpvp.command.essentials.GameModeCommand;
import br.com.battlecraft.kitpvp.command.essentials.HologramCommand;
import br.com.battlecraft.kitpvp.command.essentials.KickCommand;
import br.com.battlecraft.kitpvp.command.essentials.KitCommand;
import br.com.battlecraft.kitpvp.command.essentials.LobbyCommand;
import br.com.battlecraft.kitpvp.command.essentials.LojaCommand;
import br.com.battlecraft.kitpvp.command.essentials.MoneyCommand;
import br.com.battlecraft.kitpvp.command.essentials.OpCommand;
import br.com.battlecraft.kitpvp.command.essentials.PvPCommand;
import br.com.battlecraft.kitpvp.command.essentials.RankCommand;
import br.com.battlecraft.kitpvp.command.essentials.ReportCommand;
import br.com.battlecraft.kitpvp.command.essentials.ScoreboardCommand;
import br.com.battlecraft.kitpvp.command.essentials.ScreenshareCommand;
import br.com.battlecraft.kitpvp.command.essentials.SetGroupCommand;
import br.com.battlecraft.kitpvp.command.essentials.SetSpawnProtectionCommand;
import br.com.battlecraft.kitpvp.command.essentials.SetWarpCommand;
import br.com.battlecraft.kitpvp.command.essentials.SpawnCommand;
import br.com.battlecraft.kitpvp.command.essentials.StaffChatCommand;
import br.com.battlecraft.kitpvp.command.essentials.TagCommand;
import br.com.battlecraft.kitpvp.command.essentials.TagEspecialCommand;
import br.com.battlecraft.kitpvp.command.essentials.TeleportCommand;
import br.com.battlecraft.kitpvp.command.essentials.TellCommand;
import br.com.battlecraft.kitpvp.command.essentials.TpAllCommand;
import br.com.battlecraft.kitpvp.command.essentials.WarpCommand;
import br.com.battlecraft.kitpvp.command.essentials.WhitelistCommand;
import br.com.battlecraft.kitpvp.command.essentials.XpCommand;
import br.com.battlecraft.kitpvp.command.essentials.YoutuberCommand;
import br.com.battlecraft.kitpvp.command.essentials.cDoubleXpCommand;
import br.com.battlecraft.kitpvp.coords.LocationsFile;
import br.com.battlecraft.kitpvp.deathevents.PlayerDeathEvents;
import br.com.battlecraft.kitpvp.hologram.HologramEvent;
import br.com.battlecraft.kitpvp.kits.Ajnin;
import br.com.battlecraft.kitpvp.kits.Anchor;
import br.com.battlecraft.kitpvp.kits.Boxer;
import br.com.battlecraft.kitpvp.kits.Fireman;
import br.com.battlecraft.kitpvp.kits.Fisherman;
import br.com.battlecraft.kitpvp.kits.Gladiator;
import br.com.battlecraft.kitpvp.kits.Hulk;
import br.com.battlecraft.kitpvp.kits.Kangaroo;
import br.com.battlecraft.kitpvp.kits.Magma;
import br.com.battlecraft.kitpvp.kits.Minato;
import br.com.battlecraft.kitpvp.kits.Monk;
import br.com.battlecraft.kitpvp.kits.Ninja;
import br.com.battlecraft.kitpvp.kits.Stomper;
import br.com.battlecraft.kitpvp.kits.Switcher;
import br.com.battlecraft.kitpvp.kits.Thor;
import br.com.battlecraft.kitpvp.kits.Timelord;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.listener.BattlePlayerJoinServerEvents;
import br.com.battlecraft.kitpvp.listener.BattlePlayerQuitEvent;
import br.com.battlecraft.kitpvp.listener.BattlePlayersChatFormatEvent;
import br.com.battlecraft.kitpvp.listener.CompassSystemListener;
import br.com.battlecraft.kitpvp.listener.DamageConfiguration;
import br.com.battlecraft.kitpvp.listener.EntityDamageByEntity;
import br.com.battlecraft.kitpvp.listener.InteractFramesEvent;
import br.com.battlecraft.kitpvp.listener.MainListeners;
import br.com.battlecraft.kitpvp.listener.MotdManager;
import br.com.battlecraft.kitpvp.messages.AutomaticMessages;
import br.com.battlecraft.kitpvp.nametags.NametagAPI;
import br.com.battlecraft.kitpvp.reports.ReportsMenu;
import br.com.battlecraft.kitpvp.scoreboard.BukkitTasks;
import br.com.battlecraft.kitpvp.scoreboard.Score;
import br.com.battlecraft.kitpvp.topks.TopKillStreakAPI;
import br.com.battlecraft.kitpvp.warps.Capiroto.CapirotoItens;
import br.com.battlecraft.kitpvp.warps.Challenge.ChallengeWarpListener;
import br.com.battlecraft.kitpvp.warps.Fps.FpsWarpListener;
import br.com.battlecraft.kitpvp.warps.OneVsOne.Inventory1v1Custom;
import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;
import br.com.battlecraft.kitpvp.warps.Spawn.MenusWarpSpawn;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnKitsMenu;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnWarpListener;
import net.minecraft.server.v1_7_R4.EntityPlayer;

public class BukkitMain extends JavaPlugin {

	private static Plugin kitpvp;

	public static BukkitMain pvp;

	public static Plugin getPlugin() {
		return kitpvp;
	}

	public static final String commandMapFieldClass = "commandMap";

	public static final String receivedSpawnProtection = "§8§lPROTEÇAO§f Você §7§lRECEBEU§f sua proteção de spawn.";
	public static final String lostedSpawnProtection = "§8§lPROTEÇAO§f Você §7§lPERDEU§f sua proteção de spawn.";

	public static final String getReceivedSpawnProtectionMessage() {
		return receivedSpawnProtection;
	}

	public static final String getLostedSpawnProtectionMessage() {
		return lostedSpawnProtection;
	}

	public static final String BungeeChannel = "BungeeCord";

	public static String version;

	public final PluginManager battleplugin = Bukkit.getPluginManager();

	@SuppressWarnings("deprecation")
	public final void onEnable() {

		kitpvp = this;
		saveDefaultConfig();
		new ConfigAPI(kitpvp);
		KsAPI.createFile();
		KillsAPI.createFile();
		XpAPI.createFile();
		AccountFile.createAccountFile(kitpvp);
		LocationsFile.createLocationsFile(kitpvp);

		getServer().getMessenger().registerOutgoingPluginChannel(this, BungeeChannel);

		version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		registerEvents();
		registerCommands();
		MotdManager.updateMotd();
		BukkitTasks.updateAllAnimations();
		Score.updateAllScoreboards();
		Magma.updateMagmaOnWater();
		TopKillStreakAPI.updateTopKs();
		CapirotoItens.updatePotionEffects();

		ItemStack recraft = new ItemStack(Material.MUSHROOM_SOUP, 1);

		ShapelessRecipe cocoabean = new ShapelessRecipe(recraft);
		cocoabean.addIngredient(1, Material.getMaterial(351), (byte) 3);
		cocoabean.addIngredient(1, Material.BOWL);
		Bukkit.addRecipe(cocoabean);
		AutomaticMessages.runAutoMessages();
		onTab();

		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§6§lPVP §c§l2.0§f Foi HABILITADO!");
		Bukkit.getConsoleSender().sendMessage(" ");
	}

	public void onTab() {
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				BukkitTasks.run_Tab();
				for (Player p : Bukkit.getOnlinePlayers()) {
					final CraftPlayer cp = (CraftPlayer) p;
					final EntityPlayer ep = cp.getHandle();
					TabAPI.sendTabTitle(p,
							"§8§l>> §6§l" + BukkitTasks.TittleTab + " §8§l<< \n §eKills:§f "
									+ AccountAPI.getBattlePlayerKills(p) + " §1- §eDeaths:§f "
									+ AccountAPI.getBattlePlayerDeaths(p) + " §1- §eKillstreak:§f "
									+ AccountAPI.getBattlePlayerKillStreak(p) + " \n §eKit:§f " + KitAPI.getKit(p)
									+ " §1- §eWarp:§f " + WarpAPI.getWarp(p) + " §1- §ePing:§f " + ep.ping + " §1- §f"
									+ Bukkit.getOnlinePlayers().length + "/" + (Bukkit.getOnlinePlayers().length + 1)
									+ " §eplayers",
							"§bNick:§f " + p.getName() + " §1- §bLiga: " + Leagues.getBattlePlayerLeagueInScore(p)
									+ " §1- §bXP:§f " + AccountAPI.getBattlePlayerXp(p) + " §1- §bMoney:§f "
									+ AccountAPI.getBattlePlayerMoney(p)
									+ " \n §bMais informacoes em:§f battlebits.com.br");

				}
			}
		}.runTaskTimer(getPlugin(), 0, 9L);
	}

	@SuppressWarnings("deprecation")
	public final void onDisable() {
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.kickPlayer("§cO servidor esta reiniciando/desligando");
		}
	}

	public void registerEvents() {
		battleplugin.registerEvents(new NametagAPI(), this);
		battleplugin.registerEvents(new BattlePlayerJoinServerEvents(), this);
		battleplugin.registerEvents(new BattlePlayerQuitEvent(), this);
		battleplugin.registerEvents(new DamageConfiguration(), this);
		battleplugin.registerEvents(new BattlePlayersChatFormatEvent(), this);
		battleplugin.registerEvents(new ReportsMenu(), this);
		battleplugin.registerEvents(new MainListeners(), this);
		battleplugin.registerEvents(new MotdManager(), this);
		battleplugin.registerEvents(new EntityDamageByEntity(), this);
		battleplugin.registerEvents(new CompassSystemListener(), this);
		battleplugin.registerEvents(new HologramEvent(), this);
		battleplugin.registerEvents(new PlayerDeathEvents(), this);
		battleplugin.registerEvents(new CombatSystem(), this);
		battleplugin.registerEvents(new InteractFramesEvent(), this);
		registerKits();
		registerWarpEvents();
	}

	public void registerKits() {
		battleplugin.registerEvents(new Ajnin(), this);
		battleplugin.registerEvents(new Anchor(), this);
		battleplugin.registerEvents(new Ninja(), this);
		battleplugin.registerEvents(new Boxer(), this);
		battleplugin.registerEvents(new Fireman(), this);
		battleplugin.registerEvents(new Fisherman(), this);
		battleplugin.registerEvents(new Hulk(), this);
		battleplugin.registerEvents(new Kangaroo(), this);
		battleplugin.registerEvents(new Magma(), this);
		battleplugin.registerEvents(new Minato(), this);
		battleplugin.registerEvents(new Monk(), this);
		battleplugin.registerEvents(new Stomper(), this);
		battleplugin.registerEvents(new Gladiator(), this);
		battleplugin.registerEvents(new Switcher(), this);
		battleplugin.registerEvents(new Thor(), this);
		battleplugin.registerEvents(new Timelord(), this);
	}

	public void registerWarpEvents() {
		battleplugin.registerEvents(new SpawnKitsMenu(), this);
		battleplugin.registerEvents(new FpsWarpListener(), this);
		battleplugin.registerEvents(new MenusWarpSpawn(), this);
		battleplugin.registerEvents(new SpawnWarpListener(), this);
		battleplugin.registerEvents(new X1WarpListener(), this);
		battleplugin.registerEvents(new Inventory1v1Custom(), this);
		battleplugin.registerEvents(new ChallengeWarpListener(), this);
	}

	public void registerCommands() {
		try {
			final Field commandField = Bukkit.getServer().getClass().getDeclaredField(commandMapFieldClass);
			commandField.setAccessible(true);
			final CommandMap commandMap = (CommandMap) commandField.get(Bukkit.getServer());

			commandMap.register("pvp", new AdminCommand("admin", "Comando para controlar modo admin", "/admin",
					Arrays.asList("administrador")));

			commandMap.register("pvp", new WhitelistCommand("whitelist", "Comando para controlar a whitelist",
					"/whitelist", Arrays.asList("w")));

			commandMap.register("pvp", new RankCommand("rank", "Comando para ver ranks", "/rank",
					Arrays.asList("liga", "ligas", "ranks", "league", "lueagues")));

			commandMap.register("pvp",
					new TagCommand("tag", "Comando para selecionar nametags", "/tag", Arrays.asList("tags")));

			commandMap.register("pvp", new SetWarpCommand("setwarp", "Comando para setar warps", "/setwarp",
					Arrays.asList("set", "warpset")));

			commandMap.register("pvp",
					new FakeCommand("fake", "Comando para falsificar nick", "/fake", Arrays.asList("nick")));

			commandMap.register("pvp", new FakeRemoveCommand("fakeremove", "Comando para desfalsificar nick",
					"/fakeremove", Arrays.asList("nickremove")));

			commandMap.register("pvp",
					new OpCommand("op", "Comando para dar OP", "/op", Arrays.asList("darop", "giveop")));

			commandMap.register("pvp",
					new DeopCommand("deop", "Comando para tirar OP", "/deop", Arrays.asList("removeop")));

			commandMap.register("pvp",
					new WarpCommand("warp", "Comando para escolher warp", "/warp", Arrays.asList("warps", "warplist")));

			commandMap.register("pvp",
					new ReportCommand("report", "Comando para ver reports", "/report", Arrays.asList("reportar")));

			commandMap.register("pvp", new MoneyCommand("money", "Comando para dar/remover moedas", "/money",
					Arrays.asList("moedas", "addmoney", "removemoney", "givemoney", "givecoins", "removecoins")));

			commandMap.register("pvp", new HologramCommand("hologram", "Comando para spawnar Holograms", "/hologram",
					Arrays.asList("hl")));

			commandMap.register("pvp", new XpCommand("xp", "Comando para dar/remover xp", "/xp",
					Arrays.asList("addxp", "givexp", "removexp")));

			commandMap.register("pvp", new TeleportCommand("tp", "Comando para se teleportar", "/tp",
					Arrays.asList("teleporte", "teleportar", "teleport")));

			commandMap.register("pvp", new BroadcastCommand("broadcast", "Comando para dar avisos globais",
					"/broadcast", Arrays.asList("bc", "aviso", "anuncio", "anunciar")));

			commandMap.register("pvp",
					new TellCommand("tell", "Comando para mandar mensagens", "/tell", Arrays.asList("msg", "w")));

			commandMap.register("pvp", new KickCommand("kick", "Comando para kickar jogadores", "/kick",
					Arrays.asList("kickar", "expulsar")));

			commandMap.register("pvp", new BuildCommand("build", "Comando para ativar/desativar modo build", "/build",
					Arrays.asList("builder")));

			commandMap.register("pvp",
					new ChatCommand("chat", "Comando para controlar chat", "/chat", Arrays.asList("chatmode")));

			commandMap.register("pvp",
					new CcCommand("cc", "Comando para limpar chat", "/cc", Arrays.asList("chatclear")));

			commandMap.register("pvp",
					new GameModeCommand("gamemode", "Comando para mudar gamemode", "/gamemode", Arrays.asList("gm")));

			commandMap.register("pvp",
					new SpawnCommand("spawn", "Comando para retornar ao spawn", "/spawn", Arrays.asList("warpspawn")));

			commandMap.register("pvp",
					new ScreenshareCommand("ss", "Comando para puxar para SS", "/ss", Arrays.asList("screenshare")));

			commandMap.register("pvp", new ClearDropsCommand("cleardrops", "Comando para limpar drops", "/cleardrops",
					Arrays.asList("limpardrops")));

			commandMap.register("pvp",
					new TagEspecialCommand("tagespecial", "Comando para selecionar nametags especiais", "/tagespecial",
							Arrays.asList("especial", "especialtag")));

			commandMap.register("pvp", new FlyCommand("fly", "Comando para ativar/desativar modo voo", "/fly",
					Arrays.asList("voar", "voo", "flymode")));

			commandMap.register("pvp", new ScoreboardCommand("scoreboard", "Comando para ativar/desativar scoreboard",
					"/scoreboard", Arrays.asList("score")));

			commandMap.register("pvp", new ClearGrifCommand("cleargrif", "Comando para limpar agua/lava", "/cleargrif",
					Arrays.asList("grifclear", "limpargrif", "tirarlava", "tiraragua")));

			commandMap.register("pvp",
					new DoubleXpCommand("doublexp", "Comando para usar doublexp", "/doublexp", Arrays.asList("dxp")));

			commandMap.register("pvp", new cDoubleXpCommand("cdoublexp", "Comando para dar/remover doublexp",
					"/cdoublexp", Arrays.asList("givedoublexp", "doublexpadd", "doublexpremove")));

			commandMap.register("pvp", new AccountCommand("account", "Comando para ver infos de uma conta", "/account",
					Arrays.asList("conta", "status", "stats", "perfil", "info")));

			commandMap.register("pvp",
					new KitCommand("kit", "Comando para selecionar kits", "/kit", Arrays.asList("kits")));

			commandMap.register("pvp", new AplicarCommand("aplicar", "Comando para se aplicar a staff", "/aplicar",
					Arrays.asList("staff")));

			commandMap.register("pvp", new YoutuberCommand("youtuber", "Comando para ver req de youtuber", "/youtuber",
					Arrays.asList("yt")));

			commandMap.register("pvp", new LojaCommand("loja", "Comando para ver a Loja", "/loja",
					Arrays.asList("vip", "comprar", "site")));

			commandMap.register("pvp",
					new EventoCommand("evento", "Comando para controlar evento", "/evento", Arrays.asList("event")));

			commandMap.register("pvp", new StaffChatCommand("sc", "Comando para entrar/sair do staff chat", "/sc",
					Arrays.asList("staffchat", "s")));

			commandMap.register("pvp",
					new SetSpawnProtectionCommand("setspawnprtection",
							"Comando para setar distancia da proteçao de spawn", "/setspawnprotection",
							Arrays.asList("protection", "setspawnprotectiondistance", "spawnprotection")));

			commandMap.register("pvp", new LobbyCommand("lobby", "Comando para conectar ao Lobby", "/lobby",
					Arrays.asList("hub", "sair")));

			commandMap.register("pvp",
					new PvPCommand("pvp", "Comando para ativar/desativar pvp", "/pvp", Arrays.asList("setpvp")));

			commandMap.register("pvp",
					new DanoCommand("dano", "Comando para ativar/desativar dano", "/dano", Arrays.asList("damage")));

			commandMap.register("pvp", new SetGroupCommand("setgroup", "Comando para setar grupos", "/setgroup",
					Arrays.asList("groupset", "givevip", "removevip")));

			commandMap.register("pvp", new TpAllCommand("tpall", "Comando para teleportar todos jogadores", "/tpall",
					Arrays.asList("puxartodos")));

		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static final boolean NotInGame(final CommandSender sender) {
		if (sender instanceof Player) {
			return true;
		} else {
			return false;
		}
	}
}