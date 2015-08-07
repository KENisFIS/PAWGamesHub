package us.pawgames.hub;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PAWInventoryUtility {
	
	
	public static void createDisplay(Material material, Inventory inv, int slot, String name, ArrayList<String> lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		//ArrayList<String> Lore = new ArrayList<String>();
		//for(String loreLine: lore){
		//	Lore.add(loreLine);
		//}
		meta.setLore(lore);
		item.setItemMeta(meta);
		 
		inv.setItem(slot, item); 
		 
		}
	
	

}
