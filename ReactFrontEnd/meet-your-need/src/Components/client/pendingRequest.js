import { useEffect, useState } from "react"
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Button } from "@mui/material";
import { Navigate, useNavigate } from "react-router";

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));



const PendingRequest = () => {
  const loggedInUser = JSON.parse(localStorage.getItem("userdata"));
  const [req, setReq] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    fetch('http://localhost:8080/pendingUserRequest?id='+loggedInUser.clientId)
      .then(response => response.json())
      .then(data => { setReq(data);console.log(data); })
  },[])

  const handleButtonClick = (event) => {
      localStorage.setItem('reqid', Number(event.target.id));
      navigate('/responses');
  }

  return (
    <div style={{ float: "inline-start", marginTop: '20px' }}>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 700 }} aria-label="customized table">
          <TableHead>
            <TableRow>
              <StyledTableCell>Customer</StyledTableCell>
              <StyledTableCell align="right">Description</StyledTableCell>
              <StyledTableCell align="right">budget</StyledTableCell>
              <StyledTableCell align="right">Posted on</StyledTableCell>
              <StyledTableCell align="right">Category</StyledTableCell>
              <StyledTableCell align="right"></StyledTableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {req.map((request) => (
              <StyledTableRow key={request.rid}>
                <StyledTableCell component="th" scope="request">
                  {request.client.userId.firstName}&nbsp;{request.client.userId.lastName}
                </StyledTableCell>
                <StyledTableCell align="right" sx={{width:400}}>{request.pid}</StyledTableCell>
                <StyledTableCell align="right">{request.budget}</StyledTableCell>
                <StyledTableCell align="right">{request.rdate}</StyledTableCell>
                <StyledTableCell align="right">{request.category.category_name}</StyledTableCell>
                <StyledTableCell align="right"><Button id={request.rid} variant="outlined" onClick={handleButtonClick}>Check Responses</Button></StyledTableCell>
              </StyledTableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  )
}

export default PendingRequest;
