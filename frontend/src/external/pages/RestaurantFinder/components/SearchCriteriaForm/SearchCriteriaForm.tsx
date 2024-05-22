import React, { useState } from "react";
import { Form, Button, Col, Row, Container, Card } from "react-bootstrap";
import { SearchCriteria } from "../../../../../core/domains/SearchCriteria/SearchCriteria";

interface Props {
  fetchRestaurants: (searchCriteria: SearchCriteria) => Promise<void>
}

function SearchCriteriaForm({ fetchRestaurants }: Props): React.JSX.Element {
  const [formData, setFormData] = useState({
    name: "",
    price: 0,
    distance: 0,
    customerRating: 0,
    cuisine: ""
  });

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    const parsedValue = name !== 'name' && name !== 'cuisine' ? Number(value) : value;
    setFormData({ ...formData, [name]: parsedValue });
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();

    try {
      fetchRestaurants(formData);
    } catch(e) {
      throw new Error('failed to fetch restaurants');
    }
  };

  return (
    <Container className="d-flex justify-content-center align-items-cente mt-5">
      <Card style={{ width: "50%" }}>
        <Card.Body>
          <Form onSubmit={handleSubmit}>
            <Form.Group as={Row} controlId="formGridName" className="mb-3">
              <Form.Label column sm={4}>
                Name
              </Form.Label>
              <Col sm={8}>
                <Form.Control
                  type="text"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                />
              </Col>
            </Form.Group>

            <Form.Group as={Row} controlId="formGridRating" className="mb-3">
              <Form.Label column sm={4}>
                Rating (1 - 5)
              </Form.Label>
              <Col sm={8}>
                <Form.Control
                  type="number"
                  name="rating"
                  value={formData.customerRating}
                  onChange={handleChange}
                  min="0"
                  max="5"
                />
              </Col>
            </Form.Group>

            <Form.Group as={Row} controlId="formGridDistance" className="mb-3">
              <Form.Label column sm={4}>
                Distance
              </Form.Label>
              <Col sm={8}>
                <Form.Control
                  type="number"
                  name="distance"
                  value={formData.distance}
                  onChange={handleChange}
                  min="0"
                />
              </Col>
            </Form.Group>

            <Form.Group as={Row} controlId="formGridPrice" className="mb-3">
              <Form.Label column sm={4}>
                Average Price
              </Form.Label>
              <Col sm={8}>
                <Form.Control
                  type="number"
                  name="price"
                  value={formData.price}
                  onChange={handleChange}
                  min="0"
                />
              </Col>
            </Form.Group>

            <Form.Group as={Row} controlId="formGridCuisine" className="mb-3">
              <Form.Label column sm={4}>
                Cuisine
              </Form.Label>
              <Col sm={8}>
                <Form.Control
                  type="text"
                  name="cuisine"
                  value={formData.cuisine}
                  onChange={handleChange}
                />
              </Col>
            </Form.Group>

            <div className="d-flex justify-content-center">
              <Button variant="primary" type="submit">
                Search
              </Button>
            </div>
          </Form>
        </Card.Body>
      </Card>
    </Container>
  );
}

export default SearchCriteriaForm;
