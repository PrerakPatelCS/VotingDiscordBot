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
        JDABuilder.createLight("ODI1NDcxNzc3MjMyNzgxMzIy.YF-agA.niythG2XY4ZDgI-ZfmuOFu5UeOg", GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.DIRECT_MESSAGES)
            .addEventListeners(new Event()).setActivity(Activity.playing("Candidate Voting"))
            .build();
    }
    
}