package us.pawgames.hub.events;

import java.util.Arrays;

import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import us.pawgames.hub.effects.Particle;
import us.pawgames.hub.effects.ParticleEffect;
import us.pawgames.hub.inventory.PetMenu;
import us.pawgames.hub.inventory.PlayerHubInventory;
import us.pawgames.hub.pvp.EquipPvPGear;

public class HubEventHandler implements Listener{
	public PetMenu petMenu;
	private Plugin plugin;
	
	public HubEventHandler(Plugin plugin) {
		this.plugin = plugin;
		petMenu = new PetMenu();
	}
	
	@EventHandler
	private void inventoryClick(InventoryClickEvent event) {
		if(event.getWhoClicked() instanceof Player) {
			Player player = (Player) event.getWhoClicked();
			if(player.getGameMode() != GameMode.CREATIVE) {
				if(event.getClickedInventory() == player.getInventory()) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	private void playerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player sender = event.getPlayer();
		String serverCommand = "/server ";
		if(event.getMessage().startsWith(serverCommand)) {
			for(Player onlinePlayer: sender.getWorld().getPlayers()) {
				onlinePlayer.sendMessage(sender.getCustomName() + ChatColor.AQUA + " went to " + ChatColor.GREEN + event.getMessage().substring(7).toUpperCase());
			}
		}
	}
	
	@EventHandler
	private void playerDropItem(PlayerDropItemEvent event) {
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	private void playerItemHeld(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		EquipPvPGear equipment = new EquipPvPGear(player);
		if(event.getNewSlot() == 1) {
			equipment.diamondGear();
		} else if(event.getNewSlot() != 1){
			equipment.unequip();
		}
	}
	
	@EventHandler
	private void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setGameMode(GameMode.ADVENTURE);
		new PlayerHubInventory(player).setPlayerInventory();
		if(player.hasPermission("particle.special")) {
			new Particle(plugin, ParticleEffect.SPELL_WITCH, player.getLocation()).parametric(0, 10);
			new Particle(plugin, ParticleEffect.CRIT_MAGIC, player.getLocation()).parametric(10, 10);
		}
	}
	
	@EventHandler
	private void playerPickupItem(PlayerPickupItemEvent event) {
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}
	@EventHandler
	private void weatherChange(WeatherChangeEvent event){
		event.setCancelled(true);
	}
	@EventHandler
	private void onRighhtClick(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			Player p = e.getPlayer();
			if(p.getItemInHand().getType() == Material.NAME_TAG);
			p.openInventory(petMenu.getInventory());
			
		}
	}
}