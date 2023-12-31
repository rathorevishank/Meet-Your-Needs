
import { Link } from "react-router-dom";
import { Container, Row, Col, Button } from "react-bootstrap";
import { useReducer, useEffect } from "react";
import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';

export default function VendorRegistration() {
    const [answer, setAnswer] = useState('');
    const navigate = useNavigate();
    const [questions, setQuestions] = useState([])
    const [user, setUser] = useState({})

    const [statevalue, setStateValue] = useState(0);
    const handleStateIdChange = (event) => {
        setStateValue(event.target.value);
    }
    const [city, setCity] = useState([])
    const [states, setstate] = useState([])
    const getCities = (id) => {
        fetch("http://localhost:8080/getcitybystate?state=" + id)
            .then(response => response.json())
            .then(data => { setCity(data); })


    }



    useEffect(() => {
        fetch("http://localhost:8080/allState")
            .then(response => response.json())
            .then(data => { setstate(data); })

        fetch("http://localhost:8080/allQuestions")
            .then(response => response.json())
            .then(data => { setQuestions(data); })
    }, []
    )

    const init = {

        fname: { value: "", hasError: true, touched: false, error: "" },
        lname: { value: "", hasError: true, touched: false, error: "" },
        phone: { value: "", hasError: true, touched: false, error: "" },
        address: { value: "", hasError: true, touched: false, error: "" },
        city: { value: "", hasError: false, touched: false, error: "" },
        bday: { value: "", hasError: true, touched: false, error: "" },
        password: { value: "", hasError: true, touched: false, error: "" },
        cpassword: { value: "", hasError: true, touched: false, error: "" },
        email1: { value: "", hasError: true, touched: false, error: "" },
        pincode: { value: "", hasError: true, touched: false, error: "" },
        state1: { value: "", hasError: false, touched: false, error: "" },
        nationality: { value: "", hasError: true, touched: false, error: "" },
        security: { value: "", hasError: false, touched: false, error: "" },
        isFormValid: false
    }

    const reducer = (state, action) => {
        //console.log(state);
        switch (action.type) {
            case 'update': {
                const { name, value, hasError, error, touched, isFormValid } = action.data;
                return {
                    ...state,
                    [name]: { ...state[name], value, hasError, error, touched },
                    isFormValid
                }   //modifying and returning new object as state
            }

            case 'reset': {
                return init;
            }

        }
    }


    const handleChange = (name, value) => {
        const { hasError, error } = validate(name, value);
        let isFormValid = true;
        //check isFormValid
        for (let key in state) {
            if (state[key].hasError === true) {
                isFormValid = false;
                break;
            }
        }

        dispatch({ type: 'update', data: { name, value, hasError, error, touched: true, isFormValid } })
    }


    const validate = (name, value) => {
        let hasError = false;
        let error = "";
        switch (name) {

            case 'fname':
                var re1 = /^[A-Z][a-z]{2,15}$/;
                if (!re1.test(value)) {
                    hasError = true;
                    error = "First letter - capital, rest -small"
                }
                break;
            case 'lname':
                {
                    var re2 = /^[A-Z][a-z]{2,15}$/;
                    if (!re2.test(value)) {
                        hasError = true;
                        error = "First letter - capital, rest -small"
                    }
                    break;
                }
            case 'phone':
                {
                    var phone = /^\d{10}$/;
                    if (!phone.test(value)) {
                        hasError = true;
                        error = "Invalid Phone Number"
                    }
                    break;
                }
            case 'email1':
                {
                    if (!/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(value)) {
                        hasError = true;
                        error = "Enter Valid Email Address"
                    }
                    break;
                }

            case 'password':
                {
                    if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/.test(value)) {
                        hasError = true;
                         error = "Should Start with Capital Alphabet, Contain Characters And Numbers";
                    }
                }
                break;
            case 'cpassword':
                {
                    const password = document.getElementById("password").value;
                    if (password !== value) {
                        hasError = true;
                        error = "Password is not matched"
                    }
                }
                break;


            case 'sal':
                break;
            case 'dept':
                break;

        }
        return { hasError, error }
    }


    const sendData = (e) => {
        console.log(document.getElementById('stat').value);
        e.preventDefault();
        
        const reqOption = {
            method: "post",
            headers: { 'content-type': 'application/json' },
            body: JSON.stringify({ firstName: state.fname.value, lastName: state.lname.value, email: state.email1.value, stateId: document.getElementById('stat').value, birthdate: state.bday.value, password: state.password.value, phoneNo: state.phone.value, nationality: state.nationality.value, cityId: Number(document.getElementById("city").value), address: state.address.value, answer: document.getElementById("answer").value, questionId: Number(document.getElementById("que").value), role:2 })
        }
        fetch("http://localhost:8080/adduser", reqOption)
            .then(response => response.json())
            .then(data => { setUser(data); console.log(user.userId); })


        const vendorOption = {
            method: "post",
            headers: { 'content-type': 'application/json' },
            body: JSON.stringify({ userid: Number(user.userId)})
        }


        fetch("http://localhost:8080/addVendor", vendorOption)
            .then(response => {
                if (response.ok) {
                    console.log("requset sent");

                    navigate("/PortfolioForm");
                }
                else
                    throw new Error("server error");
            })

    }

    const handleFormSubmit = (event) => {
        event.preventDefault();

    };

    const [state, dispatch] = useReducer(reducer, init);

    return (
        <div class="container-fluid">

            <h2> Vendor Registration </h2>
            <form className="form-control" onSubmit={handleFormSubmit}>

                <br />

                <div class="ms-5">

                    Enter first name:
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="fname"
                        value={state.fname.value}
                        onChange={(e) => { handleChange("fname", e.target.value) }} />
                    <p style={{ display: state.fname.touched && state.fname.hasError ? "block" : "none", color: "red" }}> {state.fname.error} </p>
                </div> <br />
                <div class="ms-5">

                    Enter last name :
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="lname"
                        value={state.lname.value}
                        onChange={(e) => { handleChange("lname", e.target.value) }} />
                    <p style={{ display: state.lname.touched && state.lname.hasError ? "block" : "none", color: "red" }}> {state.lname.error} </p>
                </div><br />
                <div class="ms-5">

                    Enter Your Email Id :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                    <input type="email" name="email1"
                        value={state.email1.value}
                        onChange={(e) => { handleChange("email1", e.target.value) }} />
                    <p style={{ display: state.email1.touched && state.email1.hasError ? "block" : "none", color: "red" }}> {state.email1.error} </p>
                </div> <br />
                <div class="ms-5">
                    Enter Your BirthDate : &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="date" name="bday"
                        value={state.bday.value}
                        onChange={(e) => { handleChange("bday", e.target.value) }} />
                    <p style={{ display: state.bday.touched && state.bday.hasError ? "block" : "none", color: "red" }}> {state.bday.error} </p>
                </div> <br />     <div class="ms-5">
                    Enter Your Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="password" name="password" id="password"
                        value={state.password.value}
                        onChange={(e) => { handleChange("password", e.target.value) }} />
                    <p style={{ display: state.password.touched && state.password.hasError ? "block" : "none", color: "red" }}> {state.password.error} </p>
                </div>  <br />    <div class="ms-5">
                    Enter Confirm Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="password" name="cpassword"
                        value={state.cpassword.value}
                        onChange={(e) => { handleChange("cpassword", e.target.value) }} />
                    <p style={{ display: state.cpassword.touched && state.cpassword.hasError ? "block" : "none", color: "red" }}> {state.cpassword.error} </p>
                </div> <br />     <div class="ms-5">
                    Enter phone number :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="phone"
                        value={state.phone.value}
                        onChange={(e) => { handleChange("phone", e.target.value) }} />
                    <p style={{ display: state.phone.touched && state.phone.hasError ? "block" : "none", color: "red" }}> {state.phone.error} </p>
                </div>   <br />
                <div class="ms-5">
                    Enter Your Nationality :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="nationality"
                        value={state.nationality.value}
                        onChange={(e) => { handleChange("nationality", e.target.value) }} />
                    <p style={{ display: state.nationality.touched && state.nationality.hasError ? "block" : "none", color: "red" }}> {state.nationality.error} </p>
                </div><br />


                <div class="ms-5">
                    Enter Your State :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label htmlFor="state">
                        <select id="stat" onChange={(e) => { getCities(e.target.value); handleChange("stateid", e.target.value) }}>
                            {states.map((states) => (

                                <option key={states.stateId} value={states.stateId}>
                                    {states.stateName}
                                </option>
                            ))}
                        </select>
                    </label>
                </div><br />
                <div class="ms-5">
                    Enter Your City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label htmlFor="city">
                        <select name="city" value={state.city.value} id="city"
                            onChange={(e) => { handleChange("city", e.target.value) }}>
                            {city.map((city) => (

                                <option key={city.cityId} value={city.cityId}>
                                    {city.cityName}
                                </option>
                            ))}
                        </select>
                    </label>
                </div> <br />
                <div class="ms-5">
                    Enter Pincode :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="number" name="pincode"
                        value={state.pincode.value}
                        onChange={(e) => { handleChange("pincode", e.target.value) }} />
                    <p style={{ display: state.pincode.touched && state.pincode.hasError ? "block" : "none", color: "red" }}> {state.pincode.error} </p>
                </div>   <br />
                <div class="ms-5">
                    Enter Your Address :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="address"
                        value={state.address.value}
                        onChange={(e) => { handleChange("address", e.target.value) }} />
                    <p style={{ display: state.address.touched && state.address.hasError ? "block" : "none", color: "red" }}> {state.address.error} </p>
                </div> <br />
                <div class="ms-5">
                    Enter Your Security Question :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label htmlFor="questions">
                        <select name="questions" id="que"
                            onChange={(e) => { handleChange("questions", e.target.value) }}>
                            {questions.map((question) => (
                                <option key={question.qid} value={question.qid}>
                                    {question.questionText}
                                </option>
                            ))}
                        </select>
                    </label>
                    <input type="text" name="answer" id="answer" placeholder="Your Answer" onChange={(event) => setAnswer(event.target.value)} />

                    <p style={{ display: state.security.touched && state.security.hasError ? "block" : "none", color: "red" }}> {state.security.error} </p>
                    <br />
                    <br />

                    <input type="submit" value="Register" disabled={state.isFormValid ? false : true} onClick={sendData}
                    />  &nbsp; &nbsp;
                    <input type="reset" value="Clear"
                        onClick={() => { dispatch({ type: 'reset' }) }} />

                </div>
                <br />  <br />

            </form>
            <br />
            {
                // JSON.stringify(state)
            }
        </div>)
}