import axios from "axios"
import { useEffect, useState } from "react"
import EditUsersRow from "./SubComponents/EditUsersRow"

const EditUsers = () =>{
    const[nonAdminUsers,setNonAdminUsers] = useState([])

    useEffect(() =>{
        getAllNonAdminUsers()
    },[])
    const getAllNonAdminUsers = () =>{
        const url = "http://localhost:8080"
        axios.get(url+"/users/getAllUsersExceptAdmins").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setNonAdminUsers(result.data)
            }
        })
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
                        nonAdminUsers.map((user) =>{
                            return <EditUsersRow key={user.email}  u={user} />
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default EditUsers