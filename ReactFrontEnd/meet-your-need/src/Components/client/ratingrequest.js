import React, { useState } from "react";
import { Rating } from "@mui/material";
import { TextField, Button } from "@mui/material";
import "bootstrap/dist/css/bootstrap.min.css";
import "../../Css/styles.css";
import { useNavigate } from "react-router";

function Feedback() {
  const [rating, setRating] = useState(0);
  const [comments, setComments] = useState("");
  const project = JSON.parse(localStorage.getItem('projectid'))
  const navigate = useNavigate();

  const handleRatingChange = (event, newValue) => {
    setRating(newValue);
  };

  const handleCommentsChange = (event) => {
    setComments(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(`Submitting feedback: ${rating} stars, ${comments}`);
    
    const reqOption = {
        method: "post",
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({ rating: rating, comment: comments, projectId : project })
      }
      fetch("http://localhost:8080/sendfeedback", reqOption)
        .then(resp => {
          if (resp.ok) {
            console.log("requset sent");
            navigate('/completedProjects')
          }
          else
            throw new Error("server error");
        })
        .catch((error) => { alert("server error,try after some time") });
  };

  return (
    <div className="feedback-container">
      <h2>Leave Feedback</h2>
      <form onSubmit={handleSubmit}>
        <div className="rating-container">
          <Rating
            name="rating"
            value={rating}
            onChange={handleRatingChange}
            precision={0.5}
          />
        </div>
        <div className="comments-container">
          <TextField
            label="Comments"
            multiline
            rows={4}
            variant="outlined"
            value={comments}
            onChange={handleCommentsChange}
          />
        </div>
        <br/>
        <div className="submit-container">
          <Button variant="contained" color="primary" type="submit">
            Submit
          </Button>
        </div>
      </form>
    </div>
  );
}

export default Feedback;
