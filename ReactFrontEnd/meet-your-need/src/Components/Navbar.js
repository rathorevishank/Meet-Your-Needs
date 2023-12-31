import React from 'react';
import { Nav } from 'react-bootstrap';
import { useNavigate, } from 'react-router';
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import { Stack } from '@mui/system';
import '../Css/layout.css'
import { Divider } from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import InfoIcon from '@mui/icons-material/Info';
import PhoneIcon from '@mui/icons-material/Phone';
import LoginIcon from '@mui/icons-material/Login';
import LogoutIcon from '@mui/icons-material/Logout';
import AddCircleIcon from '@mui/icons-material/AddCircle';



function Navigation() {

    const Item = styled(Paper)(({ theme }) => ({
        backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
        ...theme.typography.body2,
        padding: theme.spacing(1),
        textAlign: 'center',
        color: theme.palette.text.secondary,
    }));

    const isLoggedIn = localStorage.getItem('user') !== null;
    const navigate = useNavigate();
    const handleLogout = () => {
        localStorage.removeItem('user');
        navigate("/login");
    };

    return (
        <div className='class="d-flex p-2"'>
            <Box sx={{ flexGrow: 1, height: '90vh' }}
                style={{
                    float: 'left',
                    paddingLeft: '20px',
                    paddingRight: '30px',
                    paddingTop: '50px',
                    bgcolor: '#5fe5f5',
                    marginRight: '20px'
                }}>
                <Stack spacing={2}>
                    <Item>
                        <Nav.Link href="/">
                            <HomeIcon />
                            <br />
                            Home
                        </Nav.Link></Item>

                    <Item>
                        <Nav.Link href="/about">
                            <InfoIcon /><br />
                            About
                        </Nav.Link></Item>
                    <Item>
                        <Nav.Link href="/contact">
                            <PhoneIcon /><br />
                            Contact Us
                        </Nav.Link></Item>
                    {isLoggedIn ?
                        <Item>
                            <Nav.Link onClick={handleLogout}>
                                <LoginIcon /><br />
                                Logout
                            </Nav.Link></Item> :
                        <Item>
                            <Nav.Link href="/login">
                                <LogoutIcon /><br />
                                Login
                            </Nav.Link></Item>}

                    {isLoggedIn ?
                        <div></div> :
                        <Item>
                            <Nav.Link href="/register">
                                <AddCircleIcon /><br />
                                Register
                            </Nav.Link></Item>}
                </Stack>
            </Box>
            <Divider orientation="vertical">
            </Divider>

        </div>
    );
}

export default Navigation;
