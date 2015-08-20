package us.pawgames.hub.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PetMenu {
	private Inventory menu;
	private Player player;
	
	public void PetMenu(Player player) {
		this.player = player;
		menu = Bukkit.createInventory(player, 27, ChatColor.BLUE + "Pet Menu");
		
		createMenu();
	}
	
	private void createMenu() {
		menu.setItem(1, rabbit().getItemStack());
	}
	
	private CustomItem filler() {
		CustomItem filler = new CustomItem(Material.EGG);
		filler.setDisplayName(ChatColor.RED + "What could it be?");
		
		return filler;
	}
	
	private CustomItem rabbit() {
		if(player.hasPermission("pawgames.hub.pets.rabbit")) {
			CustomItem rabbit = new CustomItem(Material.RABBIT_HIDE);
			rabbit.setDisplayName(ChatColor.GREEN + "Bunny Wabbit");
			
			return rabbit;
		} else {
			return filler();
		}
	}
	public Inventory getInventory() {
		return this.menu;
		}
}