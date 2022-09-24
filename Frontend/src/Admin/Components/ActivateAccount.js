import axios from "axios"
import { useEffect, useState } from "react"
import DeactivatedUserRow from "./SubComponents/DeactivatedUserRow"

const ActivateAccount = () =>{
    const [inactiveUsers,setIncativeUsers] = useState([])

    useEffect(() =>{
        getAllInActiveUsers()
    },[])
    const getAllInActiveUsers = () =>{
        const url = "http://localhost:8080"
        axios.get(url+"/users/inactiveUsers").then(Response =>{
            const result = Response.data
            // console.log("ActivateAccount : "+result)
            if(result.status == "success"){
                setIncativeUsers(result.data)
            }
        })
        //console.log(inactiveUsers)
    } 
    return(
        
        <div className="container">
            
            <table className="table table-responsive">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Designation</th>
                    <th>Email</th>
                    <th>Contact No.</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {
                    inactiveUsers.map((user) =>{
                        return <DeactivatedUserRow key={user.email} u={user} />
                    })
                }
            </tbody>
            </table>
        </div>
    )
}

export default ActivateAccount