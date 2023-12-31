import React from "react";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { Link } from "@mui/material";

function Thanks() {
  return (
    <div>
      <Container maxWidth="sm">
        <Typography variant="h4" align="center" gutterBottom>
          Thank you for your payment!
        </Typography>
        <Typography variant="subtitle1" align="center">
          Your payment has been successfully submitted.
        </Typography>
      </Container>
      <Link href="/client" underline="hover">
        Go back to home
      </Link>
    </div>
  );
}

export default Thanks;
