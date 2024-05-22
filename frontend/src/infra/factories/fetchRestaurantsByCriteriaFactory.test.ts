import { FetchRestaurantsByCriteria } from "../../core/domains/Restaurants/services/FetchRestaurantsByCriteria";
import { AxiosHttpClient } from "../http/AxiosClient";
import { FetchRestaurantsByCriteriaFactory } from "./fetchRestaurantsByCriteiraFactory";

jest.mock("../http/AxiosClient", () => {
  return {
    AxiosHttpClient: jest.fn().mockResolvedValue('')
  };
});

describe("FetchRestaurantsByCriteriaFactory", () => {
  test("should return an instance of FetchRestaurantsByCriteria", () => {
    const expectedInstance = new FetchRestaurantsByCriteria(new AxiosHttpClient());

    const factoryResult = FetchRestaurantsByCriteriaFactory();

    expect(factoryResult).toBeInstanceOf(FetchRestaurantsByCriteria);
    expect(factoryResult.invoke).toEqual(expectedInstance.invoke);
  });
});
