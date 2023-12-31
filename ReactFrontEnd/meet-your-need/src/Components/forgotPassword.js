import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Alert } from 'reactstrap';



function ForgotPassword() {

    const [email, setEmail] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [validate, setValidate] = useState('');
    const [user, setUser] = useState(0);
    const navigate = useNavigate();
    const handleSubmit = (event) => {
        if (!email) {
            setErrorMessage('Please enter your email');
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            setErrorMessage('Please enter a valid email address');
        } else {
            setErrorMessage('');
            var link = 'http://localhost:8080/getbyemail?email=' + email;
            fetch(link)
                .then(response => response.json())
                .then(data => {
                    setUser(data)
                    if (data === null) {
                        console.log("user not found");
                        setErrorMessage('user not found');
                    }
                    else {
                        console.log(data.firstName);
                        console.log(data.lastName);
                        setValidate("Do you want to change password for " + data.firstName + " " + data.lastName+" ?");
                        console.log(validate);
                    }
                    localStorage.setItem('passwordChange', JSON.stringify(data));
                })
                .catch(error => console.log(error));

        }
    }
    return (
        <div className="form-group d-flex flex-column align-items-center">
            <label htmlFor="email" className="mb-3">Enter your email:</label>
            <input
                type="email"
                className="form-control mb-3"
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                style={{ width: '300px' }}
            />
            <button
                type="button"
                className="btn btn-primary"
                style={{ width: '150px' }}
                onClick={handleSubmit}
            >
                Change Password
            </button>
            <br />
            {errorMessage && <Alert color="danger">{errorMessage}</Alert>}
            <Alert color='alert'>
                {validate}
            </Alert>
            </div>
    );
}

export default ForgotPassword;
