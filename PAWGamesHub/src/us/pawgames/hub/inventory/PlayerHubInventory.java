package us.pawgames.hub.inventory;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerHubInventory {
	private Player player;
	
	public PlayerHubInventory(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	
	public void setPlayerInventory() {
		Inventory playerInventory = player.getInventory();
		playerInventory.clear();
		
		playerInventory.setItem(0, navigation().getItemStack());
		playerInventory.setItem(1, pvpSword().getItemStack());
		playerInventory.setItem(10, petsMenu().getItemStack());
		playerInventory.setItem(28, morphMenu().getItemStack());
	}
	
	private CustomItem navigation() {
		CustomItem compass = new CustomItem(Material.COMPASS, 1);
		compass.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Select a Game");
		ArrayList<String> compassLore = new ArrayList<String>();
		compassLore.add(ChatColor.AQUA + "Plan to have all available servers");
		compassLore.add(ChatColor.AQUA + "listed with online stat us");
		compass.setLore(compassLore);
		
		return compass;
	}
	
	private CustomItem pvpSword() {
		CustomItem sword = new CustomItem(Material.DIAMOND_SWORD, 1);
		sword.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Pvp Activation Weapon");
		ArrayList<String> swordLore = new ArrayList<String>();
		swordLore.add(ChatColor.AQUA + "You can use /sword [swordname]");
		swordLore.add(ChatColor.AQUA + "to create your own custom sword.");
		sword.setLore(swordLore);
		
		return sword;
	}
	
	private CustomItem petsMenu() {
		CustomItem pet = new CustomItem(Material.NAME_TAG);
		pet.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Hub Pets");
		ArrayList<String> petLore = new ArrayList<String>();
		petLore.add(ChatColor.AQUA + "Click here to open a menu with all of the pets");
		petLore.add(ChatColor.AQUA + "available to you on" + ChatColor.RED + "PAWGames");
		pet.setLore(petLore);
		
		return pet;
	}
	
	private CustomItem morphMenu() {
		CustomItem morph = new CustomItem(Material.BEACON);
		morph.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Hub Disguises");
		ArrayList<String> morphLore = new ArrayList<String>();
		morphLore.add(ChatColor.AQUA + "Oh No! Someone might recognize you, quick put on");
		morphLore.add(ChatColor.AQUA + "a disguise and hopefully they will pass you by!");
		morph.setLore(morphLore);
		
		return morph;
	}
}
