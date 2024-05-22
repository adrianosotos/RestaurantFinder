import { render, screen, fireEvent, waitFor, act } from '@testing-library/react';
import { useRestaurantFinderController } from './useRestaurantFinderController';
import { SearchCriteria } from '../../../../core/domains/SearchCriteria/SearchCriteria';
import { FetchRestaurantsByCriteria } from '../../../../core/domains/Restaurants/services/FetchRestaurantsByCriteria';

const TestComponent = () => {
  const { restaurants, fetchRestaurantsByCriteria, hasError, isLoading, newSearch } = useRestaurantFinderController();

  return (
    <div>
      <button onClick={() => fetchRestaurantsByCriteria({} as SearchCriteria)}>Fetch Restaurants</button>
      <button onClick={newSearch}>New Search</button>
      <div data-testid="isLoading">{isLoading ? 'Loading...' : 'Not Loading'}</div>
      <div data-testid="hasError">{hasError ? 'Error' : 'No Error'}</div>
      <div data-testid="restaurants">
        {restaurants?.map((restaurant, i) => (
          <div key={i}>{restaurant.name}</div>
        ))}
      </div>
    </div>
  );
};

describe('useRestaurantFinderController', () => {
  it('should fetch restaurants by criteria', async () => {
    jest.spyOn(FetchRestaurantsByCriteria.prototype, 'invoke').mockImplementation(async () => [{ name: 'Test Restaurant' }])

    render(<TestComponent />);

    fireEvent.click(screen.getByText('Fetch Restaurants'));

    expect(screen.getByTestId('isLoading')).toHaveTextContent('Loading...');

    await waitFor(() => expect(screen.getByTestId('isLoading')).toHaveTextContent('Not Loading'), { timeout: 5000 });
    await waitFor(() => expect(screen.getByTestId('restaurants')).toHaveTextContent('Test Restaurant'), { timeout: 5000 });

    expect(screen.getByTestId('hasError')).toHaveTextContent('No Error');
  });

  it('should handle errors during fetch', async () => {
    jest.spyOn(FetchRestaurantsByCriteria.prototype, 'invoke').mockRejectedValueOnce(new Error('Fetch error'));

    render(<TestComponent />);

    fireEvent.click(screen.getByText('Fetch Restaurants'));

    expect(screen.getByTestId('isLoading')).toHaveTextContent('Loading...');

    await waitFor(() => expect(screen.getByTestId('isLoading')).toHaveTextContent('Not Loading'), { timeout: 5000 });
    await waitFor(() => expect(screen.getByTestId('hasError')).toHaveTextContent('Error'), { timeout: 5000 });
  });

  it('should reset restaurants on new search', () => {
    render(<TestComponent />);

    fireEvent.click(screen.getByText('New Search'));

    expect(screen.getByTestId('restaurants')).toBeEmptyDOMElement();
  });
});
