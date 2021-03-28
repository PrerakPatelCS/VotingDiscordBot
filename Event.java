package DiscordBot.Voter;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Event extends ListenerAdapter{
    public static String text;
    Candidates candidates = new Candidates();
    
    public static void getText(String texting) {
        text += texting;
    }
    
    public void onMessageReceived(MessageReceivedEvent event){
        String[] msg = event.getMessage().getContentRaw().split(",");
        if (msg[0].equalsIgnoreCase("!addCandidates")){
                MessageChannel channel = event.getChannel();
                for(int i = 0; i < msg.length; i++){
                    candidates.add(msg[i]);
                }
                channel.sendMessage("Ballot Created ").queue();
        }
        else if(msg[0].equalsIgnoreCase("!printBallot")) {
            MessageChannel channel = event.getChannel();
            for(int i = 0; i < candidates.candidate.length; i++) {
                channel.sendMessage(candidates.candidate[i].Name).queue();
            }
        }
        else if(msg[0].equalsIgnoreCase("!DM")) {
            System.out.println(event.getChannelType());
            long userId = event.getAuthor().getIdLong();
            JDA api = event.getJDA();
            User user = api.getUserById(userId);
            event.getAuthor().openPrivateChannel().queue((channel) ->
            {
                channel.sendMessage("Hello there").queue();
            });
        }
        
            
            
        }
        /**
        String messageSent = event.getMessage().getContentRaw();
        event.getChannel().sendMessage(messageSent).queue();
        System.out.println(messageSent);
         */
}

