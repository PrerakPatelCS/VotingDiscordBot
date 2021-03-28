package DiscordBot.Voter;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Event extends ListenerAdapter{
    BigFolder ballotList = new BigFolder();
    public static String text;
    
    public static void getText(String texting) {
        text += texting;
    }
    
    public void onMessageReceived(MessageReceivedEvent event){
        String[] msg = event.getMessage().getContentRaw().split(" /");
        String ballotName = new String();
        if (msg[0].equalsIgnoreCase("!makeBallot")){
                MessageChannel channel = event.getChannel();
                for (int i = 1; i < msg.length; i++) {
                    ballotName += msg[i];
                    ballotName += " ";
                }
                Ballot ballot = new Ballot();
                
                ballot.Name = ballotName;
                ballotList.add(ballot);
                channel.sendMessage("Ballot Created " + ballot.Name).queue();
        }
        else if(msg[0].equalsIgnoreCase("!printBallots")) {
            text = "";
            ballotList.print();
            MessageChannel channel = event.getChannel();
            channel.sendMessage(text).queue();
            
        }
        else if(msg[0].equalsIgnoreCase("!addCategory")) {
            Ballot ballot = new Ballot();
            ballot.Name = ballotName;
            
            MessageChannel channel = event.getChannel();
            channel.sendMessage(text).queue();
        }
            
            
            
            
            
            
        }
        /**
        String messageSent = event.getMessage().getContentRaw();
        event.getChannel().sendMessage(messageSent).queue();
        System.out.println(messageSent);
         */
}

