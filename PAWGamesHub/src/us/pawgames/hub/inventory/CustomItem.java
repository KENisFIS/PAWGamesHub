package us.pawgames.hub.inventory;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem extends ItemStack {
	private ItemStack item;
	private Material material;
	private int amount = 1;
	private short damage = 0;
	
	public CustomItem(ItemStack item) {
		this.item = item;
	}
	
	public CustomItem(Material material) {
		this.material = material;
		initialize();
	}
	
	public CustomItem(Material material, int amount) {
		this.material = material;
		this.amount = amount;
		initialize();
	}
	
	public CustomItem(Material material, int amount, short damage) {
		this.material = material;
		this.amount = amount;
		this.damage = damage;
		initialize();
	}
	
	private void initialize() {
		this.item = new ItemStack(this.material, this.amount, this.damage);
	}
 
	
	public ItemStack getItemStack() {
		if(item != null) {
			this.item = new ItemStack(Material.PAPER);
			return this.item;
		} else {
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