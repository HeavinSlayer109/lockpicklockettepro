package cf.heavin.picklock;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import cf.heavin.picklock.Puzzles.Five;
import cf.heavin.picklock.Puzzles.Four;
import cf.heavin.picklock.Puzzles.One;
import cf.heavin.picklock.Puzzles.Six;
import cf.heavin.picklock.Puzzles.Three;
import cf.heavin.picklock.Puzzles.Two;
import net.md_5.bungee.api.ChatColor;

public class PickLock extends JavaPlugin implements Listener{
	public static HashMap<Player, Integer> lockPicking = new HashMap<Player, Integer>();
	public static HashMap<Player, String> slotsPicked = new HashMap<Player, String>();
	public static HashMap<Player, Boolean> invClose = new HashMap<Player, Boolean>();
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new UIListener(), this);
	}
	
	public static void finish(Player player, Location coordinate) {
		if (lockPicking.containsKey(player)) {
			slotsPicked.remove(player);
			lockPicking.remove(player);
			Random r = new Random();
			int chance = r.nextInt(10);
			System.out.println(chance);
			
			if(chance <= 2){
				coordinate.getWorld().playSound(coordinate, Sound.BLOCK_ANVIL_DESTROY, 2, 1.5F);
				player.sendMessage(color("&aChest picked lock!"));
				coordinate.getWorld().getBlockAt(coordinate).breakNaturally();
			} else if (chance > 2) {
				coordinate.getWorld().playSound(coordinate, Sound.BLOCK_ANVIL_PLACE, 2, 1);
				player.sendMessage(color("&cFalse set, chest is still locked!"));
			}
			
			player.closeInventory();
		}
	}
	public static void fail(Player player) {
		player.sendMessage(color("&cYou failed the puzzle"));
		if (lockPicking.containsKey(player)) {
			slotsPicked.remove(player);
			lockPicking.remove(player);
			player.closeInventory();
			
		}
	}
	
	public static void reset(Player player) {
		if (lockPicking.containsKey(player)) {
			slotsPicked.remove(player);
			lockPicking.remove(player);
			player.closeInventory();
			
		}
	}
	static Location loc;
	public static Location getBlockLoc(Player player) {
		return loc;
	}
	
	@EventHandler
	public void setCloseInventoryByPlugin(InventoryCloseEvent e) {
		Player player = (Player) e.getPlayer();
		invClose.put(player, true);
	}
	
	@EventHandler
	public void hashmapsOnLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if (lockPicking.containsKey(player)) {
			lockPicking.remove(player);
		} else return;
		if (slotsPicked.containsKey(player)) {
			slotsPicked.remove(player);
		} else return;
		if (invClose.containsKey(player)) {
			invClose.remove(player);
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Block block = e.getClickedBlock();
	    Player player = e.getPlayer();
	    if(block.getType() == Material.OAK_WALL_SIGN && block.getType() != null) {
            Sign sign = (Sign) block.getState();
            String[] lines = sign.getLines();
            String l1 = lines[0];	
            if (l1.equalsIgnoreCase("[Private]")){
            	if (player.getItemInHand().getType() == Material.CHAIN) {
            		Random r = new Random();
            		int low = 1;
            		int high = 6;
            		int rand = r.nextInt(high-low) + low;
            		loc = e.getClickedBlock().getLocation();
            		if (!lockPicking.containsKey(player)) {
            			lockPicking.put(player, rand);
            		} else if (lockPicking.containsKey(player)) {
            			lockPicking.remove(player, rand);
            		}
             		if (rand == 1) {
            			new One(player);
            			Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            				if (lockPicking.containsKey(player)) {
            					new BaseUI(player, rand);
            				}
            			}, 100);
            		} else if (rand == 2) {
            			new Two(player);
            			Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            				if (lockPicking.containsKey(player)) {
            					new BaseUI(player, rand);
            				}
            			}, 100);
            		} else if (rand == 3) {
            			new Three(player);
            			Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            				if (lockPicking.containsKey(player)) {
            					new BaseUI(player, rand);
            				}
            			}, 100);
            		} else if (rand == 4) {
            			new Four(player);
            			Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            				if (lockPicking.containsKey(player)) {
            					new BaseUI(player, rand);
            				}
            			}, 100);
            		} else if (rand == 5) {
            			new Five(player);
            			Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            				if (lockPicking.containsKey(player)) {
            					new BaseUI(player, rand);
            				}
            			}, 100);
            		} else if (rand == 6) {
            			new Six(player);
            			Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
            				if (lockPicking.containsKey(player)) {
            					new BaseUI(player, rand);
            				}
            			}, 100);
            			
            		}
            	}
            }
            }
	    }

}
