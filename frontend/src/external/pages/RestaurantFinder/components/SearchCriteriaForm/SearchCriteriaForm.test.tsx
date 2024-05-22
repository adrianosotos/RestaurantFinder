import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import SearchCriteriaForm from './SearchCriteriaForm';

const mockFetchRestaurants = jest.fn();

test('renders the form with initial empty values', () => {
  render(<SearchCriteriaForm fetchRestaurants={mockFetchRestaurants} />);

  expect(screen.getByLabelText(/Name/i)).toHaveValue('');
  expect(screen.getByLabelText(/Rating \(1 - 5\)/i)).toHaveValue(0);
  expect(screen.getByLabelText(/Distance/i)).toHaveValue(0);
  expect(screen.getByLabelText(/Average Price/i)).toHaveValue(0);
  expect(screen.getByLabelText(/Cuisine/i)).toHaveValue('');
});

test('handles input changes correctly', () => {
  render(<SearchCriteriaForm fetchRestaurants={mockFetchRestaurants} />);

  fireEvent.change(screen.getByLabelText(/Name/i), { target: { value: 'Test Restaurant', name: 'name' } });
  fireEvent.change(screen.getByLabelText(/Rating \(1 - 5\)/i), { target: { value: '4', name: 'customerRating' } });
  fireEvent.change(screen.getByLabelText(/Distance/i), { target: { value: '10', name: 'distance' } });
  fireEvent.change(screen.getByLabelText(/Average Price/i), { target: { value: '25', name: 'price' } });
  fireEvent.change(screen.getByLabelText(/Cuisine/i), { target: { value: 'Italian', name: 'cuisine' } });

  expect(screen.getByLabelText(/Name/i)).toHaveValue('Test Restaurant');
  expect(screen.getByLabelText(/Rating \(1 - 5\)/i)).toHaveValue(4);
  expect(screen.getByLabelText(/Distance/i)).toHaveValue(10);
  expect(screen.getByLabelText(/Average Price/i)).toHaveValue(25);
  expect(screen.getByLabelText(/Cuisine/i)).toHaveValue('Italian');
});

test('calls fetchRestaurants with the correct data on form submit', () => {
  render(<SearchCriteriaForm fetchRestaurants={mockFetchRestaurants} />);

  fireEvent.change(screen.getByLabelText(/Name/i), { target: { value: 'Test Restaurant', name: 'name' } });
  fireEvent.change(screen.getByLabelText(/Rating \(1 - 5\)/i), { target: { value: '4', name: 'customerRating' } });
  fireEvent.change(screen.getByLabelText(/Distance/i), { target: { value: '10', name: 'distance' } });
  fireEvent.change(screen.getByLabelText(/Average Price/i), { target: { value: '25', name: 'price' } });
  fireEvent.change(screen.getByLabelText(/Cuisine/i), { target: { value: 'Italian', name: 'cuisine' } });

  fireEvent.click(screen.getByText(/Search/i));

  expect(mockFetchRestaurants).toHaveBeenCalledTimes(1);
  expect(mockFetchRestaurants).toHaveBeenCalledWith({
    name: 'Test Restaurant',
    price: 25,
    distance: 10,
    customerRating: 4,
    cuisine: 'Italian'
  });
});
