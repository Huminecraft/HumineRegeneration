package com.humine.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class HealthRegenerationEvent implements Listener{

	@EventHandler
	public void onRegen(EntityRegainHealthEvent event) {
		if(event.getEntity() instanceof Player) {
			if(event.getRegainReason() == RegainReason.REGEN) {
				event.setCancelled(true);
			}
		}
	}
}
