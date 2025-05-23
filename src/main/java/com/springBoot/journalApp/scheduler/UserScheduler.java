package com.springBoot.journalApp.scheduler;

import com.springBoot.journalApp.cache.AppCache;
import com.springBoot.journalApp.entity.JournalEntry;
import com.springBoot.journalApp.entity.User;
import com.springBoot.journalApp.enums.Sentiment;
import com.springBoot.journalApp.repository.UserRepositoryImpl;
import com.springBoot.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private AppCache appCache;

    @Autowired
    private EmailService emailService;


//    @Scheduled(cron = "0 0 9 * * SUN")
    public void fetchUsersAndSendSaMail()
    {
        List<User> users = userRepository.getUserForSA();
        for(User user: users)
        {
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts=new HashMap<>();
            for(Sentiment sentiment: sentiments)
            {
                if(sentiment!=null)
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0)+1);
            }
            Sentiment mostFrequentSentiment=null;
            int maxCount=0;
            for(Map.Entry<Sentiment, Integer> entry: sentimentCounts.entrySet())
            {
                if(entry.getValue()>maxCount)
                {
                    maxCount=entry.getValue();
                    mostFrequentSentiment=entry.getKey();
                }
            }
            if(mostFrequentSentiment!=null)
            emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days", mostFrequentSentiment.toString());
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void reloadAppCache()
    {
        appCache.init();
    }
}
