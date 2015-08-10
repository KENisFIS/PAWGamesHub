package us.pawgames.hub.pvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import us.pawgames.hub.inventory.CustomItem;

public class EquipPvPGear {
	//smart using these as field vars so we don't have to make them over and over for all different types of armor
	//just set them to private as we have no need to call these vars on any other class.
	private ArrayList<String> chestLore = new ArrayList<String>();
	private ArrayList<String> bootLore = new ArrayList<String>();
	private ArrayList<String> legLore = new ArrayList<String>();
	private ArrayList<String> helmetLore = new ArrayList<String>();
	
	private Player player;
	
	public EquipPvPGear(Player player) {
		this.player = player;
	}

	// more readable format
	public void diamondGear() {
		CustomItem helmet = new CustomItem(Material.DIAMOND_HELMET);
		helmet.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "ORK Helmet");
		helmetLore.add(ChatColor.RED + "" + ChatColor.BOLD + "Use this for pvp!");//why red and red?
		helmet.setLore(helmetLore);												 //was chest.setLore(helmetLore) so you set it 4 times.
		
		CustomItem chest = new CustomItem(Material.DIAMOND_CHESTPLATE);
		chest.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "CHESTisFIS");
		chestLore.add(ChatColor.RED + "" + ChatColor.BOLD + "Use this for pvp!");//why red and red?
		chest.setLore(chestLore);												//correct use of chest.setLore(chestLore)
		
		CustomItem leg = new CustomItem(Material.DIAMOND_LEGGINGS);
		leg.setDisplayName(ChatColor.BOLD + "Pants of PAW");
		legLore.add(ChatColor.RED + "" + ChatColor.BOLD + "Use this for pvp!"); 	//why red and red?
		leg.setLore(legLore);													//was chest.setLore(legLore)
		
		CustomItem boot = new CustomItem(Material.DIAMOND_BOOTS);
		boot.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD +"Boots of YES");
		bootLore.add(ChatColor.RED + "" + ChatColor.BOLD + "For those who know to yes!");
		boot.setLore(bootLore);													
		
		//needed a way to equip these on the player
		//or a return on the items that we created here.
		equip(helmet, chest, leg, boot);
	}
	
	public void equip(CustomItem helmet, CustomItem chest, CustomItem leg, CustomItem boot) {
		player.getInventory().setHelmet(helmet.getItemStack());
		player.getInventory().setChestplate(chest.getItemStack());
		player.getInventory().setLeggings(leg.getItemStack());
		player.getInventory().setBoots(boot.getItemStack());
	}
	
	public void unequip() {
		//player.getInventory().setHelmet(null);
		player.getInventory().setArmorContents(null);
		player.updateInventory();
	}
}