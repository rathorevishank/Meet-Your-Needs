import { Button } from "@mui/material";
import PendingRequest from "./pendingRequest";
import RequestForm from "./Request";


function Client(){

    
    return(
        <div>
            <Button href="/completedProjects">Completed Porjects</Button>
            <Button href="/pendingreq">Check old Requests</Button>
            <RequestForm/>
        </div>
    )
}

export default Client;