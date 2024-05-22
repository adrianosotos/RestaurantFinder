import React from "react";
import { useRestaurantFinderController } from "./controller/useRestaurantFinderController";
import SearchCriteriaForm from "./components/SearchCriteriaForm/SearchCriteriaForm";
import { Container } from "react-bootstrap";
import RestaurantTable from "./components/RestaurantTable/RestaurantTable";
import AsyncWrapper from "../../components/AsyncWrapper/AsyncWrapper";

function RestaurantFinder(): React.JSX.Element {
  const {
    fetchRestaurantsByCriteria,
    restaurants,
    hasError,
    isLoading,
    newSearch,
  } = useRestaurantFinderController();

  const getError = () => {
    return {
      hasError,
      message: "Failed to fetch restaurants",
    };
  };

  return (
    <Container className="w-100">
      <h1 className="text-center mt-4 mb-3">Find Restaurants</h1>
      <AsyncWrapper error={getError()} isLoading={isLoading}>
        {!restaurants.length ? (
          <SearchCriteriaForm fetchRestaurants={fetchRestaurantsByCriteria} />
        ) : (
          <RestaurantTable
            newSearch={newSearch}
            restaurants={restaurants}
          ></RestaurantTable>
        )}
      </AsyncWrapper>
    </Container>
  );
}

export default RestaurantFinder;
