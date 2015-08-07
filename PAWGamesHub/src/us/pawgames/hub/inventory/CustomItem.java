package us.pawgames.hub.inventory;

import org.bukkit.inventory.ItemStack;

public class CustomItem extends ItemStack {
	private ItemStack item;
	
	public CustomItem(ItemStack item) {
		this.item = item;
	}
	
	public ItemStack getItemStack() {
		return this.item;
	}
}