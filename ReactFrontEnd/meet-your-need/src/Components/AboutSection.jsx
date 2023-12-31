import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


function AboutSection() {
  return (
    <section id="about" className="bg-light">
      <Container>
        <Row>
          <Col lg={12} className="text-center">
            <h2>About Us</h2>
            <hr className="my-4" />
          </Col>
        </Row>
        <Row>
          <Col >
            <p>Meet Your Need is a marketplace for vendors in fields like writing, graphic design and web development. The site helps professionals find projects, communicate with clients and get paid. If you're a new freelancer or new vendor, or working in a new field, you can rack up valuable experience without always having to pitch clients cold. Meet your need allows vendors can work remotely from anywhere in the world especially in India, making it easier for them to find and apply for projects. </p>
          </Col>
          
        </Row>
      </Container>
    </section>
  );
}

export default AboutSection;
