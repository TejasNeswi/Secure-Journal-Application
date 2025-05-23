package com.springBoot.journalApp.service;

import com.springBoot.journalApp.api.response.WeatherResponse;
import com.springBoot.journalApp.cache.AppCache;
import com.springBoot.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apikey ;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city)
    {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if(weatherResponse!=null)
        {
            return weatherResponse;
        }
        else{
            String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY, city).replace(PlaceHolders.API_KEY, apikey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body!=null)
            {
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }

    }


//    For Post call
//    public WeatherResponse getWeather(String city)
//    {
//        String finalApi = API.replace("CITY", city).replace("API_KEY", apikey);
//        String requestBody="{\n" +
//                "    \"userName\":\"Ram\",\n" +
//                "    \"password\":\"ram\"\n" +
//                "}";
//        HttpEntity<String> httpEntity=new HttpEntity<>(requestBody);

//        UserDetails user = User.builder().username("Ram").password("ram123").build();
//        HttpHeaders httpHeaders=new HttpHeaders();
//        HttpEntity<User> httpEntity=new HttpEntity<>(user, httpHeaders);
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.POST, httpEntity, WeatherResponse.class);
//        WeatherResponse body = response.getBody();
//        return body;
//    }
}
