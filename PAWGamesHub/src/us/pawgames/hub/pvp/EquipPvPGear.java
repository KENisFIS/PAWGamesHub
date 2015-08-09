package us.pawgames.hub.pvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.pawgames.hub.PAWHub;
import us.pawgames.hub.inventory.CustomItem;

public class EquipPvPGear {
	ArrayList<String>chestLore = new ArrayList<String>();
	ArrayList<String>bootLore = new ArrayList<String>();
	ArrayList<String>legLore = new ArrayList<String>();
	ArrayList<String>helmetLore = new ArrayList<String>();
	private Player player;
	public EquipPvPGear(Player player) {
		this.player = player;
	}
public void diamondGear() {
	CustomItem chest = new CustomItem(Material.DIAMOND_CHESTPLATE);
	CustomItem boot = new CustomItem(Material.DIAMOND_BOOTS);
	CustomItem leg = new CustomItem(Material.DIAMOND_LEGGINGS);
	CustomItem helmet = new CustomItem(Material.DIAMOND_HELMET);
	chest.setDisplayName("PvP Chestplate");
	boot.setDisplayName("PvP Boots");
	helmet.setDisplayName("PvP Helmet");
	leg.setDisplayName("PvP Leggings");
	helmetLore.add(ChatColor.RED + "" + ChatColor.RED + "Use this for pvp!");
	chestLore.add(ChatColor.RED + "" + ChatColor.RED + "Use this for pvp!");
	legLore.add(ChatColor.RED + "" + ChatColor.RED + "Use this for pvp!");
	chestLore.add(ChatColor.RED + "" + ChatColor.RED + "Use this for pvp!");
	chest.setLore(chestLore);
	chest.setLore(legLore);
	chest.setLore(bootLore);
	chest.setLore(helmetLore);
	
}
}