import React from 'react';
import { Link } from "react-router-dom";
import { Container, Button } from "react-bootstrap";
import { useSpring, animated } from "react-spring";

function HomePage() {
  
  const jumbotronProps = useSpring({ opacity: 1, from: { opacity: 0 }, delay: 500 });
  const freelancersProps = useSpring({ opacity: 1, from: { opacity: 0 }, delay: 1000 });

  return (
    <div>
      <animated.div style={jumbotronProps} className="jumbotron">
        <h1>Welcome to Meet Your Need Home Page</h1>
        <p className="lead">Find the best vendors for your projects</p>
        <Link to="/register">
          <Button variant="primary">I am Client</Button>
        </Link>
        <br />
        <br />
        <Link to="/vendorregistration">
          <Button variant="primary" class="btn btn-primary btn-lg">I am Vendor</Button>
        </Link>
      </animated.div>

      <div className="container">
        <div className="row">
          <div className="col-md-8">
            <br />
            <h2>What is Meet Your Need?</h2>
            <p>Meet Your Need is a marketplace for vendors in fields like writing, graphic design and web development. The site helps professionals find projects, communicate with clients and get paid. If you're a new freelancer or new vendor, or working in a new field, you can rack up valuable experience without always having to pitch clients cold. Meet your need allows vendors can work remotely from anywhere in the world especially in India, making it easier for them to find and apply for projects. </p>
          </div>
          <div className="col-md-4">
            <animated.img style={freelancersProps} src="https://source.unsplash.com/random/400x400/?website" alt="Freelancing" className="img-fluid" />
          </div>
        </div>

        <hr />

        <div className="row">
          <div className="col-md-12">
            <h2>Why Choose Vendors?</h2>
          </div>
        </div>

        <div className="row">
          <div className="col-md-4">
            <div className="card">
              <img src="https://source.unsplash.com/random/400x400/?client" alt="Quality Work" className="card-img-top" />
              <div className="card-body">
                <h5 className="card-title">Quality Work</h5>
                <p className="card-text">Vendors are often highly skilled in their particular field, allowing them to deliver high-quality work that meets your project requirements.</p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card">
            <img src="https://source.unsplash.com/random/400x400/?freelancer" alt="Flexibility" className="card-img-top" />
<div className="card-body">
<h5 className="card-title">Flexibility</h5>
<p className="card-text">Vendors offer more flexibility than traditional employees. They can work remotely and often have more flexible schedules, allowing them to work on your project on your schedule.</p>
</div>
</div>
</div>
<div className="col-md-4">
<div className="card">
<img src="https://source.unsplash.com/random/400x400/?professional" alt="Affordability" className="card-img-top" />
<div className="card-body">
<h5 className="card-title">Affordability</h5>
<p className="card-text">Vendors often charge lower rates than traditional employees, making them a cost-effective option for projects of all sizes.</p>
</div>
</div>
</div>
</div>
<hr />

    <div className="row">
      <div className="col-md-12">
        <h2>Meet Your Need's Mission</h2>
      </div>
    </div>

    <div className="row">
      <div className="col-md-4">
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">For Clients</h5>
            <p className="card-text">Meet Your Need is committed to helping clients find the best vendors for their projects, no matter the size or scope.</p>
          </div>
        </div>
      </div>
      <div className="col-md-4">
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">For Vendors</h5>
            <p className="card-text">Meet Your Need is dedicated to helping vendors find quality projects and build their skills and portfolios.</p>
          </div>
        </div>
      </div>
      <div className="col-md-4">
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">For Both</h5>
            <p className="card-text">Meet Your Need strives to create a platform that fosters communication, collaboration and growth for both clients and vendors.</p>
          </div>
        </div>
      </div>
    </div>

    <hr />

    <div className="row">
      <div className="col-md-12">
        <h2>Join Meet Your Need Today</h2>
        <p>Sign up for Meet Your Need today and start finding the best vendors for your projects.</p>
        <Link to="/register">
          <Button variant="primary">Register Now</Button>
        </Link>
      </div>
    </div>
  </div>
</div>
);
}

export default HomePage;
