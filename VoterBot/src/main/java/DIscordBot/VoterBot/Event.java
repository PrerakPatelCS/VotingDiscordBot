package DIscordBot.VoterBot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Event extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent event){
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                   .queue(response /* => Message */ -> {
                       response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                   });
        }
        /**
        String messageSent = event.getMessage().getContentRaw();
        event.getChannel().sendMessage(messageSent).queue();
        System.out.println(messageSent);
         */
    }

}
