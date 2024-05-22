import React from "react";
import { Table, Button, Container } from "react-bootstrap";
import { Restaurant } from "../../../../../core/domains/Restaurants/Restaurants";

interface Props {
  restaurants: Restaurant[];
  newSearch: () => void;
}

const RestaurantTable: React.FC<Props> = ({ restaurants, newSearch }) => {
  return (
    <Container className="mt-5 d-flex flex-column justify-content-center align-items-center">
      <div className="w-100">
        <Table striped bordered hover responsive>
          <thead>
            <tr>
              <th>Name</th>
              <th>Rating</th>
              <th>Distance</th>
              <th>Average Price</th>
              <th>Cuisine</th>
            </tr>
          </thead>
          <tbody>
            {restaurants.map((restaurant) => (
              <tr key={restaurant.name}>
                <td>{restaurant.name}</td>
                <td>{restaurant.rating}</td>
                <td>{restaurant.distance} km</td>
                <td>${restaurant.averagePrice}</td>
                <td>{restaurant.cuisine}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
      <div className="mt-3">
        <Button onClick={newSearch}>New Search</Button>
      </div>
    </Container>
  );
};

export default RestaurantTable;
