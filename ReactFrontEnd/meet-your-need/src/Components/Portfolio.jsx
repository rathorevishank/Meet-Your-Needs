import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Form, Button, ToggleButton, ToggleButtonGroup } from 'react-bootstrap';
import { useNavigate } from 'react-router';

const Portfolio = () => {
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('');
  const [selectedSubcategory, setSelectedSubcategory] = useState('');
  const [file, setFile] = useState(null);
  const [about, setAbout] = useState('');
  const [price, setPrice] = useState('');
  const [status, setStatus] = useState(true);
  const [subcategories, setSubcategories] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await fetch("http://localhost:8080/allCategory", { mode: 'cors' });
        const data = await response.json();
        setCategories(data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchCategories();
  }, []);

  useEffect(() => {
    const getSkills = async (id) => {
      try {
        const response = await fetch(`http://localhost:8080/getByCatid?id=${id}`);
        const data = await response.json();
        setSubcategories(data);
      } catch (error) {
        console.log(error);
      }
    };
    if (selectedCategory) {
      getSkills(selectedCategory);
    }
  }, [selectedCategory]);

  const handleCategoryChange = (event) => {
    const categoryId = event.target.value;
    setSelectedCategory(categoryId);
    setSelectedSubcategory('');
  };

  const handleSubcategoryChange = (event) => {
    setSelectedSubcategory(event.target.value);
  };

  // const handleFileUpload = (event) => {
  //   setFile(event.target.files[0]);
  // };
  
  const handleStatusChange = (val) => {
    setStatus(val);
  }
  
  const handleAboutChange = (event) => {
    setAbout(event.target.value);
  };

  const handlePriceChange = (event) => {
    setPrice(event.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    const data = {
      category_id: selectedCategory,
      about: about,
      price: price,
      status: status,
      // file: file,
    };
    
    fetch('http://localhost:8080/addportfolio', {
      method: 'POST',
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json',
      }
    })
      .then((resp) => {
        if (resp.ok) {
          console.log('Portfolio added');
          return resp.json();
        }
        throw new Error('server error');
      })
      .catch((error) => { alert("Server error,try after some time") });
  }
  
  return (
    <Container>
      <Row>
        <Col md={{ span: 6, offset: 3 }}>
          <Form onSubmit={handleSubmit}>
            <Form.Group controlId="category">
              <Form.Label>Category</Form.Label>
              <Form.Control as="select" value={selectedCategory} onChange={handleCategoryChange}>
                <option value="">Select a category</option>
                {categories.map((category) => (
                  <option key={category.category_id} value={category.category_id}>
                    {category.category_name}
                  </option>
                ))}
              </
              Form.Control>
</Form.Group>
<Form.Group controlId="subCategory">
<Form.Label>Subcategory</Form.Label>
<Form.Control as="select" value={selectedSubcategory} onChange={handleSubcategoryChange}>
<option value="">Select a subcategory</option>
{subcategories.map((subcategory) => (
<option key={subcategory.skill_id} value={subcategory.skill_id}>
{subcategory.skill_name}
</option>
))}
</Form.Control>
</Form.Group>
<Form.Group controlId="about">
<Form.Label>About</Form.Label>
<Form.Control as="textarea" rows={3} value={about} onChange={handleAboutChange} />
</Form.Group>
<Form.Group controlId="price">
<Form.Label>Price</Form.Label>
<Form.Control type="number" value={price} onChange={handlePriceChange} />
</Form.Group>
<Form.Group controlId="status">
<Form.Label>Status</Form.Label>
</Form.Group>
{/* <Form.Group controlId="file">
<Form.Label>File</Form.Label>
<Form.Control type="file" onChange={handleFileUpload} />
</Form.Group> */}
<Button variant="primary" type="submit">
Add Portfolio
</Button>
</Form>
</Col>
</Row>
</Container>
);
};

export default Portfolio;