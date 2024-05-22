import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import RestaurantTable from './RestaurantTable';
import { Restaurant } from '../../../../../core/domains/Restaurants/Restaurants';

const mockRestaurants: Restaurant[] = [
  { name: 'Restaurant A', rating: 4.5, distance: 2.0, averagePrice: 20, cuisine: 'Italian' },
  { name: 'Restaurant B', rating: 4, distance: 5.0, averagePrice: 15, cuisine: 'Mexican' },
];

test('renders the table with restaurants data', () => {
  render(<RestaurantTable restaurants={mockRestaurants} newSearch={jest.fn()} />);

  expect(screen.getByText('Name')).toBeInTheDocument();
  expect(screen.getByText('Rating')).toBeInTheDocument();
  expect(screen.getByText('Distance')).toBeInTheDocument();
  expect(screen.getByText('Average Price')).toBeInTheDocument();
  expect(screen.getByText('Cuisine')).toBeInTheDocument();

  expect(screen.getByText('Restaurant A')).toBeInTheDocument();
  expect(screen.getByText((content, element) => {
    return element?.tagName.toLowerCase() === 'td' && content === '4.5';
  })).toBeInTheDocument();

  expect(screen.getByText((content, element) => {
    return element?.tagName.toLowerCase() === 'td' && content === '2 km';
  })).toBeInTheDocument();
  expect(screen.getByText((content, element) => {
    return element?.tagName.toLowerCase() === 'td' && content === '$20';
  })).toBeInTheDocument();
  expect(screen.getByText('Italian')).toBeInTheDocument();

  expect(screen.getByText('Restaurant B')).toBeInTheDocument();
  expect(screen.getByText((content, element) => {
    return element?.tagName.toLowerCase() === 'td' && content === '4';
  })).toBeInTheDocument();
  expect(screen.getByText((content, element) => {
    return element?.tagName.toLowerCase() === 'td' && content === '5 km';
  })).toBeInTheDocument();
  expect(screen.getByText((content, element) => {
    return element?.tagName.toLowerCase() === 'td' && content === '$15';
  })).toBeInTheDocument();
  expect(screen.getByText('Mexican')).toBeInTheDocument();
});

test('calls newSearch when the button is clicked', () => {
  const newSearchMock = jest.fn();
  render(<RestaurantTable restaurants={mockRestaurants} newSearch={newSearchMock} />);

  const button = screen.getByText('New Search');
  fireEvent.click(button);

  expect(newSearchMock).toHaveBeenCalledTimes(1);
});
