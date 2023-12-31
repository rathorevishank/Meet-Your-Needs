<section className="freelancer-section">
  <Container>
    <h2>Our Top Freelancers</h2>
    <Slider {...sliderSettings}>
      {freelancerImages.map(freelancer => (
        <div key={freelancer.id}>
          <img src={freelancer.url} alt={`Freelancer ${freelancer.id}`} />
        </div>
      ))}
    </Slider>
  </Container>
</section>
