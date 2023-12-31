import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Homepage from './Components/Homepage';
import Loginn from './Components/Login';
import { Navbar, Nav } from 'react-bootstrap';
import VendorHome from './Components/Vendor/VendorHome';
import AdminHome from './Components/AdminHome';
import ForgotPassword from './Components/forgotPassword';
import FormWithValidation from './Components/FormWithValidation';
import Navigation from './Components/Navbar';
import RequestForm from './Components/client/Request';
import { Link } from '@mui/material';
import VendorRegistration from './Components/VendorRegistration';
import Client from './Components/client/ClientHome';
import AboutSection from './Components/AboutSection';
import VendorResponse from './Components/client/Responses';
import PortfolioForm from './Components/PortfolioForm';
import CompletedProjects from './Components/client/CompletedProjects';
import Feedback from './Components/client/ratingrequest';
import PortfolioDetails from './Components/Vendor/vendorDetail';
import Contact from './Components/ContactForm';
import Thanks from './Components/Thanks';
import PaymentForm from './Components/Payment';
import PendingRequest from "./Components/client/pendingRequest";
import Portfolio from './Components/Portfolio';


function App() {
  return (
    
    <div className='bg-glass'>
      
      <div className="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5" style={{backgroundColor:"#00ABE4"}}>
                <Link href='/' underline="none">
                    <div style={{ fontSize: '30px', fontFamily: 'Courgette', color: '#FFFFFF' }}>
                        Meet Your Need
                    </div></Link>
            </div>
            <Navigation/>
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/port" element={<PortfolioDetails />} />
        <Route path="/login" element={<Loginn />} />
        <Route path="/client" element={<Client/>}>
        </Route>
        <Route path="/request" element={<RequestForm />} />
        <Route path="/admin" element={<AdminHome />} />
        <Route path="/vendor" element={<VendorHome />} />
        <Route path="/register" element={<FormWithValidation />} />
        <Route path='/password' element={<ForgotPassword />} />
        <Route path ="/about" element={<AboutSection/>} />
        <Route path="/vendorregistration" element={<VendorRegistration/>} />
        <Route path="/PortfolioForm" element={<Portfolio/>} />
        <Route path="/responses" element={<VendorResponse/>} />
        <Route path="/completedProjects" element={<CompletedProjects/>} />
        <Route path="/feedback" element={<Feedback/>} />
        <Route path="/contact" element={<Contact/>} />
        {/* <Route path='/veninfo' element={<VendorHome} */}
        {/* <Route path="/client/feedbackrequest" element={<RatingForm/>}/> */}
        <Route path="/thanks" element={<Thanks/>}/>
        <Route path="/payment" element={<PaymentForm/>}/>
        <Route path="/pendingreq" element={<PendingRequest/>}/>
      </Routes>
    </div>
  );
}

export default App;
