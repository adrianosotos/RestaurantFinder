import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import RestaurantFinder from './RestaurantFinder';
import { useRestaurantFinderController } from './controller/useRestaurantFinderController';

jest.mock('./controller/useRestaurantFinderController', () => ({
  __esModule: true,
  useRestaurantFinderController: jest.fn(),
}));

describe('RestaurantFinder', () => {
  test('renders loading state correctly', () => {
    (useRestaurantFinderController as any).mockReturnValueOnce({
      fetchRestaurantsByCriteria: jest.fn(),
      restaurants: [],
      hasError: false,
      isLoading: true,
      newSearch: jest.fn(),
    });

    render(<RestaurantFinder />);

    expect(screen.getByText(/Find Restaurants/i)).toBeInTheDocument();
    expect(screen.getByRole('status')).toBeInTheDocument();
    expect(screen.queryByText('Failed to fetch restaurants')).not.toBeInTheDocument();
  });

  test('renders error state correctly', () => {
    (useRestaurantFinderController as any).mockReturnValueOnce({
      fetchRestaurantsByCriteria: jest.fn(),
      restaurants: [],
      hasError: true,
      isLoading: false,
      newSearch: jest.fn(),
    });

    render(<RestaurantFinder />);

    expect(screen.getByText(/Find Restaurants/i)).toBeInTheDocument();
    expect(screen.getByText('Failed to fetch restaurants')).toBeInTheDocument();
    expect(screen.queryByRole('status')).not.toBeInTheDocument();
  });

  test('renders restaurant table correctly when restaurants are available', () => {
    (useRestaurantFinderController as any).mockReturnValueOnce({
      fetchRestaurantsByCriteria: jest.fn(),
      restaurants: [
        { name: 'Restaurant A', rating: 4.5, distance: 2.0, averagePrice: 20, cuisine: 'Italian' },
        { name: 'Restaurant B', rating: 4.0, distance: 5.0, averagePrice: 15, cuisine: 'Mexican' },
      ],
      hasError: false,
      isLoading: false,
      newSearch: jest.fn(),
    });

    render(<RestaurantFinder />);

    expect(screen.getByText(/Find Restaurants/i)).toBeInTheDocument();
    expect(screen.queryByRole('status')).not.toBeInTheDocument();
    expect(screen.queryByText('Failed to fetch restaurants')).not.toBeInTheDocument();
    expect(screen.getByText('Restaurant A')).toBeInTheDocument();
    expect(screen.getByText('Italian')).toBeInTheDocument();
    expect(screen.getByText('Restaurant B')).toBeInTheDocument();
    expect(screen.getByText('Mexican')).toBeInTheDocument();
  });
});
