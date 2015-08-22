package us.pawgames.hub.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PetMenu {
	private Inventory menu;
	private Player player;
	
	public PetMenu(Player player) {
		this.player = player;
		menu = Bukkit.createInventory(player, 27, ChatColor.BLUE + "Pet Menu");
		
		createMenu();
	}
	
	private void createMenu() {
		menu.setItem(0, rabbit().getItemStack());
		menu.setItem(1, cow().getItemStack());
		menu.setItem(2, pig().getItemStack());
		menu.setItem(3, creeper().getItemStack());
		menu.setItem(4, snowgolem().getItemStack());
		menu.setItem(5, endermen().getItemStack());
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
	private CustomItem cow() {
		if(player.hasPermission("pawgames.hub.pets.cow")) {
			CustomItem cow = new CustomItem(Material.LEATHER);
			cow.setDisplayName(ChatColor.BLUE + "Cow");
			
			return cow;
		} else {
			return filler();
		}
	}
	private CustomItem pig() {
		if(player.hasPermission("pawgames.hub.pets.pig")) {
			CustomItem pig = new CustomItem(Material.PORK);
			pig.setDisplayName(ChatColor.RED + "Pig");
			
			return pig;
		} else {
			return filler();
		}
	}
	private CustomItem creeper() {
		if(player.hasPermission("pawgames.hub.pets.creeper")) {
			CustomItem creeper = new CustomItem(Material.SULPHUR);
			creeper.setDisplayName(ChatColor.GRAY + "Creeper");
			
			return creeper;
		} else {
			return filler();
		}
	}
	private CustomItem endermen() {
		if(player.hasPermission("pawgames.hub.pets.endermen")) {
			CustomItem endermen = new CustomItem(Material.ENDER_PEARL);
			endermen.setDisplayName(ChatColor.LIGHT_PURPLE + "Endermen");
			
			return endermen;
		} else {
			return filler();
		}
	}
	private CustomItem snowgolem() {
		if(player.hasPermission("pawgames.hub.pets.snowgolem")) {
			CustomItem snowgolem = new CustomItem(Material.SNOW_BALL);
			snowgolem.setDisplayName(ChatColor.GOLD + "Snow Golem");
			
			return snowgolem;
		} else {
			return filler();
		}
	}
	public Inventory getInventory() {
		return this.menu;
		}
}