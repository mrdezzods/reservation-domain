package services;

import domain.Review;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrdezzods on 25/04/16.
 */
public class ReviewService {
    public List<Review> getReviewsFor(String slug) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            List<Review> reviews = restTemplate.getForObject("http://www.eatonline-wip.neposoft.org/api/v1/restaurants/" + slug + "/reviews", List.class);
            return reviews;
        } catch (Exception ex) {
            List<Review> reviews = new ArrayList<Review>();
            return reviews;
        }

    }
}
