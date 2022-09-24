import axios from "axios"
import { useEffect, useState } from "react"
import FeeRecordRows from "./SubComponents/FeeRecordRow"

const FeeRecords = () =>{
    const [records,setRecords] = useState([])

    const url = "http://localhost:8080"
    useEffect(() =>{
        getFeeRecords()
    },[])

    const getFeeRecords = () =>{
        axios.get(url+"/student/getFeeRecords").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setRecords(result.data)
            }
        })
    }

    return(
        <div className="container">

            <table class="table">
                <thead>
                    <tr>
                        <th>Registration Id</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Class</th>
                        <th>Email</th>
                        <th>Contact No</th>
                        <th>Fees Paid</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        records.map((record) =>{
                            return <FeeRecordRows r={record} />
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}
export default FeeRecords