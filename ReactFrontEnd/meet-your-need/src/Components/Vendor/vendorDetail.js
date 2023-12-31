import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import { styled } from '@mui/material/styles';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import { Rating } from '@mui/material';

function PortfolioDetails() {
  const [feedback, setFeedback] = useState([])

  useEffect(() => {
    fetch("http://localhost:8080/getfeedback")
      .then(response => response.json())
      .then(data => { setFeedback(data); console.log(data); console.log(data[0].rating); })
  }, [])

  const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: 14,
    },
}));


  return (
    <div>
      <StyledTableCell align="center" sx={{ width: 200 }}>Project</StyledTableCell>
          <StyledTableCell align="center" sx={{ width: 200 }}>Client</StyledTableCell>
          <StyledTableCell align="center" sx={{ width: 200 }}>Rating</StyledTableCell>
          <StyledTableCell align="center" sx={{ width: 300 }}>Comment</StyledTableCell>
      {feedback.map((request) => (<div>
          <StyledTableCell align="center"  sx={{ width: 200 }}>{request.projectId.responseId.reqid.title}</StyledTableCell>
          <StyledTableCell align="center"  sx={{ width: 200 }}>{request.projectId.responseId.reqid.client.userId.firstName}&nbsp;{request.projectId.responseId.reqid.client.userId.lastName}</StyledTableCell>
          <StyledTableCell align="center" sx={{ width: 200 }}><Rating name="read-only" value={request.rating} readOnly /></StyledTableCell>
          <StyledTableCell align="center" sx={{ width: 300 }}>{request.comment}</StyledTableCell>
          </div>
      ))}
    </div>
  )
}

export default PortfolioDetails;
