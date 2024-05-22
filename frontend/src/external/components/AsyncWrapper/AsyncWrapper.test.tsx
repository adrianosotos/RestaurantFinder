import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import AsyncWrapper from './AsyncWrapper';

test('renders Spinner when isLoading is true', () => {
  render(<AsyncWrapper isLoading={true} error={{ hasError: false, message: '' }}>Test Child</AsyncWrapper>);

  expect(screen.getByRole('status')).toBeInTheDocument();
});

test('renders Alert when error hasError is true', () => {
  render(<AsyncWrapper isLoading={false} error={{ hasError: true, message: 'Error message' }}>Test Child</AsyncWrapper>);

  expect(screen.getByRole('alert')).toHaveTextContent('Error message');
});

test('renders children when isLoading is false and hasError is false', () => {
  render(<AsyncWrapper isLoading={false} error={{ hasError: false, message: '' }}>Test Child</AsyncWrapper>);

  expect(screen.getByText('Test Child')).toBeInTheDocument();
});
