package us.pawgames.hub.effects;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import us.pawgames.hub.PAWHub;
public class Particle implements Listener {
		private PAWHub instance;
		
		public Particle(PAWHub pawHub) {
			pawHub.getServer().getPluginManager().registerEvents(this,pawHub);
			this.instance = pawHub;
		}
		@EventHandler
	    	public void createPart(final Player player) {
	                    new BukkitRunnable(){
	                        double t = Math.PI/4;
	                        Location loc = player.getLocation();
	                        Random r = new Random();
	                        public void run(){
                                t = t + 0.1*Math.PI;
                                for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
                                    double x = t*Math.cos(theta);
                                    double y = 2*Math.exp(-1.0*t) * Math.sin(t) + 1.5;
                                    double z = t*Math.sin(theta);
                                    loc.add(x,y,z);
                                    ParticleEffect.SPELL_WITCH.display(0, 0, 0, 0, 1, loc, 32);
                                    loc.subtract(x,y,z);
                                   
                                    theta = theta + Math.PI/64;
                                   
                                    x = t*Math.cos(theta);
                                    y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
                                    z = t*Math.sin(theta);
                                    loc.add(x,y,z);
                                    ParticleEffect.CRIT_MAGIC.display(0, 0, 0, 0, 1, loc, 32);
                                    loc.subtract(x,y,z);
	                                }
	                                if (t > 4.8){
	                                        this.cancel();
	                                }
	                        }
	                                
	                    }.runTaskTimer(instance, 0, 1);
		}
		@EventHandler
		public void onJoinEvent(PlayerJoinEvent e) {
			Player p = (Player) e.getPlayer();
			if(p.hasPermission("particle.special")) {
				createPart(p);
			
		}
}
}
