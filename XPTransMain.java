package com.github.ZXSkelobrine.XPTrans;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class XPTransMain extends JavaPlugin {
  
	@Override
	public void onEnable(){ //Enable plugin
		getLogger().info("[XPTrans]" + "");                          //Send messages to console and log - Start
		getLogger().info("[XPTrans]" + "");
		getLogger().info("XPTrans has been activated succcesfully");
		getLogger().info("Made By: ZXSkelobrine");
		getLogger().info("[XPTrans]" + "");
		getLogger().info("[XPTrans]" + "");                          //Send messages to console and log - End
	}
	
	public void OnDisable(){//Disable Plugin
		getLogger().info("[XPTrans]" + "");                          //Send messages to console and log - Start 
		getLogger().info("[XPTrans]" + "");
		getLogger().info("XPTrans has been deactivated succcesfully");
		getLogger().info("Made By: ZXSkelobrine");
		getLogger().info("[XPTrans]" + "");
		getLogger().info("[XPTrans]" + "");                          //Send messages to console and log - End     
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){   //Comand stuff start - (Just copy paste this line if you are making your own :P)
		Player player = (Player) sender; //Player = The person who sent the command (Sender)
		if(cmd.getName().equalsIgnoreCase("XPTrans")){ //Actual command (Bit in "")
			if(player instanceof Player){ //Not really sure but just compy paste it
				int Exp = (int) player.getLevel(); //Gets XP level of player and put it into Exp variable
				if(Exp < 1){ //If you have less that one level...
					player.sendMessage(ChatColor.DARK_RED + "[XPTrans]" + ChatColor.RED + "Whoops... You don't have enough XP!"); //...Tell you you dont have enough
				}
				else{//If you have more...
					player.sendMessage(ChatColor.DARK_RED + "[XPTrans]" + ChatColor.RED + "Your XP was: " + ChatColor.ITALIC + Exp);//...Tell you what your xp was...
					int SetExp = Exp - 1;//...Take 1 level from original and put it to SetExp variable...
					player.setLevel(SetExp);//...set your xp to that (Original - 1 level)...
					int ExpNew = (int) player.getLevel();//...get your new xp level...
					player.sendMessage(ChatColor.DARK_RED + "[XPTrans]" + ChatColor.RED + "Your XP is now: " + ChatColor.ITALIC + ExpNew);//...tell you what xp you have now...
				    PlayerInventory inventory = player.getInventory(); // Random stuff to do with the player's inventory
				    ItemStack itemstack = new ItemStack(Material.EXP_BOTTLE, 2); // Itemstack = Bottle 'o' Enchanting
				    inventory.addItem(itemstack);//Give you Bottle 'o' Enchanting
				}
				if(player.hasPermission("XPTrans.Give")){//Permissions bit the permission itself is the bit in ""
				}else{//If you dont...
					player.sendMessage(ChatColor.DARK_RED + "...XPTrans has encountered an error:" + ChatColor.DARK_BLUE + "Access Denied - You do not have permission!");//...Tell you so
				}
			}
		}
		return false;//If this hasn't happened
	}
}
//I have left out my developer commands that are acctually in the plugin :P
