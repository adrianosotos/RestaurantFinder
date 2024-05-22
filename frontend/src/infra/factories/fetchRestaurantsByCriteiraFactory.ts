import { FetchRestaurantsByCriteria } from "../../core/domains/Restaurants/services/FetchRestaurantsByCriteria";
import { AxiosHttpClient } from "../http/AxiosClient";

export function FetchRestaurantsByCriteriaFactory() {
  return new FetchRestaurantsByCriteria(new AxiosHttpClient());
}
