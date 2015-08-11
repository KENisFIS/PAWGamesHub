package us.pawgames.hub.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class PetMenu {
	private CustomItem hPet() {
		CustomItem hubPetOne = new CustomItem(Material.RABBIT_HIDE);
		hubPetOne.setDisplayName(ChatColor.GREEN + "Rabbit Pet");
		return hubPetOne;
	}
	public static Inventory hubPets = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Pet Menu");
	static {
		hubPets.setItem(1, hubPetOne.);
	}
}