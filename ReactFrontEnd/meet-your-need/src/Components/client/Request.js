import React, { useState } from 'react';
import { useEffect } from 'react';
import { ButtonGroup, Button, FormControl, colors } from '@mui/material';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import Slider from '@mui/material/Slider';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import { useNavigate } from 'react-router-dom';
import Alert from '@mui/material/Alert';

const RequestForm = () => {
    const [category, setCategory] = useState(0);
    const [budget, setBudget] = useState(0);
    const [description, setDescription] = useState('');
    const [title, setTitle] = useState('');
    const [deadline, setDeadline] = useState({});
    const [categories, setCategories] = useState([]);
    useEffect(() => {
        fetch("http://localhost:8080/allCategory")
            .then(response => response.json())
            .then(data => { setCategories(data); })
    }, []);

    const navigate = useNavigate();
    const handleCategoryChange = (event) => {
        setCategory(event.target.value);
    };

    const handleBudgetChange = (event) => {
        setBudget(event.target.value);
    };

    const handleDescriptionChange = (event) => {
        setDescription(event.target.value);
    };

    const handleDeadlineChange = (event) => {
        setDeadline(event.target.value);
    };

    const handleTitleChange = (event) => {
        setTitle(event.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(category);
        const user = JSON.parse(localStorage.getItem('user'));
        const reqOption = {
            method: "post",
            headers: { 'content-type': 'application/json' },
            body: JSON.stringify({ client: user.userId, category: category, rdate: new Date(), budget: budget, pid: document.getElementById("description").value, title: title, deadline:deadline})
        }
        fetch("http://localhost:8080/addReq", reqOption)
            .then(resp => {
                if (resp.ok) {
                    console.log("requset sent");
                    document.getElementById("sucess").style.display = "block";
                }
                else
                    throw new Error("server error");
            })
            .catch((error) => { alert("server error,try after some time") });
    };

    return (
        <div style={{ margin: '50px auto', width: '50%' }}>

            <Card sx={{ minWidth: 275, backgroundColor: '#1D1D1' }}>
                <CardContent>
                    <h1 >Post New Requirment</h1>
                    <hr />
                    <label style={{ marginTop: '20px' }}>
                            <TextField
                                id="title"
                                label="Title"
                                multiline
                                onChange={handleTitleChange}
                            />
                        </label>
                    <br />
                    <br />
                    <FormControl onSubmit={handleSubmit}>

                        

                        <InputLabel id="demo-simple-select-standard-label">Category</InputLabel>
                        <Select
                            labelId="demo-simple-select-standard-label"
                            id="category"
                            value={category}
                            onChange={handleCategoryChange}
                            label="Category"
                        >
                            <MenuItem value="">
                                <em>None</em>
                            </MenuItem>
                            {categories.map((cat) => (
                                <MenuItem key={cat.category_id} value={cat.category_id}>
                                    {cat.category_name}
                                </MenuItem>
                            ))}
                        </Select>
                        <br />
                        <label style={{ marginTop: '20px' }}>
                            Budget: {budget}
                            <Slider
                                aria-label="Small steps"
                                defaultValue={5000}
                                step={100}
                                marks
                                min={500}
                                max={20000}
                                valueLabelDisplay="auto"
                                onChange={handleBudgetChange}
                                id="budget"
                                inline
                            />
                        </label>

                        <br />
                        <br />
                        <br />
                        <br />
                        Deadline
                        <input type={'date'} onChange={handleDeadlineChange}></input>
                        <label style={{ marginTop: '20px' }}>
                            <TextField
                                id="description"
                                label="Requirments"
                                multiline
                                onChange={handleDescriptionChange}
                            />
                        </label>
                        <br />
                        <div className="form-group" style={{ marginTop: '20px' }}>
                            <ButtonGroup variant="contained" aria-label="outlined primary button group">
                                <Button type="submit" onClick={handleSubmit}>Post</Button>
                            </ButtonGroup>
                        </div>
                    </FormControl>
                </CardContent>
                <br />
                <Alert severity="success" style={{ display: 'none' }} id="sucess">Requirment Posted</Alert>
            </Card>
        </div>
    );
};

export default RequestForm;
