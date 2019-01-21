package com.humine.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.humine.events.HealthRegenerationEvent;

public class RegenMain extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new HealthRegenerationEvent(), this);
		
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(Player player : Bukkit.getOnlinePlayers()) {
					if(player.getHealth() < 20.0) {
						double health = player.getHealth() + 1.0;
						player.setHealth(health);
					}
				}
			}
		}, 0L, (30 * 20));
	}
}
