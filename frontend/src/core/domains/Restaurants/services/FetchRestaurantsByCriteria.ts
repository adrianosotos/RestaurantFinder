import { HttpClient } from "../../../ports/HttpService";
import { RequestParams } from "../../../utils/RequestParams";
import { UseCase } from "../../../utils/UseCase";
import { SearchCriteria } from "../../SearchCriteria/SearchCriteria";
import { Restaurant } from "../Restaurants";

export class FetchRestaurantsByCriteria implements UseCase<RequestParams<SearchCriteria>, Restaurant[]> {
  constructor(private httpService: HttpClient) {}

  async invoke(input: RequestParams<SearchCriteria>) {
    try {
      const response = await this.httpService.request({ method: 'post', url: input.url, body: input.body })
      return response.body;
    } catch (error) {
      throw new Error('failed to load restaurants');
    }
  }
}
