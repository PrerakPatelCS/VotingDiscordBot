package DiscordBot.Voter;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

/**
 * Hello world!
 *
 */
public class App extends ListenerAdapter {
    public static void main( String[] args ) throws LoginException
    {
        JDABuilder.createLight("ODI1NTc4NTUxNTQwNzExNDY1.YF_98Q.7UJVl3926XOeS3_9psoSHqTTdIw", GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.DIRECT_MESSAGES)
            .addEventListeners(new Event()).setActivity(Activity.playing("Candidate Voting"))
            .build();
    }
    
}