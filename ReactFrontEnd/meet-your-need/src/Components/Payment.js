import React, { useState, useEffect } from "react";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { useNavigate } from 'react-router-dom';

function PaymentForm() {
  const navigate = useNavigate();
  const [project, setProject] = ([])
  const price = localStorage.getItem("cost");
  const [payment, setPayment] = useState({
    payment_id: "",
    payment_detail: "",
    date: "",
    transaction_id: "",
    mode_of_payment: "",
    final_payment: "",
    initial_payment: "",
  });
  

  useEffect(() => {
    console.log(payment);
    
  }, [payment]);

  const handleSubmit = (e) => {
    e.preventDefault();
    const projectid = localStorage.getItem('projectid');
    fetch("http://localhost:8080/addPayment", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({finalPayment : payment.final_payment, mode : payment.mode_of_payment, date : new Date(), project : projectid, paymentdetail:payment.payment_detail}),
    })
      .then((response) => {
        if (response.ok) {
          console.log("added");
          navigate("/thanks");

        }
        else{
         
            throw new Error("server error");
        }
      })
      .then((data) => console.log(data))
      .catch((error) => { alert("server error,try after some time") });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPayment((prevState) => ({ ...prevState, [name]: value }));
  };

  return (
    <form 
  style={{
    display: "flex",
    flexDirection: "column",
    maxWidth: "500px",
    margin: "auto",
    marginTop: "16px",
    padding: "16px",
    border: "1px solid #ccc",
    borderRadius: "4px"
  }}
  onSubmit={handleSubmit}
>
  <TextField
    label="Name"
    name="payment_detail"
    value={payment.payment_detail}
    onChange={handleChange}
    style={{ marginBottom: "16px" }}
  />
  
  <label htmlFor="mode-selector" style={{ marginBottom: "8px" }}>Mode of Payment</label>
  <select
    id="mode-selector"
    name="mode_of_payment"
    value={payment.mode_of_payment}
    onChange={handleChange}
    style={{ marginBottom: "16px" }}
  >
    <option value="">Choose a payment mode</option>
    <option value="COD">COD</option>
    <option value="CARD">Card</option>
    <option value="UPI">UPI</option>
    <option value="NETBANKING">Net Banking</option>
  </select>
  
  <TextField
    label="Grand Total"
    name="final_payment"
    value={payment.final_payment}
    onChange={handleChange}
    style={{ marginBottom: "16px" }}
  />
  
  <Button
    variant="contained"
    color="primary"
    type="submit"
  >
    Pay
  </Button>
</form>

  );
}

export default PaymentForm;
