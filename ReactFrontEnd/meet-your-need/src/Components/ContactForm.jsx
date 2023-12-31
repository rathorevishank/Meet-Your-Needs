import React from 'react';
import { useForm, ValidationError } from '@formspree/react';
import { Container, TextField, Button } from '@mui/material';

function ContactForm() {
const [state, handleSubmit] = useForm("xlekllkn");

if (state.succeeded) {
return <p>Thanks for contacting us!</p>;
}

return (
<Container maxWidth="sm">
<form onSubmit={handleSubmit}>
Name : 
<TextField
       fullWidth
       id="name"
       type="text"
       name="name"
       label="Name"
       variant="outlined"
       margin="normal"
     />
<ValidationError
       prefix="name"
       field="name"
       errors={state.errors}
     />
  Email : 
<TextField
       fullWidth
       id="email"
       type="email"
       name="email"
       label="Email Address"
       variant="outlined"
       margin="normal"
     />
<ValidationError
       prefix="Email"
       field="email"
       errors={state.errors}
     />
Message : 
    <TextField
      fullWidth
      id="message"
      name="message"
      label="Message"
      variant="outlined"
      margin="normal"
      multiline
      rows={4}
    />
    <ValidationError
      prefix="Message"
      field="message"
      errors={state.errors}
    />

    <Button
      type="submit"
      variant="contained"
      color="primary"
      disabled={state.submitting}
    >
      Submit
    </Button>
  </form>
</Container>
);
}

function Contact() {
return (
<ContactForm />
);
}

export default Contact;