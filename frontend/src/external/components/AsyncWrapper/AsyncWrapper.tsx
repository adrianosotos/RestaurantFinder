import React, { ReactNode } from "react";
import { Alert, Container, Spinner } from "react-bootstrap";

interface Props {
  isLoading: boolean;
  error: { hasError: boolean; message: string };
  children: ReactNode;
}

function AsyncWrapper({
  children,
  error,
  isLoading,
}: Props): React.JSX.Element {
  if (isLoading) {
    return (
      <Container className="d-flex justify-content-center align-items-center mt-5">
        <Spinner role="status" className="mt-5" animation="border" />
      </Container>
    );
  } else if (error.hasError) {
    return (
      <Container className="d-flex justify-content-center align-items-center mt-5">
        <Alert role="alert" className="mt-5" variant="danger">{error.message}</Alert>
      </Container>
    );
  } else {
    return <>{children}</>;
  }
}

export default AsyncWrapper;
