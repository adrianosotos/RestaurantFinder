import { FetchRestaurantsByCriteria } from './FetchRestaurantsByCriteria';
import { HttpClient } from "../../../ports/HttpService";
import { SearchCriteria } from '../../SearchCriteria/SearchCriteria';

jest.mock('../../../ports/HttpService');

describe('FetchRestaurantsByCriteria', () => {
  it('fetches restaurants by criteria successfully', async () => {
    const mockHttpService = jest.mocked({ request: jest.fn(() => Promise.resolve({
      statusCode: 200,
      body: {}
    }))} as HttpClient);
    const mockResponse = {
      body: [
        { id: 1, name: 'Restaurant A' },
        { id: 2, name: 'Restaurant B' },
      ],
      statusCode: 200
    };

    mockHttpService.request.mockResolvedValue(mockResponse);

    const searchCriteria = { cuisine: 'Italian' } as SearchCriteria;
    const url = '/api/restaurants/search';
    const useCase = new FetchRestaurantsByCriteria(mockHttpService);

    const restaurants = await useCase.invoke({ url, body: searchCriteria });

    expect(restaurants).toEqual(mockResponse.body);
    expect(mockHttpService.request).toHaveBeenCalledWith({
      method: 'post',
      url,
      body: searchCriteria,
    });
  });
});
