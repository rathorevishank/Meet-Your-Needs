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
import { format } from 'date-fns'
import parseISO from "date-fns/parseISO";

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



const CompletedProjects = () => {
  const loggedInUser = JSON.parse(localStorage.getItem("userdata"));
  const [req, setReq] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    fetch('http://localhost:8080/getProject')
      .then(response => response.json())
      .then(data => { setReq(data) })
  },[])

  const handleButtonClick = (event) => {
      localStorage.setItem('projectid', Number(event.target.id));
      navigate('/feedback');
  }

  return (
    <div style={{ float: "inline-start", marginTop: '20px' }}>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 700 }} aria-label="customized table">
          <TableHead>
            <TableRow>
              <StyledTableCell>Project Name</StyledTableCell>
              <StyledTableCell align="right">Vendor</StyledTableCell>
              <StyledTableCell align="right">Category</StyledTableCell>
              <StyledTableCell align="right">Cost</StyledTableCell>
              <StyledTableCell align="right">Posted on</StyledTableCell>
              <StyledTableCell align="right">Completed on</StyledTableCell>
              <StyledTableCell align="right"></StyledTableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {req.map((request) => (
              <StyledTableRow key={request.projectId}>
                <StyledTableCell component="th" scope="request">
                  {request.responseId.reqid.title}
                </StyledTableCell>
                <StyledTableCell align="right">{request.responseId.vid.userid.firstName}&nbsp;{request.responseId.vid.userid.lastName}</StyledTableCell>
                <StyledTableCell align="right">{request.responseId.reqid.category.category_name}</StyledTableCell>
                <StyledTableCell align="right">{request.responseId.reqid.budget}</StyledTableCell>
                <StyledTableCell align="right">{request.responseId.reqid.rdate}</StyledTableCell>
                <StyledTableCell align="right">{format(parseISO(request.startTime), 'dd/mm/yyyy')}</StyledTableCell>
                <StyledTableCell align="right"><Button id={request.projectId} variant="outlined" onClick={handleButtonClick}>Give Feedback</Button></StyledTableCell>
              </StyledTableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  )
}

export default CompletedProjects;
