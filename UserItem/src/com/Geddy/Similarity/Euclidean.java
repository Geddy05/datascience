package com.Geddy.Similarity;

//import com.Geddy.Models.Articles;

import com.Geddy.Models.UserPreference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lord_ on 16-2-2016.
 */
public class Euclidean implements Distance {
    public float calculate(UserPreference targetUser ,UserPreference user){

        Double sum = 0.0;
        for (Map.Entry<Integer, Double> entry : targetUser.getRatings().entrySet()) {
            Integer key = entry.getKey();
            Double value = entry.getValue();
            double userRating ;
            if(user.getRatings().containsKey(key)) {
                userRating = user.getRating(key);
            }
            // do nothing if the user we compare with do not rate a item.
            else{
                continue;
            }
            sum += Math.pow((value - userRating), 2);
        }

        return 1/ (1 +((float)Math.sqrt(sum)));
    }
}
