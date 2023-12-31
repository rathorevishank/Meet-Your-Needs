import React, { useState } from 'react';

const PortfolioForm = () => {
  const [experience, setExperience] = useState('');
  const [about, setAbout] = useState('');
  const [pricePerHour, setPricePerHour] = useState(0);
  const [file, setFile] = useState(null);

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // TODO: Submit form data to server
  };

  return (
    <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
      <label>
        Experience:
        <input type="text" value={experience} onChange={event => setExperience(event.target.value)} />
      </label>
      <br />
      <label>
        About:
        <textarea value={about} onChange={event => setAbout(event.target.value)} />
      </label>
      <br />
      <label>
        Price per Hour:
        <input type="number" value={pricePerHour} onChange={event => setPricePerHour(event.target.value)} />
      </label>
      <br />
      <label>
        Upload File:
        <input type="file" onChange={handleFileChange} />
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>

  );
};

export default PortfolioForm;
