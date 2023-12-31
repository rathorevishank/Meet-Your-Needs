import React, { useState } from 'react';
import { MDBContainer, MDBCol, MDBRow, MDBInput } from 'mdb-react-ui-kit';
import { Alert } from 'reactstrap';
import { useNavigate } from 'react-router-dom';
import '../index.css';
function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [user, setUser] = useState('');
    const navigate = useNavigate();

    const handleSubmit = (event) => {
        if (!email || !password) {
            setErrorMessage('Please enter your email and password');
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            setErrorMessage('Please enter a valid email address');
        } else {
            setErrorMessage('');
            var link = 'http://localhost:8080/checkuser?mail=' + email + '&password=' + password;
            fetch(link)
                .then(response => response.json())
                .then(data => {
                    setUser(data);
                    console.log(data);
                    var role = null;
                    if (data.role != null) {
                        role = data.role.roleId;
                    }
                    if (role === 1) {
                        navigate('/admin');
                    }
                    else if (role === 2) {
                        fetch("http://localhost:8080/getVendorByUser?id=" + data.userId)
                            .then(response => response.json())
                            .then(data => {
                                localStorage.setItem("userdata", JSON.stringify(data))
                            })
                        navigate('/vendor');
                    }
                    else if (role === 3) {
                        fetch("http://localhost:8080/getUser?id=" + data.userId)
                            .then(response => response.json())
                            .then(data => {
                                localStorage.setItem("userdata", JSON.stringify(data))
                            })
                        navigate('/client');
                    }
                    else {
                        console.log("user not found");
                        setErrorMessage('Invalid email or password');
                    }
                    localStorage.setItem('user', JSON.stringify(data));
                })
                .catch(error => console.log(error));

        }
    }
    return (
        <MDBContainer fluid className="p-3 my-5 h-custom">
            <MDBRow>

                <MDBCol col='10' md='6'>
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" class="img-fluid" alt="Sample" />
                </MDBCol>

                <MDBCol col='4' md='6'>

                    <div className="divider d-flex align-items-center my-4">
                    </div>
                    <form>
                        <MDBInput wrapperClass='mb-4' label='Email address' id="email" type='email' size="lg" value={email} onChange={(e) => setEmail(e.target.value)} />
                        <MDBInput wrapperClass='mb-4' label='Password' id="password" value={password} onChange={(e) => setPassword(e.target.value)} type='password' size="lg" />
                        {errorMessage && <Alert color="danger">{errorMessage}</Alert>}
                        <div className="d-flex justify-content-between mb-4">
                            <a href="/password">Forgot password?</a>
                        </div>

                        <div className='text-center text-md-start mt-4 pt-2'>
                            <button type="button" class="btn btn-primary btn-md" onClick={handleSubmit}>Login</button>
                            <p className="small fw-bold mt-2 pt-1 mb-2">Don't have an account? <a href="/register" className="link-danger">Register</a></p>
                        </div>
                    </form>

                </MDBCol>

            </MDBRow>

        </MDBContainer>
    );
}

export default Login;