package us.pawgames.hub.inventory;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerInventory {
	private Player player;
	
	public PlayerInventory(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	
	public void setPlayerInventory() {
		Inventory playerInventory = player.getInventory();
		player.getInventory().clear();
		
		CustomItem compass = new CustomItem(Material.COMPASS, 1);
		compass.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Select a Game");
		ArrayList<String> compassLore = new ArrayList<String>();
		compassLore.add(ChatColor.AQUA + "Plan to have all available servers");
		compassLore.add(ChatColor.AQUA + "listed with online status");
		compass.setLore(compassLore);
		playerInventory.setItem(0, compass);
		
		CustomItem pvpSword = new CustomItem(Material.DIAMOND_SWORD, 1);
		pvpSword.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "PAW");
		ArrayList<String> pvpSwordLore = new ArrayList<String>();
		pvpSwordLore.add(ChatColor.AQUA + "You can use /sword [swordname]");
		pvpSwordLore.add(ChatColor.AQUA + "to create your own custom sword.");
		pvpSword.setLore(pvpSwordLore);
		playerInventory.setItem(1, pvpSword);
	}
}
