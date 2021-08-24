package br.com.battlecraft.kitpvp.warps.Spawn;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.account.AccountConstructor;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.listener.BattlePlayerJoinServerEvents;
import br.com.battlecraft.kitpvp.mac.ComputerIP;
import br.com.battlecraft.kitpvp.nametags.BattleNametagAPI;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;

public final class MenusWarpSpawn implements Listener {

	public static final ArrayList<String> getPlayerTags(final Player bp) {
		final ArrayList<String> lista = new ArrayList<String>();
		lista.add("");
		if (bp.hasPermission("pvp.tag.dono")) {
			lista.add("§4§lDONO");
		}
		if (bp.hasPermission("pvp.tag.diretor")) {
			lista.add("§4§lDIRETOR");
		}
		if (bp.hasPermission("pvp.tag.gerente")) {
			lista.add("§c§lGERENTE");
		}
		if (bp.hasPermission("pvp.tag.admin")) {
			lista.add("§c§lADMIN");
		}
		if (bp.hasPermission("pvp.tag.modplus")) {
			lista.add("§5§lMOD+");
		}
		if (bp.hasPermission("pvp.tag.modgc")) {
			lista.add("§5§lMODGC");
		}
		if (bp.hasPermission("pvp.tag.mod")) {
			lista.add("§5§lMOD");
		}
		if (bp.hasPermission("pvp.tag.trial")) {
			lista.add("§d§lTRIAL");
		}
		if (bp.hasPermission("pvp.tag.builder")) {
			lista.add("§e§lBUILDER");
		}
		if (bp.hasPermission("pvp.tag.ajudante")) {
			lista.add("§9§lAJUDANTE");
		}
		if (bp.hasPermission("pvp.tag.ytplus")) {
			lista.add("§3§lYT+");
		}
		if (bp.hasPermission("pvp.tag.yt")) {
			lista.add("§b§lYT");
		}
		if (bp.hasPermission("pvp.tag.miniyt")) {
			lista.add("§c§lMINIYT");
		}
		if (bp.hasPermission("pvp.tag.ultimate")) {
			lista.add("§d§lULTIMATE");
		}
		if (bp.hasPermission("pvp.tag.beta")) {
			lista.add("§1§lBETA");
		}
		if (bp.hasPermission("pvp.tag.premium")) {
			lista.add("§6§lPREMIUM");
		}
		if (bp.hasPermission("pvp.tag.light")) {
			lista.add("§a§lLIGHT");
		}
		if (bp.hasPermission("pvp.tag.designer")) {
			lista.add("§2§lDESIGNER");
		}
		lista.add("§7§lNORMAL");
		lista.add("");
		return lista;
	}

	public static final void openWarpsMenuToBattlePlayer(final Player bp) {
		Inventory menu = Bukkit.createInventory(bp, 9, "§b§lWarps");
		Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitMain.getPlugin(), () -> {
			menu.setItem(0,
					SpawnItens.newItem(Material.BLAZE_ROD, "§b§l1v1", new String[] { "§7Entre em uma luta justa",
							"§7com alguem", "", "§3§l" + WarpsAPI.inOnevsOne.size() + " §7jogando agora", "" }));
			menu.setItem(1,
					SpawnItens.newItem(Material.GLASS, "§b§lFPS",
							new String[] { "§7Utilize esta WARP feita", "§7com um mapa mais leve",
									"§7para aumentar seus FPSs", "",
									"§3§l" + WarpsAPI.inFps.size() + " §7jogando agora", "" }));
			menu.setItem(2,
					SpawnItens.newItem(Material.LAVA_BUCKET, "§b§lLava Challenge",
							new String[] { "§7Treine seus refils e seus", "§7recrafts nesta warp otimizada",
									"§7para ser o melhor no pvp", "",
									"§3§l" + WarpsAPI.inLavaChallenge.size() + " §7jogando agora", "" }));
			menu.setItem(3,
					SpawnItens.newItem(Material.GOLDEN_APPLE, "§b§lCapiroto",
							new String[] { "§7Arena para pvp sem sopa", "§7armaduras p4, espada e arco op!",
									"§7Quanto mais jogadores voce matar", "§7mais maça do capiroto ira ganhar", "",
									"§3§l" + WarpsAPI.inCapiroto.size() + " §7jogando agora", "" },
							1, (byte) 1));
			menu.setItem(4,
					SpawnItens
							.newItem(Material.COOKIE, "§b§lEvento",
									new String[] { "§7Warp feita para realização de", "§7eventos feitos por staffers",
											"", "§3§l" + WarpsAPI.inEvento.size() + " §7jogando agora", "" },
									1, (byte) 1));
		}, 0, 20);
		bp.openInventory(menu);
	}

	public static final ItemStack newItem(Material mat, String name, String[] desc, byte id) {
		final ItemStack i = new ItemStack(mat, 1, (byte) id);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName(name);
		ik.setLore(Arrays.asList(desc));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack newItem(Material mat, String name, String[] desc, int qnt, byte id) {
		final ItemStack i = new ItemStack(mat, qnt, (byte) id);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName(name);
		ik.setLore(Arrays.asList(desc));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack add() {
		final ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§f§o-");
		i.setItemMeta(ik);
		return i;
	}

	public static final int getBattlePlayerKDR(final Player bp) {
		final int kills = AccountAPI.getBattlePlayerKills(bp);
		final int deaths = AccountAPI.getBattlePlayerDeaths(bp);
		final int killmoredeaths = kills - deaths;
		return (killmoredeaths * 100) / kills;
	}

	public static final ArrayList<Player> opening = new ArrayList<Player>();

	@SuppressWarnings("deprecation")
	public static final void openAccountMenuToBattlePlayer(final Player bp) throws Exception {
		if (opening.contains(bp)) {
			return;
		}
		opening.add(bp);
		bp.sendMessage("§e§lCONTA§f Abrindo menu..");
		Inventory menu = Bukkit.createInventory(bp, 54, "§8Conta - " + bp.getName());
		for (int i = 0; i < 54; i++) {
			menu.setItem(i, add());
		}
		menu.setItem(8, newItem(Material.NETHER_STAR, "§9§lInformaçoes de sua Conta", new String[] { "",
				"§7Olá, este §e§lmenu§7 foi feito para voce", "§7ver com facilidade §e§linformaçoes de sua conta§7",
				"§7Onde poderá saber a quantidade suas §e§lmoedas§7,",
				"§e§lxps§7, sua §e§lliga§7, seu §e§lgrupo no servidor§7,", "§e§lsuas tags§7, §e§lhorario do pais§7,",
				"§7sua §e§llocalizaçao real no mundo§7 e mais!", "", "§7Atenciosamente!" }, (byte) 0));
		menu.setItem(13, SpawnItens.newItem(Material.SKULL_ITEM, "§9§l" + bp.getName(), new String[] { "",
				"§7Rank: " + BattleNametagAPI.getPlayerGroup(bp), "§7Liga: " + Leagues.getBattlePlayerLeagueInScore(bp),
				"§7XP: §b" + AccountAPI.getBattlePlayerXp(bp), "§7Moedas: §b" + AccountAPI.getBattlePlayerMoney(bp),
				"§7DoubleXp: §b" + AccountAPI.getBattlePlayerDoubleXp(bp), "" }, 1, (byte) 3));
		menu.setItem(17,
				newItem(Material.BOOKSHELF, "§9§lDados",
						new String[] { "", "§fUUID: §e§l" + bp.getUniqueId().toString(), "§fNICK: §e§l" + bp.getName(),
								"§fPRIMEIRO LOGIN: §e§l" + AccountAPI.getBattlePlayerFirstLogin(bp),
								"§fULTIMO LOGIN: §e§l" + AccountAPI.getBattlePlayerLastLogin(bp), "" },
						(byte) 0));
		menu.setItem(19,
				newItem(Material.BLAZE_POWDER, "§e§lStatus",
						new String[] { "", "§7Kills: §b" + AccountAPI.getBattlePlayerKills(bp),
								"§7Deaths: §b" + AccountAPI.getBattlePlayerDeaths(bp),
								"§7KillStreak: §b" + AccountAPI.getBattlePlayerKillStreak(bp), "" },
						(byte) 0));
		menu.setItem(21, newItem(Material.GOLD_INGOT, "§6§lLojas",
				new String[] { "§7Clique para abrir o menu de lojas" }, (byte) 0));
		menu.setItem(22,
				newItem(Material.PAPER, "§6§lLIGA",
						new String[] { "", "§7XP para próxima liga: §b" + Leagues.getBattlePlayerLeagueXpLeft(bp),
								"§7Próxima liga: " + Leagues.getBattlePlayerNextLeague(bp),
								"§7Liga atual: " + Leagues.getBattlePlayerLeagueInScore(bp), "",
								"§7Clique para mais detalhes", "" },
						(byte) 0));
		menu.setItem(23, newItem(Material.EXP_BOTTLE, "§3§lDoubleXp",
				new String[] { "§7Clique para ativar um doublexp" }, (byte) 0));
		menu.setItem(25, newItem(Material.getMaterial(347), "§b§lHorario",
				new String[] { "", "§fHorario de Brasília", "§b§l" + AccountConstructor.BrasilTime(), "" }, (byte) 0));
		menu.setItem(31, newItem(Material.NAME_TAG, "§3§lTAGS§f Lista de suas §9§lTAGS",
				getPlayerTags(bp).toArray(new String[] {}), (byte) 0));
		menu.setItem(46,
				newItem(Material.COMPASS, "§9§lConexao",
						new String[] { "", "§f§m----------------§f",
								"§7Endereço de IP: §8" + bp.getAddress().getHostString(), "§f§m----------------§f",
								"§7Endereço de IP (Computador/MAC): §8" + ComputerIP
										.getComputerIP(BattlePlayerJoinServerEvents.macAddress.get(bp.getName())),
								"" },
						(byte) 0));
		menu.setItem(47, newItem(Material.getMaterial(356), "§c§lPreferencias",
				new String[] { "§7Clique aqui para editar suas", "§7preferencias no servidor!" }, (byte) 0));
		menu.setItem(49,
				newItem(Material.EYE_OF_ENDER, "§a§lJogadores Online",
						new String[] { "", "§e" + Bukkit.getOnlinePlayers().length + " jogadores", "" },
						Bukkit.getOnlinePlayers().length, (byte) 0));
		menu.setItem(51, newItem(Material.REDSTONE, "§c§lFechar Menu",
				new String[] { "§7Clique aqui para fechar este menu" }, (byte) 0));
		menu.setItem(52,
				newItem(Material.BOOK_AND_QUILL, "§3§lReports",
						new String[] { "", "§7Caso você seja um staffer", "§7clique aqui para ver seus reports", "" },
						(byte) 0));
		bp.openInventory(menu);
		opening.remove(bp);
	}

	// menu loja principal
	public static final void openLojasMenu(final Player bp) {
		final Inventory menu = Bukkit.createInventory(bp, 36, "§b§lLojas");

		for (int i = 0; i < 36; i++) {
			menu.setItem(i, add());
		}

		menu.setItem(10,
				newItem(Material.DIAMOND, "§6§lLoja Online",
						new String[] { "", "§7Clique aqui para compras na §e§lloja",
								"§7que possui §e§lbeneficios exclusivos§7",
								"§7adiquiriveis, somente na §e§lloja online oficial§7 do servidor!", "" },
						(byte) 0));
		menu.setItem(12,
				newItem(Material.IRON_INGOT, "§a§lLoja de Kits",
						new String[] { "", "§7Clique aqui para comprar §e§lkits§7 in-game§7",
								"§7com suas moedas adiquiridas no servidor!", "" },
						(byte) 0));
		menu.setItem(14,
				newItem(Material.EXP_BOTTLE, "§3§lLoja de DoubleXps",
						new String[] { "", "§7Clique aqui para comprar §e§ldoublexps§7 in-game§7",
								"§7com suas moedas adiquiridas no servidor!", "" },
						(byte) 0));
		menu.setItem(16,
				newItem(Material.NAME_TAG, "§b§lLoja de Tags Especiais",
						new String[] { "", "§7Clique aqui para comprar §e§ltags especiais§7 in-game§7",
								"§7com suas moedas adiquiridas no servidor!", "" },
						(byte) 0));
		menu.setItem(31,
				newItem(Material.ARROW, "§5§lPerfil", new String[] { "§7Clique para ver o seu perfil" }, (byte) 0));
		bp.openInventory(menu);
	}

	public static final int doublexp = 10000;
	public static final int gamer = 20000;
	public static final int numb = 15000;

	// loja double tags especiais
	public static final void openLojaEspecialTagsMenu(final Player bp) {
		final Inventory menu = Bukkit.createInventory(bp, 9, "§b§lLoja de Tags Especiais");

		for (int i = 0; i < 9; i++) {
			menu.setItem(i, add());
		}

		menu.setItem(0, newItem(Material.DIAMOND, "§5§lVoltar",
				new String[] { "§7Clique para voltar a pagina anterior!" }, (byte) 0));

		menu.setItem(3,
				newItem(Material.EMERALD, "§3§lTAG §f- §a§lGAMER",
						new String[] { "", "§4§lPREÇO", "§6§l" + gamer + " MOEDAS", "", "§fClique para Comprar", "" },
						(byte) 0));
		menu.setItem(5,
				newItem(Material.IRON_INGOT, "§3§lTAG §f- §7§lNUMB",
						new String[] { "", "§4§lPREÇO", "§6§l" + numb + " MOEDAS", "", "§fClique para Comprar", "" },
						(byte) 0));

		bp.openInventory(menu);
	}

	// loja double xp
	public static final void openLojaDoubleXpMenu(final Player bp) {
		final Inventory menu = Bukkit.createInventory(bp, 9, "§b§lLoja de DoubleXp");

		for (int i = 0; i < 9; i++) {
			menu.setItem(i, add());
		}

		menu.setItem(4,
				newItem(Material.EXP_BOTTLE, "§3§l1 DoubleXp",
						new String[] { "", "§4§lPREÇO", "§6§l" + doublexp + " MOEDAS", "§fClique para Comprar", "" },
						(byte) 0));
		menu.setItem(0, newItem(Material.DIAMOND, "§5§lVoltar",
				new String[] { "§7Clique para voltar a pagina anterior!" }, (byte) 0));

		bp.openInventory(menu);
	}

	public static final int anchor = 5000;
	public static final int ninja = 6000;
	public static final int ajnin = 6500;
	public static final int gladiator = 10000;
	public static final int minato = 15000;
	public static final int magma = 7500;
	public static final int fireman = 4000;
	public static final int antistomper = 6700;
	public static final int stomper = 13500;
	public static final int fisherman = 3500;
	public static final int boxer = 9500;
	public static final int switcher = 3500;
	public static final int thor = 7500;
	public static final int timelord = 5000;
	public static final int viking = 10000;

	public static final void menuLojaKits(final Player bp) {
		final Inventory menu = Bukkit.createInventory(bp, 45, "§b§lLoja de Kits");

		for (int i = 0; i < 45; i++) {
			menu.setItem(i, add());
		}

		menu.setItem(10,
				newItem(Material.ANVIL, "§b§lAnchor",
						new String[] { "", "§a§lHABILIDADE", "§7Nao de nem leve knockback no seu oponente",
								"§7impossibilitando que ele fuja!", "", "§4§lPREÇO", "§6§l" + anchor + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(11,
				newItem(Material.EMERALD, "§b§lNinja",
						new String[] { "", "§a§lHABILIDADE", "§7Ao hitar alguem, agache (shift)",
								"§7e voce sera teleportado para ele!", "", "§4§lPREÇO", "§6§l" + ninja + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(12,
				newItem(Material.NETHER_STAR, "§b§lAjnin",
						new String[] { "", "§a§lHABILIDADE", "§7Ao hitar alguem, agache (shift)",
								"§7e ele sera teleportado para voce!", "", "§4§lPREÇO", "§6§l" + ajnin + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(13,
				newItem(Material.IRON_FENCE, "§b§lGladiator",
						new String[] { "", "§a§lHABILIDADE", "§7Puxe um jogador para uma arena onde",
								"§7voces irao batalhar um 1v1!", "", "§4§lPREÇO", "§6§l" + gladiator + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(14,
				newItem(Material.ARROW, "§b§lMinato",
						new String[] { "", "§a§lHABILIDADE", "§7Atire sua kunai com selo para algum lugar",
								"§7e teleporte rapidamente para onde ela encostar", "", "§4§lPREÇO",
								"§6§l" + minato + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(15,
				newItem(Material.LAVA_BUCKET, "§b§lMagma",
						new String[] { "", "§a§lHABILIDADE", "§7Ao hitar alguem, tem 30% de chance de",
								"§7ele pegar fogo! Seja imune a lava ou fogo, porem",
								"§7ao ficar na agua, leve 3 coraçoes de dano p/ segundo", "", "§4§lPREÇO",
								"§6§l" + magma + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(16,
				newItem(Material.FIRE, "§b§lFireman",
						new String[] { "", "§a§lHABILIDADE", "§7Nao leve dano para nenhum elemento como",
								"§7lava e/ou fogo!", "", "§4§lPREÇO", "§6§l" + fireman + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(19,
				newItem(Material.DIAMOND_HELMET, "§b§lAntiStomper",
						new String[] { "", "§a§lHABILIDADE", "§7Lava dano reduzido para stompers",
								"§7como se estivesse sempre agachado (shift)!", "", "§4§lPREÇO",
								"§6§l" + antistomper + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(20,
				newItem(Material.DIAMOND_BOOTS, "§b§lStomper",
						new String[] { "", "§a§lHABILIDADE", "§7Pule de um lugar alto e esmague",
								"§7todos jogadores abaixo de voce e", "§7pegue a kill de todos eles!", "", "§4§lPREÇO",
								"§6§l" + stomper + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(21,
				newItem(Material.FISHING_ROD, "§b§lFisherman",
						new String[] { "", "§a§lHABILIDADE", "§7Fisgue um jogador com sua vara",
								"§7puxe e traga ele ate voce!", "", "§4§lPREÇO", "§6§l" + fisherman + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(22,
				newItem(Material.IRON_SWORD, "§b§lBoxer",
						new String[] { "", "§a§lHABILIDADE", "§7De 0.5 coraçoes a mais de dano e",
								"§7receba 0.5 coraçoes a menos!", "", "§4§lPREÇO", "§6§l" + boxer + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(23,
				newItem(Material.SNOW_BALL, "§b§lSwitcher",
						new String[] { "", "§a§lHABILIDADE", "§7Jogue sua bolinha de neve em alguem",
								"§7e troque de lugar com ela!", "", "§4§lPREÇO", "§6§l" + switcher + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(24,
				newItem(Material.GOLD_AXE, "§b§lThor",
						new String[] { "", "§a§lHABILIDADE", "§7Clique com botao direito cm seu machado",
								"§7para um lugar, e faça cair um relampago!", "", "§4§lPREÇO",
								"§6§l" + thor + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(25,
				newItem(Material.GOLD_AXE, "§b§lThor",
						new String[] { "", "§a§lHABILIDADE", "§7Clique com botao direito cm seu machado",
								"§7para um lugar, e faça cair um relampago!", "", "§4§lPREÇO",
								"§6§l" + thor + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(28,
				newItem(Material.WATCH, "§b§lTimelord",
						new String[] { "", "§a§lHABILIDADE", "§7Congele todos os players a 7",
								"§7blocos de distancia de voce!", "", "§4§lPREÇO", "§6§l" + timelord + " MOEDAS", "",
								"§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(29,
				newItem(Material.DIAMOND_AXE, "§b§lViking",
						new String[] { "", "§a§lHABILIDADE", "§7De mais dano com seu machado de diamante",
								"§7mais afiado que uma espada de diamante!", "", "§4§lPREÇO",
								"§6§l" + viking + " MOEDAS", "", "§fClique para comprar!", "" },
						(byte) 0));
		menu.setItem(40, newItem(Material.DIAMOND, "§5§lVoltar",
				new String[] { "§7Clique para voltar a pagina anterior" }, (byte) 0));
		bp.openInventory(menu);
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR)
	public final void onInventoryClicks(final InventoryClickEvent e) throws Exception {
		if (e.getWhoClicked() instanceof Player) {
			final Player bp = (Player) e.getWhoClicked();
			if (e.getInventory().getName().equalsIgnoreCase("§8Conta - " + bp.getName())
					&& e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
					e.setCancelled(true);
					openLojasMenu(bp);
				} else if (e.getCurrentItem().getType() == Material.PAPER) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/rank");
				} else if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/account");
				} else if (e.getCurrentItem().getType() == Material.EXP_BOTTLE) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/doublexp ativar");
				} else if (e.getCurrentItem().getType() == Material.NAME_TAG) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/tag");
				} else if (e.getCurrentItem().getType() == Material.getMaterial(356)) {
					e.setCancelled(true);
					openPreferencesMenu(bp);
				} else if (e.getCurrentItem().getType() == Material.REDSTONE) {
					e.setCancelled(true);
					bp.closeInventory();
				} else if (e.getCurrentItem().getType() == Material.BOOK_AND_QUILL) {
					if (!bp.hasPermission("pvp.cmd.report")) {
						e.setCancelled(true);
						bp.closeInventory();
						bp.sendMessage("§c§lPERMISSAO§f Você não tem §c§lPERMISSAO§f para esta opçao!");
					} else {
						e.setCancelled(true);
						bp.closeInventory();
						bp.chat("/report list");
					}
				} else {
					e.setCancelled(true);
				}
			} else if (e.getInventory().getName().equalsIgnoreCase("§b§lWarps") && e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/warp 1v1");
				} else if (e.getCurrentItem().getType() == Material.GLASS) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/warp fps");
				} else if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/warp lavachallenge");
				} else if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/warp capiroto");
				} else if (e.getCurrentItem().getType() == Material.COOKIE) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/warp evento");
				}
			} else if (e.getInventory().getName().equalsIgnoreCase("§b§lLojas") && e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType() == Material.ARROW) {
					e.setCancelled(true);
					openAccountMenuToBattlePlayer(bp);
				} else if (e.getCurrentItem().getType() == Material.DIAMOND) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/loja");
				} else if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
					e.setCancelled(true);
					menuLojaKits(bp);
				} else if (e.getCurrentItem().getType() == Material.EXP_BOTTLE) {
					e.setCancelled(true);
					openLojaDoubleXpMenu(bp);
				} else if (e.getCurrentItem().getType() == Material.NAME_TAG) {
					e.setCancelled(true);
					openLojaEspecialTagsMenu(bp);
				} else {
					e.setCancelled(true);
				}
			} else if (e.getInventory().getName().equalsIgnoreCase("§b§lLoja de Kits") && e.getCurrentItem() != null) {
				final int money = AccountAPI.getBattlePlayerMoney(bp);
				if (e.getCurrentItem().getType() == Material.DIAMOND) {
					e.setCancelled(true);
					openLojasMenu(bp);
				} else if (e.getCurrentItem().getType() == Material.ANVIL) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.anchor")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < anchor) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (anchor - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.anchor");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, anchor);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lAnchor§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.EMERALD) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.ninja")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < ninja) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (ninja - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.ninja");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, ninja);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lNinja§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.ajnin")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < ajnin) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (ajnin - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.ajnin");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, ajnin);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lAjnin§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.gladiator")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < gladiator) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (gladiator - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.gladiator");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, gladiator);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lGladiator§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.ARROW) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.minato")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < minato) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (minato - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.minato");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, minato);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lMinato§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.magma")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < magma) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (magma - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.magma");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, magma);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lMagma§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.FIRE) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.fireman")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < fireman) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (fireman - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.fireman");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, fireman);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lFireman§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.DIAMOND_HELMET) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.antistomper")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < antistomper) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (antistomper - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.antistomper");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, antistomper);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lAntiStomper§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.stomper")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < stomper) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (stomper - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.stomper");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, stomper);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lStomper§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.fisherman")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < fisherman) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (fisherman - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.fisherman");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, fisherman);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lFisherman§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.switcher")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < switcher) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (switcher - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.switcher");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, switcher);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lSwitcher§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.thor")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < thor) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (thor - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.thor");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, thor);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lThor§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.WATCH) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.timelord")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < timelord) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (timelord - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.timelord");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, timelord);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lTimelord§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.DIAMOND_AXE) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.viking")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < viking) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (viking - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.viking");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, viking);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lViking§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
					e.setCancelled(true);
					if (bp.hasPermission("pvp.kit.boxer")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem este kit!");
					} else if (money < boxer) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (boxer - money)
								+ " MOEDAS§f para comprar este kit!");
					} else {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.kit.boxer");
						bp.closeInventory();
						AccountAPI.removeBattlePlayerMoney(bp, boxer);
						bp.sendMessage("§3§lKIT§f Voce comprou o kit §b§lBoxer§f!");
					}
				} else {
					e.setCancelled(true);
				}
			} else if (e.getInventory().getName().equalsIgnoreCase("§b§lLoja de DoubleXp")
					&& e.getCurrentItem() != null) {
				final int money = AccountAPI.getBattlePlayerMoney(bp);
				if (e.getCurrentItem().getType() == Material.EXP_BOTTLE) {
					e.setCancelled(true);
					if (money < doublexp) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (doublexp - money)
								+ " MOEDAS§f para comprar isto!");
					} else {
						AccountAPI.addBattlePlayerDoubleXp(bp, 1);
						AccountAPI.removeBattlePlayerMoney(bp, doublexp);
						bp.closeInventory();
						bp.sendMessage("§3§lDOUBLEXP§f Voce comprou §3§l1 doublexp§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.DIAMOND) {
					e.setCancelled(true);
					openLojasMenu(bp);
				} else {
					e.setCancelled(true);
				}
			} else if (e.getInventory().getName().equalsIgnoreCase("§b§lLoja de Tags Especiais")
					&& e.getCurrentItem() != null) {
				final int money = AccountAPI.getBattlePlayerMoney(bp);
				if (e.getCurrentItem().getType() == Material.EMERALD) {
					e.setCancelled(true);
					if (money < gamer) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (gamer - money)
								+ " MOEDAS§f para comprar isto!");
					} else if (bp.hasPermission("pvp.tagespecial.gamer")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem esta tag especial!");
					} else {
						AccountAPI.removeBattlePlayerMoney(bp, gamer);
						bp.closeInventory();
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.tagespecial.gamer");
						bp.sendMessage("§3§lTAGS ESPECIAIS§f Voce comprou a §9§lTAG §a§lGAMER§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
					e.setCancelled(true);
					if (money < numb) {
						bp.closeInventory();
						bp.sendMessage("§6§lMOEDAS§f Voce precisa de mais §6§l" + (numb - money)
								+ " MOEDAS§f para comprar isto!");
					} else if (bp.hasPermission("pvp.tagespecial.numb")) {
						bp.closeInventory();
						bp.sendMessage("§cVoce ja tem esta tag especial!");
					} else {
						AccountAPI.removeBattlePlayerMoney(bp, numb);
						bp.closeInventory();
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + bp.getName() + " add " + "pvp.tagespecial.numb");
						bp.sendMessage("§3§lTAGS ESPECIAIS§f Voce comprou a §9§lTAG §7§lNUMB§f!");
					}
				} else if (e.getCurrentItem().getType() == Material.DIAMOND) {
					e.setCancelled(true);
					openLojasMenu(bp);
				} else {
					e.setCancelled(true);
				}
			}
		}
	}

	// PREFERENCES MENU //

	public static final ArrayList<String> cocoabean = new ArrayList<>();

	public static final void openPreferencesMenu(final Player bp) {
		final Inventory menu = Bukkit.createInventory(bp, 36, "§c§lPreferencias");

		menu.setItem(10, newItem(Material.COCOA, "§6§lCustomizar recraft",
				new String[] { "", "§7Clique para mudar seu tipo de §6§lrecraft§7!", "",
						(cocoabean.contains(bp.getName()) ? "§7COGUMELO §a§lCOCOABEAN" : "§a§lCOGUMELO §7COCOABEAN"),
						"" },
				(byte) 0));
		menu.setItem(19, newItem(Material.STAINED_GLASS_PANE, "§a§lPreferencias", new String[] { null }, (byte) 5));
		menu.setItem(12, newItem(Material.FEATHER, "§e§lModo voar",
				new String[] { "", "§7Para §a§lativar§7 é necessario que", "§7voce seja §a§lLIGHT§7 ou superior!", "" },
				(byte) 0));
		menu.setItem(21, newItem(Material.STAINED_GLASS_PANE, "§e§lPreferencias", new String[] { null }, (byte) 4));
		menu.setItem(14, newItem(Material.PAINTING, "§b§lScoreboard",
				new String[] { "", "§7Clique para §a§lativar§7 ou", "§c§ldesativar§7 sua Scoreboard!", "" }, (byte) 0));
		menu.setItem(23, newItem(Material.STAINED_GLASS_PANE, "§a§lPreferencias", new String[] { null }, (byte) 5));
		menu.setItem(16, newItem(Material.PAPER, "§3§lTags especiais",
				new String[] { "", "§7Clique aqui para Selecionar", "§7uma §3§ltag especial§7!", "" }, (byte) 0));
		menu.setItem(25, newItem(Material.STAINED_GLASS_PANE, "§e§lPreferencias", new String[] { null }, (byte) 4));
		menu.setItem(31, newItem(Material.ARROW, "§5§lPerfil",
				new String[] { "§7Clique para voltar ao", "§7seu perfil." }, (byte) 0));
		bp.openInventory(menu);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public final void onInventoryPreferencesClicks(final InventoryClickEvent e) throws Exception {
		if (e.getWhoClicked() instanceof Player) {
			final Player bp = (Player) e.getWhoClicked();
			if (e.getInventory().getName().equalsIgnoreCase("§c§lPreferencias") && e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType() == Material.COCOA) {
					e.setCancelled(true);
					if (cocoabean.contains(bp.getName())) {
						cocoabean.remove(bp.getName());
					} else {
						cocoabean.add(bp.getName());
					}
					openPreferencesMenu(bp);
				} else if (e.getCurrentItem().getType() == Material.FEATHER) {
					e.setCancelled(true);
					bp.chat("/fly");
				} else if (e.getCurrentItem().getType() == Material.PAINTING) {
					e.setCancelled(true);
					bp.chat("/score");
				} else if (e.getCurrentItem().getType() == Material.PAPER) {
					e.setCancelled(true);
					bp.closeInventory();
					bp.chat("/tagespecial");
				} else if (e.getCurrentItem().getType() == Material.ARROW) {
					e.setCancelled(true);
					openAccountMenuToBattlePlayer(bp);
				} else {
					e.setCancelled(true);
				}
			}
		}
	}
}