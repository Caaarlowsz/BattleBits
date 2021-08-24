package br.com.battlecraft.kitpvp.warps.Spawn;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class ItensKit {

	public static final ItemStack PvP() {
		final ItemStack i = new ItemStack(Material.DIAMOND_SWORD, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lPvP");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Kit sem habilidades, porem você recebe uma",
				"§7espada com afiada 1 para vantagens de dano!", "", "§e§lITENS", "§fNenhum" }));
		ik.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Anchor() {
		final ItemStack i = new ItemStack(Material.ANVIL, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lAnchor");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Nao dê nem leve knockback no oponente",
				"§7e impossibite-o de fugir de voce!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Ajnin() {
		final ItemStack i = new ItemStack(Material.NETHER_STAR, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lAjnin");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao hitar um jogador, agache (shift) e",
				"§7ele sera teletransportado para voce!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Gladiator() {
		final ItemStack i = new ItemStack(Material.IRON_FENCE, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lGladiator");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Puxe um inimigo para 1v1 onde",
				"§7terao uma batalha sem serem interronpidos!", "", "§e§lITENS", "§fBarra de Ferro" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Ninja() {
		final ItemStack i = new ItemStack(Material.EMERALD, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lNinja");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao hitar um jogador, agache (shift) e",
				"§7voce sera teletransportado para ele!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Boxer() {
		final ItemStack i = new ItemStack(Material.IRON_SWORD, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lBoxer");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7De 1.5 coraçoes a mais de dano e",
				"§7receba 1.5 coraçoes a menos de dano!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Fisherman() {
		final ItemStack i = new ItemStack(Material.FISHING_ROD, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lFisherman");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao fisgar um inimigo com sua vara",
				"§7ao puxar ele sera trazido ate voce!", "", "§e§lITENS", "§fVara de pesca" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack AntiStomper() {
		final ItemStack i = new ItemStack(Material.DIAMOND_HELMET, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lAntiStomper");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Leve dano reduzido para stompers",
				"§7como se estivesse sempre de shift (agachado)", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Stomper() {
		final ItemStack i = new ItemStack(Material.DIAMOND_BOOTS, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lStomper");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao pular ou cair de um lugar alto",
				"§7esmague todos que estiverem em baixo!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Hulk() {
		final ItemStack i = new ItemStack(Material.SADDLE, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lHulk");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao clickar com botao direito em alguem",
				"§7carregue-o em cima de sua cabeça", "", "§e§lITENS", "§fSela" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Kangaroo() {
		final ItemStack i = new ItemStack(Material.FIREWORK, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lKangaroo");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Com seu foguete, pule alto e",
				"§7mova-se mais rapido pelo mapa!", "", "§e§lITENS", "§fFoguete" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Fireman() {
		final ItemStack i = new ItemStack(Material.FIRE, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lFireman");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Nao leve nenhum tipo de dano para",
				"§7elementos como fogo ou lava!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Magma() {
		final ItemStack i = new ItemStack(Material.LAVA_BUCKET, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lMagma");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao hitar um jogador tenha 40% de chance de",
				"§7ele pegar fogo! Nao leve dano para fogo ou lava, porem",
				"§7ao ficar na agua, leve 3 coraçoes de dano por segundo!", "", "§e§lITENS", "§fNenhum" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Monk() {
		final ItemStack i = new ItemStack(Material.BLAZE_ROD, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lMonk");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao clickar em alguem com sua vara magica",
				"§7bagunçe o inventario dele!", "", "§e§lITENS", "§fBlaze" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Minato() {
		final ItemStack i = new ItemStack(Material.ARROW, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lMinato");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ao lançar sua kunai com um selo",
				"§7teleporte-se rapidamente para onde ela encostar!", "", "§e§lITENS", "§fArco, Flechas" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Phantom() {
		final ItemStack i = new ItemStack(Material.FEATHER, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lPhantom");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Ganhe o poder de Voar", "§7por 7 segundos!",
				"", "§e§lITENS", "§fPena" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Switcher() {
		final ItemStack i = new ItemStack(Material.SNOW_BALL, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lSwitcher");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Lançe sua bola em alguem",
				"§7e troque de lugar com ela!", "", "§e§lITENS", "§fBolas de neve" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Thor() {
		final ItemStack i = new ItemStack(Material.GOLD_AXE, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lThor");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Clique com seu machado em para uma",
				"§7direçao, e faça cair um relampago dos ceus ali!", "", "§e§lITENS", "§fMachado de ouro" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Timelord() {
		final ItemStack i = new ItemStack(Material.WATCH, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lTimelord");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7Paralise todos jogadores a 6",
				"§7blocos de distancia de vc por 7 segundos!", "", "§e§lITENS", "§fRelogio" }));
		i.setItemMeta(ik);
		return i;
	}

	public static final ItemStack Viking() {
		final ItemStack i = new ItemStack(Material.DIAMOND_AXE, 1, (byte) 0);
		final ItemMeta ik = i.getItemMeta();
		ik.setDisplayName("§b§lViking");
		ik.setLore(Arrays.asList(new String[] { "", "§a§lHABILIDADE", "§7De mais dano com seu machado",
				"§7de diamante mais afiado que uma espada!", "", "§e§lITENS", "§fMachado de diamante (afiação 2)" }));
		i.setItemMeta(ik);
		return i;
	}
}
