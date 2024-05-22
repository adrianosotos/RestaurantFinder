import { useState } from "react";
import { SearchCriteria } from "../../../../core/domains/SearchCriteria/SearchCriteria";
import { FetchRestaurantsByCriteriaFactory } from "../../../../infra/factories/fetchRestaurantsByCriteiraFactory";
import { Restaurant } from "../../../../core/domains/Restaurants/Restaurants";

export function useRestaurantFinderController() {
  const [restaurants, setRestaurants] = useState<Restaurant[]>([]);
  const fetchRestaurantByCriteriaImpl = FetchRestaurantsByCriteriaFactory();
  const [isLoading, setIsLoading] = useState(false);
  const [hasError, setHasError] = useState(false);

  const fetchRestaurantsByCriteria = async (searchCriteria: SearchCriteria) => {
    setIsLoading(true);


    try {
      const restaurants = await fetchRestaurantByCriteriaImpl.invoke({
        url: 'http://localhost:8888/api/fetchRestaurants',
        body: searchCriteria
      });

      setTimeout(() => setIsLoading(false), 2000);
      setRestaurants(restaurants);
    } catch (error) {
      setTimeout(() => setIsLoading(false), 2000);
      setHasError(true);
    } finally {
      setTimeout(() => setIsLoading(false), 2000);
    }
  }

  const newSearch = () => setRestaurants([]);

  return {
    restaurants,
    fetchRestaurantsByCriteria,
    hasError,
    isLoading,
    newSearch
  }
}
