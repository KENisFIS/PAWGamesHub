package us.pawgames.hub.inventory;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem extends ItemStack {
	private ItemStack item;
	
	public CustomItem(ItemStack item) {
		this.item = item;
	}
	
	public CustomItem(Material material) {
		this.item =new ItemStack(material, 1);
	}
	
	public CustomItem(Material material, int amount) {
		this.item = new ItemStack(material, amount);
	}
	
	public CustomItem(Material material, int amount, short damage) {
		this.item = new ItemStack(material, amount, damage);
	}
	
	public ItemStack getItemStack() {
		if(item != null) {
			return this.item;
		} else {
			this.item = new ItemStack(Material.PAPER);
			setDisplayName("TELL DEVS YOU GOT THIS");
			return this.item;
		}
	}
	
	public void setDisplayName(String displayName) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(displayName);
		this.item.setItemMeta(meta);
	}
	
	public void setFlag(ItemFlag flag) {
		ItemMeta meta = this.item.getItemMeta();
		meta.addItemFlags(flag);
		this.item.setItemMeta(meta); 
	}
	
	public void setLore(ArrayList<String> lore) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setLore(lore);
		this.item.setItemMeta(meta);
	}
}