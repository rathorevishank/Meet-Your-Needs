import React, { useState, useEffect } from 'react';
import { Link } from '@mui/material';
import { useNavigate } from 'react-router';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Button } from "@mui/material";
import { styled } from '@mui/material/styles';

function VendorResponse() {

  const [resp, setResp] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    const reqid = Number(localStorage.getItem('reqid'));
    fetch('http://localhost:8080/getResByReq?id=' + reqid)
      .then(response => response.json())
      .then(data => { setResp(data) })
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

  const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },

    // hide last border
    '&:last-child td, &:last-child th': {
      border: 0,
    },
  }));

  const handlevendor = (event) => {
    // console.log()
    localStorage.setItem('vendorport', event.target.id);
    navigate('/port')
  }

  const handleButtonClick = (event) => {
    event.preventDefault();
    const reqOption = {
      method: "post",
      headers: { 'content-type': 'application/json' },
      body: JSON.stringify({ responseId: Number(event.target.id), startTime: new Date() })
    }
    fetch("http://localhost:8080/addProject", reqOption)
      .then(resp => {
        if (resp.ok) {
          const proj = resp.json();
          localStorage.setItem('projectid', Number(resp.projectId));
          //console.log(Number(proj.responseId.reqid.budget));
          //localStorage.setItem("cost", Number(proj.responseId.reqid.budget));
          navigate("/payment");
        }
        else
          throw new Error("server error");
      })
      //.catch((error) => { alert("server error,try after some time") });

    fetch('http://localhost:8080/getByResponseid?id=' + event.target.id)
    .then(response => response.json())
    .then(data => { 
      fetch("http://localhost:8080/updateReqStatus?id="+data.reqid.rid)
      .then(response => {
        if (response.ok) {
          console.log("requset sent");
        }
        else
          throw new Error("server error");
      })
     })
              navigate("/client");
  }

  return (<div>
    <div style={{ float: "inline-start", marginTop: '20px' }}>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 700 }} aria-label="customized table">
          <TableHead>
            <TableRow>
              <StyledTableCell>Vendor</StyledTableCell>
              <StyledTableCell align="right">Specialization</StyledTableCell>
              <StyledTableCell align="right">Hourly rate</StyledTableCell>
              <StyledTableCell align="right"></StyledTableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {resp.map((res) => (
              <StyledTableRow key={res.rid}>
                <StyledTableCell component="th" scope="res">
                <Button variant="text" id={res.vid} onClick={handlevendor}>{res.vid.userid.firstName}&nbsp;{res.vid.userid.lastName}</Button>
                </StyledTableCell>
                <StyledTableCell align="right">{res.vid.port.category_id.category_name}</StyledTableCell>
                <StyledTableCell align="right">{res.vid.port.price}</StyledTableCell>
                <StyledTableCell align="right"><Button id={res.rid} variant="outlined" onClick={handleButtonClick}>Assign</Button></StyledTableCell>
              </StyledTableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  </div>)
}


export default VendorResponse;
