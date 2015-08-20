package us.pawgames.hub.effects;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import us.pawgames.hub.PAWHub;
public class Particle {
	private Plugin plugin;
	private ParticleEffect effect;
	private Location location;
	
	public Particle(Plugin plugin, ParticleEffect effect, Location center) {
		this.plugin = plugin;
		this.effect = effect;
		this.location = center;
	}

	public void parametric(int delay, int duration) {
		new BukkitRunnable(){
			double t = Math.PI/4;
			public void run(){
            	t = t + 0.1*Math.PI;
            	for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
            		double x = t*Math.cos(theta);
            		double y = 2*Math.exp(-1.0*t) * Math.sin(t) + 1.5;
            		double z = t*Math.sin(theta);
            		location.add(x,y,z);
            		effect.display(0, 0, 0, 0, 1, location, 32);
            		location.subtract(x,y,z);
            		
            		theta = theta + Math.PI/64;
            		
            		x = t*Math.cos(theta);
            		y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
            		z = t*Math.sin(theta);
            		location.add(x,y,z);
            		effect.display(0, 0, 0, 0, 1, location, 32);
            		location.subtract(x,y,z);
            	}
            	if (t > 4.8){
            		this.cancel();
            	}
            }
		}.runTaskTimer(plugin, delay, duration);
	}
	
	public void xHeart(final Player player, final ParticleEffect effect, int delay, int period) {
		//formula: (2x^2 + y^2 + z^2 - 1)^3 - x^2 * z^3 / 10 - y^2 * z^3 = 0
		//             -3 <= x,y,z <= 3
		
		new BukkitRunnable() {
			Location location = player.getLocation();
			
			@Override
			public void run() {
				
			}
		}.runTaskTimer(plugin, delay, period);
	}
	
	public void zHeart(final Player player, final ParticleEffect effect, int ticks) {
		//formula: (x^2 + (9 / 4) * y^2 + z^2 - 1)^3 - x^2 * z^3 - (9 / 80) * y^2 * z^3 = 0
		//             -3 <= x,y,z <= 3
	}
	
	public void sphere(final Player player,double startSize, double finalSize, int delay, int duration) {
		new BukkitRunnable(){
			double t = Math.PI/4;
			Location location = player.getLocation();
			//Random random = new Random();
			@Override
			public void run(){
            	t = t + 0.1*Math.PI;
            	for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
            		double x = t*Math.cos(theta);
            		double y = 2*Math.exp(-1.0*t) * Math.sin(t) + 1.5;
            		double z = t*Math.sin(theta);
            		location.add(x,y,z);
            		effect.display(0, 0, 0, 0, 1, location, 32);
            		location.subtract(x,y,z);
            	}
            	if (t > 4.8){
            		this.cancel();
            	}
            }
		}.runTaskTimer(plugin, 0, 1);
	
	}
}
