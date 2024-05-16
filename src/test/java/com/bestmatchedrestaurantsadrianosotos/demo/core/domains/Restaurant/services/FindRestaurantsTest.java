import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.Restaurant;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.Restaurant.services.FindRestaurants;
import com.bestmatchedrestaurantsadrianosotos.demo.core.domains.SearchCriteria.SearchCriteria;
import com.bestmatchedrestaurantsadrianosotos.demo.core.ports.Repository;
import com.bestmatchedrestaurantsadrianosotos.demo.TestUtils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FindRestaurantsTest {
    private Repository repositoryMock;

    @BeforeEach
    public void setUp() {
        repositoryMock = Mockito.mock(Repository.class);

        List<Restaurant> defaultRestaurants = List.of();
        when(repositoryMock.getRestaurantsByCriteria(any(SearchCriteria.class))).thenReturn(defaultRestaurants);
    }

    @Test
    public void returnRestaurantsFromRepository() {
        List<Restaurant> restaurants = List.of(
                TestUtils.createRestaurant("Restaurant A", 4, 2, 30, "Italian"),
                TestUtils.createRestaurant("Restaurant B", 3, 5, 20, "Mexican")
        );
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("Restaurant");

        when(repositoryMock.getRestaurantsByCriteria(any(SearchCriteria.class))).thenReturn(restaurants);

        FindRestaurants findRestaurants = new FindRestaurants(repositoryMock);

        List<Restaurant> result = findRestaurants.invoke(searchCriteria);

        assertEquals(restaurants.size(), result.size());
    }

    @Test
    public void throwErrorInCaseOfInvalidCriteria() {
       SearchCriteria query = Mockito.mock(SearchCriteria.class);
       when(query.checkAllValuesEmpty()).thenReturn(true);

       FindRestaurants findRestaurants = new FindRestaurants(repositoryMock);

        assertThrows(Error.class, () -> {
            findRestaurants.invoke(query);
        });
    }
}
